package design.patterns.behavioral.strategy.withStrategyPattern;

import design.patterns.behavioral.strategy.withStrategyPattern.strategies.DriveStrategy;

public class Vehicle {

    DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}
