package design.patterns.structural.adapter.Adapter;

import design.patterns.structural.adapter.Adaptee.WeighingMachine;

public class WeighingMachineAdapterImpl implements WeighingMachineAdapter {
    private WeighingMachine weighingMachine;

    public WeighingMachineAdapterImpl(WeighingMachine weighingMachine) {
        this.weighingMachine = weighingMachine;
    }

    @Override
    public double getWeightInKg() {
        double weightInPounds = weighingMachine.getWeightInPounds();

        // Convert it to Kg
        double weightInKg = weightInPounds * .45;
        return weightInKg;
    }
}
