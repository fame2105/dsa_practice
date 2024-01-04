package design.patterns.structural.adapter.Adaptee;

// A separate type of machine is needed for weighing new born babies because they cannot stand
public class WeighingMachineForBabies implements WeighingMachine {

    @Override
    public double getWeightInPounds() {
        return 28;
    }
}
