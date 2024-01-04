package design.patterns.behavioral.decorator.withDecorator;

public class MushroomTopping extends ToppingDecorator {
    private BasePizza basePizza;
    private int cost; // cost of extra Mushrooms topping

    public MushroomTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
        this.cost = 45;
    }

    @Override
    public int cost() {
        return basePizza.cost() + this.cost;
    }
}
