package design.patterns.behavioral.strategy.withoutStrategyPattern;

public class OffroadVehicle extends Vehicle{
    @Override
    public void drive() { // Code duplication ... same as SportsVehicle
        System.out.println("Sports Driving Mode");
    }
}
