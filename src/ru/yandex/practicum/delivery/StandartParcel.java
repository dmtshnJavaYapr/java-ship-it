public class StandartParcel extends Parcel {
    private static final int DELIVERY_COST = 2;

    public StandartParcel(String deliveryAddress, String description, int sendDay, int weight) {
        super(deliveryAddress, description, sendDay, weight);
    }

    @Override
    int getDeliveryCost(){
        return DELIVERY_COST;
    }

    @Override
    int calculateDeliveryCost(){
        return DELIVERY_COST * getWeight();
    }
}
