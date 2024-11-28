package CarTypes;
import Interface.Vehicle;


public class Sedan extends Vehicle {
    public Sedan(String brand, String color, String model, String fuelType,
                 String gears, double mileage, boolean available, int seatAmount)
    {
        super(brand, color, model, fuelType, gears, mileage, available, seatAmount);
        this.pricePerDay = 150.0;
    }


}
