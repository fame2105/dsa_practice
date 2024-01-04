package design.patterns.behavioral.decorator.withDecorator;

public class FreshVeggiePizza extends BasePizza{

    private int cost;

    public FreshVeggiePizza() {
        this.cost = 220;
    }

    @Override
    public int cost() {
        return this.cost;
    }
}
