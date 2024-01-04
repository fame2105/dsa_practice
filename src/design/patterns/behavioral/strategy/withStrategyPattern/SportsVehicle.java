package design.patterns.behavioral.strategy.withStrategyPattern;

import design.patterns.behavioral.strategy.withStrategyPattern.strategies.SportsModeStrategy;

public class SportsVehicle extends Vehicle {

    public SportsVehicle() {
        super(new SportsModeStrategy());
    }
}
