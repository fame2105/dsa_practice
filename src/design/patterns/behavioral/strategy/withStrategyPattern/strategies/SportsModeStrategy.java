package design.patterns.behavioral.strategy.withStrategyPattern.strategies;

public class SportsModeStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Sports Driving Mode");
    }
}
