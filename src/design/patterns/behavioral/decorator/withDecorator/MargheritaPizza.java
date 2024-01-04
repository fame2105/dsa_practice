package design.patterns.behavioral.decorator.withDecorator;

public class MargheritaPizza extends BasePizza{
    private int cost;

    public MargheritaPizza() {
        this.cost = 200;
    }

    @Override
    public int cost() {
        return this.cost;
    }
}
