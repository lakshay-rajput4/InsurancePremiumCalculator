import java.util.Scanner;
import insurance.entities.Car;
import insurance.enums.CarType;
import insurance.enums.InsuranceType;
import insurance.calculator.InsuranceCalculator;
import insurance.exception.InvalidInputException;
import insurance.validation.CarValidator;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InsuranceCalculator insuranceCalculator = new InsuranceCalculator();
        CarValidator carValidator = new CarValidator();

        boolean continueProgram = true;

        while (continueProgram) {
            try {
                CarType carType = getCarType(scanner);
                String model = getCarModel(scanner);
                InsuranceType insuranceType = getInsuranceType(scanner);
                double carPrice = getCarPrice(scanner);

                Car car = new Car(carType, model, insuranceType, carPrice);

                // Validating car object
                carValidator.validateCar(car);

                // Calculating insurance premium
                double premium = insuranceCalculator.calculatePremium(car);
                System.out.println("Insurance Premium: $" + premium);

            } catch (InvalidInputException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid input. Please enter valid values.");
                // Handling the error and continue to give chance to user for input again
                continue;
            }

            // Asking user if they want to continue or exit
            System.out.println("Do you want to calculate another insurance premium? (yes/no)");
            String continueOption = scanner.nextLine().toLowerCase();

            if (!continueOption.equals("yes")) {
                continueProgram = false;
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Insurance Premium Calculator.");
    }

    private static CarType getCarType(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter car type (SEDAN, HATCHBACK, SUV): ");
                String carTypeStr = scanner.nextLine().trim().toUpperCase();
                return CarType.valueOf(carTypeStr);
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid car type. Please enter a valid car type.");
            }
        }
    }

    private static String getCarModel(Scanner scanner) {
        while (true) {
            System.out.println("Enter car model: ");
            String model = scanner.nextLine().trim();
            if (model.matches("^[a-zA-Z0-9 ]+$")) {
                return model;
            } else {
                System.err.println("Invalid car model. Please enter a valid model name.");
            }
        }
    }

    private static InsuranceType getInsuranceType(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter insurance type (BASIC or PREMIUM): ");
                String insuranceTypeStr = scanner.nextLine().trim().toUpperCase();
                return InsuranceType.valueOf(insuranceTypeStr);
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid insurance type. Please enter a valid insurance type.");
            }
        }
    }

    private static double getCarPrice(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter car price: ");
                double carPrice = scanner.nextDouble();
                scanner.nextLine();
                return carPrice;
            } catch (Exception e) {
                System.err.println("Invalid car price. Please enter a valid number.");
                scanner.next();
            }
        }
    }
}
