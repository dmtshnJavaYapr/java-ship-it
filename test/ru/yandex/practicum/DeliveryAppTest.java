import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryAppTest {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> allTrackables = new ArrayList<>();


    @Test
    public void shouldBe16ForCalculateDeliveryCostForStandardParcel() {
        StandartParcel parcel = new StandartParcel("Address",
                "Description", 10, 8);
        assertEquals(16, parcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBe15ForCalculateDeliveryCostForPerishableParcel() {
        PerishableParcel parcel = new PerishableParcel("Address",
                "Description", 10, 5, 5);
        assertEquals(15, parcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBe20ForCalculateDeliveryCostForFragileParcel() {
        FragileParcel parcel = new FragileParcel("Address",
                "Description", 10, 5);
        assertEquals(20, parcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBeExpiredFor5TimeToLiveAnd9CurrentDaysAnd3SendDay(){
        PerishableParcel parcel = new PerishableParcel("Address",
                "Description", 3, 8, 5);
        assertTrue(parcel.isExpired(9));
    }

    @Test
    public void shouldNotBeExpiredFor5TimeToLiveAnd14CurrentDaysAnd9SendDay(){
        PerishableParcel parcel = new PerishableParcel("Address",
                "Description", 9, 8, 5);
        assertFalse(parcel.isExpired(14));
    }

    @Test
    public void ShouldBeAddTwoParcelToParcelBoxWith3And6Kg(){
        ParcelBox<StandartParcel> standardParcelBox = new ParcelBox<>(10);
        standardParcelBox.addParcel(new StandartParcel("Address", "Description",
                10, 3));
        standardParcelBox.addParcel(new StandartParcel("Address", "Description",
                10, 6));

        ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(10);
        perishableParcelBox.addParcel(new PerishableParcel("Address", "Description",
                10, 3, 1));
        perishableParcelBox.addParcel(new PerishableParcel("Address", "Description",
                10, 6, 1));

        ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(10);
        fragileParcelBox.addParcel(new FragileParcel("Address", "Description",
                10, 3));
        fragileParcelBox.addParcel(new FragileParcel("Address", "Description",
                10, 6));


        assertEquals(2, standardParcelBox.getParcels().size());
        assertEquals(2, perishableParcelBox.getParcels().size());
        assertEquals(2, fragileParcelBox.getParcels().size());
    }

    @Test
    public void ShouldBeAddOnlyOneParcelToParcelBoxWith5And6Kg(){
        ParcelBox<StandartParcel> standardParcelBox = new ParcelBox<>(10);
        standardParcelBox.addParcel(new StandartParcel("Address", "Description",
                10, 5));
        standardParcelBox.addParcel(new StandartParcel("Address", "Description",
                10, 6));

        ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(10);
        perishableParcelBox.addParcel(new PerishableParcel("Address", "Description",
                10, 5, 1));
        perishableParcelBox.addParcel(new PerishableParcel("Address", "Description",
                10, 6, 1));

        ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(10);
        fragileParcelBox.addParcel(new FragileParcel("Address", "Description",
                10, 5));
        fragileParcelBox.addParcel(new FragileParcel("Address", "Description",
                10, 6));


        assertEquals(1, standardParcelBox.getParcels().size());
        assertEquals(1, perishableParcelBox.getParcels().size());
        assertEquals(1, fragileParcelBox.getParcels().size());
    }


}
