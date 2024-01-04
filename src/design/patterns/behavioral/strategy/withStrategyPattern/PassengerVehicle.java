package design.patterns.behavioral.strategy.withStrategyPattern;

import design.patterns.behavioral.strategy.withStrategyPattern.strategies.NormalModeStrategy;

public class PassengerVehicle extends Vehicle {

    public PassengerVehicle() {
        super(new NormalModeStrategy());
    }
}
