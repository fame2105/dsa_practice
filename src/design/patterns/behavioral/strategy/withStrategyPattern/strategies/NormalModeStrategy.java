package design.patterns.behavioral.strategy.withStrategyPattern.strategies;

public class NormalModeStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Normal Driving Mode");
    }
}
