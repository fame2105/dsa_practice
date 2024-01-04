package design.patterns.behavioral.decorator.withDecorator;

public class Main {
    public static void main(String[] args) {
        BasePizza farmhouse = new FarmhousePizza();
        System.out.println("Cost of FarmhousePizza is : " + farmhouse.cost());


        BasePizza farmhouseWithExtraCheese = new ExtraCheeseTopping(new FarmhousePizza());
        System.out.println("Cost of FarmhousePizza with ExtraCheeseTopping is : " + farmhouseWithExtraCheese.cost());


        BasePizza margheritaWithExtraMushroomsAndExtraCheese = new MushroomTopping(new ExtraCheeseTopping(new MargheritaPizza()));
        System.out.println("Cost of MargheritaPizza with ExtraCheese and ExtraMushrooms topping is : " + margheritaWithExtraMushroomsAndExtraCheese.cost());
    }
}
