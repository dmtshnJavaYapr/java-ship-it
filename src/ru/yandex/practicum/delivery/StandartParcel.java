package ru.yandex.practicum.delivery;

public class StandartParcel extends Parcel {
    private static final int DELIVERY_COST = 2;

    public StandartParcel(String deliveryAddress, String description, int sendDay, int weight) {
        super(deliveryAddress, description, sendDay, weight);
    }

    @Override
    public int getDeliveryCost(){
        return DELIVERY_COST;
    }

    @Override
    public int calculateDeliveryCost(){
        return DELIVERY_COST * getWeight();
    }
}
