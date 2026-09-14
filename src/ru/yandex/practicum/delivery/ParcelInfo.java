public class ParcelInfo extends Parcel {

    public ParcelInfo(String deliveryAddress, String description, int sendDay, int weight) {
        super(deliveryAddress, description, sendDay, weight);
    }

    @Override
    public int getDeliveryCost(){
        return Integer.parseInt(null);
    }

    @Override
    public int calculateDeliveryCost(){
        return Integer.parseInt(null);
    }
}
