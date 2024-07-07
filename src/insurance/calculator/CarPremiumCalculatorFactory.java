package insurance.calculator;

import insurance.enums.CarType;
import insurance.exception.InvalidInputException;

public class CarPremiumCalculatorFactory {

    public static CarPremiumCalculator getCalculator(CarType carType) throws InvalidInputException {
        switch (carType) {
            case SEDAN:
                return new SedanPremiumCalculator();
            case HATCHBACK:
                return new HatchbackPremiumCalculator();
            case SUV:
                return new SuvPremiumCalculator();
            default:
                throw new InvalidInputException("Unknown car type.");
        }
    }
}
