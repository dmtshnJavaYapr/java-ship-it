public class FragileParcel extends Parcel implements Trackable{
    private static final int DELIVERY_COST = 4;

    public FragileParcel(String deliveryAddress, String description, int sendDay, int weight) {
        super(deliveryAddress, description, sendDay, weight);
    }

    @Override
    void packageItem(){
        IO.println("Посылка " + getDescription() + " Обёрнута в защитную пленку");
        super.packageItem();
    }

    @Override
    int getDeliveryCost(){
        return DELIVERY_COST;
    }

    @Override
    int calculateDeliveryCost(){
        return DELIVERY_COST * getWeight();
    }

    @Override
    public void reportStatus(String newLocation){
        IO.println("Хрупкая посылка " + getDescription() + " изменила местоположение на " +
                newLocation);
    }
}
