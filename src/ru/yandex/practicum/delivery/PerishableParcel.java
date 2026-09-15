package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{
    private static final int DELIVERY_COST = 3;
    private int timeToLive;

    public PerishableParcel(String deliveryAddress, String description, int sendDay,
                         int weight, int timeToLive) {
        super(deliveryAddress, description, sendDay, weight);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getDeliveryCost(){
        return DELIVERY_COST;
    }

    public boolean isExpired(int currentDay){
        return !(getSendDay() + timeToLive >= currentDay);
        // По условию тех задания нужно вернуть false, если день отправки и срок...
        // ...годности больше текущего дня
        // критично, если вместо "!" использовать getSendDay() + timeToLive < currentDay?
    }

    @Override
    public int calculateDeliveryCost(){
        return DELIVERY_COST * getWeight();
    }
}
