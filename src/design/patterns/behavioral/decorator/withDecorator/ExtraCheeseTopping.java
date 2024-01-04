package design.patterns.behavioral.decorator.withDecorator;

public class ExtraCheeseTopping extends ToppingDecorator {
    private BasePizza basePizza;
    private int cost; // cost of ExtraCheese topping

    public ExtraCheeseTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
        this.cost = 50;
    }

    @Override
    public int cost() {
        return basePizza.cost() + this.cost;
    }
}
