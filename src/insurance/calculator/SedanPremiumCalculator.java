package insurance.calculator;

import insurance.entities.Car;

public class SedanPremiumCalculator implements CarPremiumCalculator {
    @Override
    public double calculateBasicPremium(Car car) {
        return car.getCarPrice() * 0.02;
    }
}
