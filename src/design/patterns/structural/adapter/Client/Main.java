package design.patterns.structural.adapter.Client;

import design.patterns.structural.adapter.Adaptee.WeighingMachineForAdults;
import design.patterns.structural.adapter.Adaptee.WeighingMachineForBabies;
import design.patterns.structural.adapter.Adapter.WeighingMachineAdapter;
import design.patterns.structural.adapter.Adapter.WeighingMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        // Client wants to get their weight in Kg.
        WeighingMachineAdapter weighingMachineAdapter1 = new WeighingMachineAdapterImpl(new WeighingMachineForAdults());
        System.out.println(weighingMachineAdapter1.getWeightInKg());

        WeighingMachineAdapter weighingMachineAdapter2 = new WeighingMachineAdapterImpl(new WeighingMachineForBabies());
        System.out.println(weighingMachineAdapter2.getWeightInKg());
    }
}
