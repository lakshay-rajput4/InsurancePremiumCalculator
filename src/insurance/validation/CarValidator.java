package insurance.validation;

import insurance.entities.Car;
import insurance.enums.CarType;
import insurance.enums.InsuranceType;
import insurance.exception.InvalidInputException;

public class CarValidator {

    public void validateCar(Car car) throws InvalidInputException {
        try {
            // Validating car type
            CarType.valueOf(car.getCarType().toString()); // car type should be a valid enum

            // Validating insurance type
            InsuranceType.valueOf(car.getInsuranceType().toString()); // insurance type should be a valid enum

            // Validating car price
            if (car.getCarPrice() <= 0) {
                throw new InvalidInputException("Car price must be greater than zero.");
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException("Invalid input: " + e.getMessage());
        }
    }
}
