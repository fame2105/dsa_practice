package design.patterns.behavioral.strategy.withStrategyPattern.strategies;

public class OffroadModeStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Passenger Driving Mode");
    }
}
