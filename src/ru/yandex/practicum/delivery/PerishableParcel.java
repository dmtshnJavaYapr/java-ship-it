public class PerishableParcel extends Parcel{
    private static final int DELIVERY_COST = 3;
    private int timeToLive;

    public PerishableParcel(String deliveryAddress, String description, int sendDay,
                         int weight, int timeToLive) {
        super(deliveryAddress, description, sendDay, weight);
        this.timeToLive = timeToLive;
    }

    @Override
    int getDeliveryCost(){
        return DELIVERY_COST;
    }

    public boolean isExpired(int currentDay){
        if (getSendDay() + timeToLive >= currentDay)
            return false;

        else
            return true;
    }

    @Override
    int calculateDeliveryCost(){
        return DELIVERY_COST * getWeight();
    }
}
