# InsurancePremiumCalculator
This project is a Java-based insurance premium calculator that computes insurance premiums based on various factors such as car type, car model, insurance type, and car price. It provides two types of insurance plans: BASIC and PREMIUM, with different premium calculation rules for each car type.

Project Structure
The project is structured into several packages and classes to maintain organization and separation of concerns:

insurance.entities: Contains the Car entity class representing a car with properties such as car type, model, insurance type, and price.

insurance.enums: Includes enums for CarType (SEDAN, HATCHBACK, SUV) and InsuranceType (BASIC, PREMIUM) used throughout the project.

insurance.validation: Contains CarValidator class for validating input data such as car type, insurance type, and car price.

insurance.calculator: Houses the core logic of premium calculation:

CarPremiumCalculator: Interface defining the method for calculating basic premium.
SedanPremiumCalculator, HatchbackPremiumCalculator, SuvPremiumCalculator: Implementations of CarPremiumCalculator for specific car types.
CarPremiumCalculatorFactory: Factory class to create appropriate CarPremiumCalculator based on car type.
insurance.exception: Defines InvalidInputException for handling invalid input scenarios.

Main: Contains the main method to run the application, interact with users, and demonstrate the functionality of the insurance premium calculator.
