package design.patterns.NullObjectPattern;

public class VehicleFactory {

    public static Vehicle getVehicleObject(String carType) {
        if("CAR".equals(carType)) {
            return new Car(40, 5);
        }

        return new NullVehicle();
    }
}
