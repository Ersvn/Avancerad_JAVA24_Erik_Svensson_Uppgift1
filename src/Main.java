import Miscellaneous.CarPark;
import Interface.Vehicle;
import java.util.Scanner;

public class Main {
    private static final String bold = "\033[1m";
    private static final String reset = "\033[0m";

    public static void main(String[] args) {
        CarPark carPark = new CarPark();
        Scanner scanner = new Scanner(System.in);

        System.out.println(bold + "Welcome Car Rental AB!" + reset);
        carPark.displayCars();

        int returnChoice;
/*-----------------------------------Fixa metoder istället för nestade if-satser-----------------------------------*/
        while(true) {
            System.out.println("\nSelect a car with the numbers 1-6." + "\nTo return a car, press 0." + "\nType '-1' to exit the program.");
            System.out.print("Type your input here: "); int choice = scanner.nextInt();

            if(choice == -1) {
                System.out.println("Thank you for visiting! Have a great day!");
                break;
            } else if(choice == 0) {
                System.out.print("Which car would you like to return?" + "\nEnter the number on the car you are returning, 1-6: ");
                returnChoice = scanner.nextInt();
                if (returnChoice > 0 && returnChoice <= carPark.getCarParkSize()) {
                    Vehicle returnedCar = carPark.getCar(returnChoice - 1);
                    if (!returnedCar.isAvailable()) {
                        System.out.print("How many days did you rent it for?");
                        int rentalDays = scanner.nextInt();

                        double rentalCost = returnedCar.getPricePerDay() * rentalDays;
                        System.out.println("The price will be: " + rentalCost + "$");

                        returnedCar.setAvailable(true);

                        System.out.print("\nThank you for choosing us, would you like your receipt? ");
                        String receiptChoice = scanner.next();

                        if (receiptChoice.equalsIgnoreCase("yes")) {
                            System.out.println("-----RECEIPT-----" + "\nCar rented: " + returnedCar + "\nDays rented: " + rentalDays + "\nTotal: " + rentalCost + "$");
                        } else if(receiptChoice.equalsIgnoreCase("no")) {
                            System.out.println("Thank you, come again!");
                        }
                    } else {
                        System.out.println("\nThere seems to be an issue, the car you chose is already in our car park." + "\nPlease try again: ");
                        carPark.displayCars();
                    }
                }
            } else if(choice > 0 && choice <= carPark.getCarParkSize()){
                Vehicle selectedCar = carPark.getCar(choice - 1);
                selectedCar.displayDetails();

                if(selectedCar.isAvailable()) {
                    System.out.print("\nWould you like to rent this car?" + "\nOnly write yes or no:");
                    String CarChoice = scanner.next();
                    if(CarChoice.equalsIgnoreCase("yes"))
                    {
                        selectedCar.setAvailable(false);
                        System.out.println("\nThis car has a day price of: " + selectedCar.getPricePerDay() + "$");
                        System.out.println("\nHave fun, we hope you enjoy the car.");
                        break;
                    }
                    else if(CarChoice.equalsIgnoreCase("no"))
                    {
                        selectedCar.setAvailable(true);
                        System.out.print("Would you like to rent another car? Exit with -1");
                        int CarChoice2 = scanner.nextInt();
                        if(CarChoice2 == -1) {
                            break;
                        }
                    } else {
                        System.out.println("Invalid input,");
                    }
                }
            }
        }
        scanner.close();
    }
}
