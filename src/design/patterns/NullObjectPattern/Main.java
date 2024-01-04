package design.patterns.NullObjectPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicleObject("CAR");
        printVehicleDetails(vehicle);

        vehicle = VehicleFactory.getVehicleObject("BIKE");
        printVehicleDetails(vehicle);
    }

    private static void printVehicleDetails(Vehicle vehicle) {
        System.out.println("Vehicle Seating Capacity: " + vehicle.getSeatingCapacity());
        System.out.println("Vehicle Tank Capacity: " + vehicle.getTankCapacity());
    }
}
