package design.patterns.behavioral.decorator.withoutDecorator;

public class MargheritaWithExtraCheesePizza extends MargheritaPizza {

    private int costOfExtraCheeseTopping;

    public MargheritaWithExtraCheesePizza() {
        this.costOfExtraCheeseTopping = 50;
    }

    @Override
    public int cost() {
        return super.cost() + this.costOfExtraCheeseTopping;
    }
}
