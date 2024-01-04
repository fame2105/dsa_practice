package design.patterns.NullObjectPattern;

public class Car implements Vehicle {
    private int tankCapacity;
    private int seatingCapacity;

    public Car(int tankCapacity, int seatingCapacity) {
        this.tankCapacity = tankCapacity;
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public int getTankCapacity() {
        return this.tankCapacity;
    }

    @Override
    public int getSeatingCapacity() {
        return this.seatingCapacity;
    }
}
