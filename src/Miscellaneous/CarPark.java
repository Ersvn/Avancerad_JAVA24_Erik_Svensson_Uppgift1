package Miscellaneous;
import Interface.Vehicle;
import CarTypes.SportCar;
import CarTypes.SUV;
import CarTypes.Sedan;
import java.util.ArrayList;
import java.util.List;

public class CarPark {
    private final List<Vehicle> rentalCars;
    private static final String bold = "\033[1m";
    private static final String reset = "\033[0m";

    public CarPark() {
        rentalCars = new ArrayList<>();

        rentalCars.add(new SportCar("Ferrari", "Red", "F12", "Gasoline", "Automatic", 1000, true, 2));
        rentalCars.add(new SportCar("Aston Martin", "Grey", "DB9", "Gasoline", "Automatic", 150, false, 4));

        rentalCars.add(new SUV("Lincoln", "Light grey", "Navigator", "Diesel", "Manual", 30000, true, 7));
        rentalCars.add(new SUV("Volvo", "White", "XC90", "Hybrid", "Automatic", 5200, true, 7));

        rentalCars.add(new Sedan("Volvo", "Black", "V90", "Diesel", "Automatic", 7600, false, 5));
        rentalCars.add(new Sedan("Audi", "Red", "A5", "Gasoline", "Automatic", 220000, true, 5));
    }

    public void displayCars() {
        System.out.println("Available Cars in the Car Park:");
        for (int i = 0; i < rentalCars.size(); i++) {
            Vehicle car = rentalCars.get(i);
            System.out.println((i + 1) + ". " + car.getBrand() + " " + car.getModel() + " - Available: " + bold + (car.isAvailable() ? "Yes" : "No" + reset));
        }
    }

    public Vehicle getCar(int index) {
        for (int i = 0; i < rentalCars.size(); i++) {
            if (i == index) {
                return rentalCars.get(i);
            }
        }
        return null;
    }

    public int getCarParkSize() {
        return rentalCars.size();
    }
}
