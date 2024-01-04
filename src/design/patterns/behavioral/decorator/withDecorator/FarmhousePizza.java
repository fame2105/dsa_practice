package design.patterns.behavioral.decorator.withDecorator;

public class FarmhousePizza extends BasePizza{
    private int cost;

    public FarmhousePizza() {
        this.cost = 250;
    }

    @Override
    public int cost() {
        return this.cost;
    }
}
