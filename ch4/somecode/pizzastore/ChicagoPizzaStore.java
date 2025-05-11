package ch4.somecode.pizzastore;

import ch4.somecode.pizza.Pizza;
import ch4.somecode.pizza.franchiseBased.ChicagoStylePepperoniPizza;
import ch4.somecode.pizza.franchiseBased.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("veggie")) {
            return new ChicagoStyleVeggiePizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else
            return null;
    }
}
