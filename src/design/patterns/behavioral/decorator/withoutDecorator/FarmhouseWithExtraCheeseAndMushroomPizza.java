package design.patterns.behavioral.decorator.withoutDecorator;

public class FarmhouseWithExtraCheeseAndMushroomPizza extends FarmhousePizza {
    private int costOfExtraCheeseTopping;
    private int costOfExtraMushroomTopping;

    public FarmhouseWithExtraCheeseAndMushroomPizza() {
        this.costOfExtraCheeseTopping = 50;
        this.costOfExtraMushroomTopping = 45;
    }

    @Override
    public int cost() {
        return super.cost() + costOfExtraMushroomTopping + costOfExtraCheeseTopping;
    }
}
