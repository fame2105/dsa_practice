package design.patterns.behavioral.strategy.withStrategyPattern;

import design.patterns.behavioral.strategy.withStrategyPattern.strategies.SportsModeStrategy;

public class OffroadVehicle extends Vehicle {

    public OffroadVehicle() {
        super(new SportsModeStrategy());
    }
}
