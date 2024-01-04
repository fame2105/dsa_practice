package design.patterns.behavioral.strategy.withStrategyPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle sportsVehicle = new SportsVehicle();
        System.out.print("Sports Vehicle: ");
        sportsVehicle.drive();

        Vehicle passengerVehicle = new PassengerVehicle();
        System.out.print("Passenger Vehicle: ");
        passengerVehicle.drive();
    }
}
