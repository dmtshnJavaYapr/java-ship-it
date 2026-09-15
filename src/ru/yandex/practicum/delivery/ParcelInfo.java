package ru.yandex.practicum.delivery;

public class ParcelInfo{
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;


    public ParcelInfo(String deliveryAddress, String description, int sendDay, int weight) {
        this.deliveryAddress = deliveryAddress;
        this.description = description;
        this.sendDay = sendDay;
        this.weight = weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDescription() {
        return description;
    }

    public int getSendDay() {
        return sendDay;
    }

    public int getWeight() {
        return weight;
    }
}
