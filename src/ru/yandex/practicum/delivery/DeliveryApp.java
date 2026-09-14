package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> allTrackables = new ArrayList<>();

    private static ParcelBox<StandartParcel> standartParcelBox =
            new ParcelBox<>(10);

    private static ParcelBox<FragileParcel> fragileParcelParcelBox =
            new ParcelBox<>(10);

    private static ParcelBox<PerishableParcel> perishableParcelParcelBox =
            new ParcelBox<>(10);


    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    showTrackables();
                    break;
                case 5:
                    changeAllTrackablesLocation();
                    break;
                case 6:
                    showParcelBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Показать посылки, поддерживающие трекинг");
        System.out.println("5 — Поменять локацию всех трекинговых посылок");
        System.out.println("6 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        IO.println("Какой тип посылки вы отправляете?");
        IO.print("1 - Обычный\n" +
                 "2 - Скоропортящийся\n" +
                 "3 - Хрупкий\n");

        int choice = Integer.parseInt(scanner.nextLine());
        ParcelInfo info = getInfo();

        if (choice == 1) {
            StandartParcel parcel = (StandartParcel) createParcel(info, choice);
            standartParcelBox.addParcel(parcel);
        }


        else if (choice == 2) {

            IO.println("Срок хранения в днях");
            int timeToLive = Integer.parseInt(scanner.nextLine());

            PerishableParcel parcel = new PerishableParcel(
                    info.getDeliveryAddress(),
                    info.getDescription(),
                    info.getSendDay(),
                    info.getWeight(),
                    timeToLive
            );

            perishableParcelParcelBox.addParcel(parcel);
        }

        else if (choice == 3) {
            FragileParcel parcel = (FragileParcel) createParcel(info, choice);
            fragileParcelParcelBox.addParcel(parcel);

            if (fragileParcelParcelBox.getParcels().contains(parcel))
                allTrackables.add(parcel);

        }

        else {
            IO.println("Неверный тип посылки");
            }
        }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.delivery();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }

        IO.println("Стоимость всей доставки " + sum);
    }

    private static void showTrackables() {
        for (Trackable parcel : allTrackables) {

            if (parcel instanceof Parcel) {
                ((Parcel) parcel).getDescription();
                IO.println("Описание" + ((Parcel) parcel).getDescription());
                IO.println("Адрес доставки" + ((Parcel) parcel).getDeliveryAddress());
            }

        }
    }

    private static void changeAllTrackablesLocation() {
        IO.println("Напишите новый адрес посылок");
        String newLocation = scanner.nextLine();
        for (Trackable parcel : allTrackables) {

            if (parcel instanceof Parcel) {
                parcel.reportStatus(newLocation);
            }

        }
    }

    private static void showParcelBox() {
        IO.println("Какую коробку открыть?");
        IO.print("1 - Обычный\n" +
                "2 - Скоропортящийся\n" +
                "3 - Хрупкий\n");

        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            for (Parcel parcel : standartParcelBox.getParcels()) {
                IO.println("Название посылки " + parcel.getDescription());
                IO.println("Вес " + parcel.getWeight());
            }
        }

        else if (choice == 2) {
            for (Parcel parcel : perishableParcelParcelBox.getParcels()) {
                IO.println("Название посылки " + parcel.getDescription());
                IO.println("Вес " + parcel.getWeight());
            }
        }

        else if (choice == 3) {
            for (Parcel parcel : fragileParcelParcelBox.getParcels()) {
                IO.println("Название посылки " + parcel.getDescription());
                IO.println("Вес " + parcel.getWeight());
            }
        }

    }

    private static ParcelInfo getInfo(){
        IO.println("Адрес доставки...");
        String address = scanner.nextLine();

        IO.println("Название посылки");
        String description = scanner.nextLine();

        IO.println("Когда нужно отправить");
        int sendDay = Integer.parseInt(scanner.nextLine());

        IO.println("Вес посылки в килограммах");
        int weight = Integer.parseInt(scanner.nextLine());

        return new ParcelInfo(address, description, sendDay, weight);
    }

    private static Parcel createParcel(ParcelInfo info, int choice) {
        if (choice == 1) {
            return new StandartParcel(
                    info.getDeliveryAddress(),
                    info.getDescription(),
                    info.getSendDay(),
                    info.getWeight()
            );
        }

        else if (choice == 3) {
            return new FragileParcel(
                    info.getDeliveryAddress(),
                    info.getDescription(),
                    info.getSendDay(),
                    info.getWeight()
            );
        }
        return null;
    }
}

