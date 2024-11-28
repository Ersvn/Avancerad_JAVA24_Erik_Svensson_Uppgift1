package Interface;


public abstract class Vehicle implements CarInterface{
    protected String brand;
    protected String color;
    protected String model;
    protected String fuelType;
    protected String gears;
    protected double mileage;
    protected boolean isAvailable;
    protected int seatAmount;
    protected double pricePerDay;


    public Vehicle(String brand, String color, String model, String fuelType,
                   String gears, double mileage, boolean isAvailable, int seatAmount) {
        this.brand = brand;
        this.color = color;
        this.model = model;
        this.fuelType = fuelType;
        this.gears = gears;
        this.mileage = mileage;
        this.isAvailable = isAvailable;
        this.seatAmount = seatAmount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Gears: " + gears);
        System.out.println("Mileage: " + mileage + " km");
        System.out.println("Seats: " + seatAmount);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("Price per day: " + pricePerDay + "$");
    }
}
