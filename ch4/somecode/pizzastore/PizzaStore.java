package ch4.somecode.pizzastore;
import ch4.somecode.factory.SimplePizzaFactory;
import ch4.somecode.pizza.Pizza;

public class PizzaStore {

    private SimplePizzaFactory factory;

    public PizzaStore (SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = this.factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
