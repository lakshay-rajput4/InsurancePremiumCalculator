package insurance.calculator;

import insurance.entities.Car;

public interface CarPremiumCalculator {
    double calculateBasicPremium(Car car);
}