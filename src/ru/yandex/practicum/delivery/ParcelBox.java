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
            IO.println("Если добавить посылку, коробка будет слишком тяжелой");
        // Насколько часто вы в работе используете конструкции if else без фигурных скобок?

        else {
            parcels.add(parcel);
            IO.println("Положили посылку в коробку");
        }
    }

    public void getAllParcels(){
        for (T parcel : parcels) {
            IO.println("Посылка " + parcel.getDescription());
            IO.println("Вес " + parcel.getWeight());
        }
    }

    public ArrayList<T> getParcels() {
        return parcels;
    }
}
