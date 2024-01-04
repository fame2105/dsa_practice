package design.patterns.structural.adapter.Adaptee;

public class WeighingMachineForAdults implements WeighingMachine {

    @Override
    public double getWeightInPounds() {
        return 198;
    }
}
