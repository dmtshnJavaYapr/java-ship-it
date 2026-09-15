package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;

    public Parcel(String deliveryAddress, String description, int sendDay, int weight) {
        this.deliveryAddress = deliveryAddress;
        this.description = description;
        this.sendDay = sendDay;
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void packageItem(){
        System.out.println("Посылка " + getDescription() + " упакована");
    }

    public void delivery(){
        System.out.println("Посылка " + getDescription() + " доставлена по адресу "
                + getDeliveryAddress());
    }

    public abstract int getDeliveryCost();

    public int getSendDay() {
        return sendDay;
    }

    public int getWeight() {
        return weight;
    }

    public abstract int calculateDeliveryCost();

}
