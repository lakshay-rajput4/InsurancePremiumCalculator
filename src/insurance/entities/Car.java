package insurance.entities;

import insurance.enums.*;

public class Car {

    private CarType carType;
    private String model;
    private InsuranceType insuranceType;
    private double carPrice;

    public Car(CarType carType, String model, InsuranceType insuranceType, double carPrice) {
        this.carType = carType;
        this.model = model;
        this.insuranceType = insuranceType;
        this.carPrice = carPrice;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return "Car [carType=" + carType + ", model=" + model + ", insuranceType=" + insuranceType + ", carPrice="
                + carPrice + "]";
    }
}
