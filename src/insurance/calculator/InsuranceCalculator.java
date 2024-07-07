package insurance.calculator;

import insurance.exception.InvalidInputException;
import insurance.entities.Car;
import insurance.enums.InsuranceType;
import insurance.validation.CarValidator;

public class InsuranceCalculator {

    public double calculatePremium(Car car) throws InvalidInputException {
        CarValidator validator = new CarValidator();
        validator.validateCar(car);

        CarPremiumCalculator calculator = CarPremiumCalculatorFactory.getCalculator(car.getCarType());
        double basicPremium = calculator.calculateBasicPremium(car);

        if (car.getInsuranceType() == InsuranceType.BASIC) {
            return basicPremium;
        } else if (car.getInsuranceType() == InsuranceType.PREMIUM) {
            return basicPremium + (basicPremium * 0.02);
        } else {
            throw new InvalidInputException("Unknown insurance type.");
        }
    }
}
