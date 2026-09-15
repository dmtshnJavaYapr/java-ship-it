package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{
    private static final int DELIVERY_COST = 4;

    public FragileParcel(String deliveryAddress, String description, int sendDay, int weight) {
        super(deliveryAddress, description, sendDay, weight);
    }

    @Override
    public void packageItem(){
        System.out.println("Посылка " + getDescription() + " Обёрнута в защитную пленку");
        super.packageItem();
    }

    @Override
    public int getDeliveryCost(){
        return DELIVERY_COST;
    }

    @Override
    public int calculateDeliveryCost(){
        return DELIVERY_COST * getWeight();
    }

    @Override
    public void reportStatus(String newLocation){
        System.out.println("Хрупкая посылка " + getDescription() + " изменила местоположение на " +
                newLocation);
    }
}
