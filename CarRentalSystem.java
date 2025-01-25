import java.util.ArrayList;
import java.util.Scanner;

class Car {
    private String carId;
    private String model;
    private boolean isRented;

    public Car(String carId, String model) {
        this.carId = carId;
        this.model = model;
        this.isRented = false;
    }

    public String getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rentCar() {
        isRented = true;
    }

    public void returnCar() {
        isRented = false;
    }
}

public class CarRentalSystem {
    private static ArrayList<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        initializeCars();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Car Rental System ---");
            System.out.println("1. View Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableCars();
                    break;
                case 2:
                    rentCar(scanner);
                    break;
                case 3:
                    returnCar(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the Car Rental System!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void initializeCars() {
        cars.add(new Car("C001", "Toyota Corolla"));
        cars.add(new Car("C002", "Honda Civic"));
        cars.add(new Car("C003", "Ford Mustang"));
        cars.add(new Car("C004", "Tesla Model 3"));
        cars.add(new Car("C005", "BMW X5"));
    }

    private static void viewAvailableCars() {
        System.out.println("\nAvailable Cars:");
        for (Car car : cars) {
            if (!car.isRented()) {
                System.out.println("Car ID: " + car.getCarId() + ", Model: " + car.getModel());
            }
        }
    }

    private static void rentCar(Scanner scanner) {
        System.out.print("\nEnter the Car ID to rent: ");
        String carId = scanner.next();

        for (Car car : cars) {
            if (car.getCarId().equalsIgnoreCase(carId)) {
                if (!car.isRented()) {
                    car.rentCar();
                    System.out.println("You have successfully rented the car: " + car.getModel());
                } else {
                    System.out.println("Sorry, this car is already rented.");
                }
                return;
            }
        }
        System.out.println("Invalid Car ID! Please try again.");
    }

    private static void returnCar(Scanner scanner) {
        System.out.print("\nEnter the Car ID to return: ");
        String carId = scanner.next();

        for (Car car : cars) {
            if (car.getCarId().equalsIgnoreCase(carId)) {
                if (car.isRented()) {
                    car.returnCar();
                    System.out.println("You have successfully returned the car: " + car.getModel());
                } else {
                    System.out.println("This car was not rented.");
                }
                return;
            }
        }
        System.out.println("Invalid Car ID! Please try again.");
    }
}