package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private ArrayList<T> parcels = new ArrayList<>();
    private int maxWeight;

    public ParcelBox(int maxWeight){
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel){
        int sumWeight = parcel.getWeight();
        for (T t : parcels) {
            sumWeight += t.getWeight();
        }
        if (sumWeight > maxWeight)
            System.out.println("Если добавить посылку, коробка будет слишком тяжелой");
        // Насколько часто вы в работе используете конструкции if else без фигурных скобок?

        else {
            parcels.add(parcel);
            System.out.println("Положили посылку в коробку");
        }
    }

    public void getAllParcels(){
        for (T parcel : parcels) {
            System.out.println("Посылка " + parcel.getDescription());
            System.out.println("Вес " + parcel.getWeight());
        }
    }

    protected ArrayList<T> getParcels() {
        return parcels;
    }
    // Чатик подсказал, что нарушается инкапсуляция, если метод public...
    // ..."Это позволяет внешнему коду сделать:
    /// standartParcelBox.getParcels().clear();"
}
