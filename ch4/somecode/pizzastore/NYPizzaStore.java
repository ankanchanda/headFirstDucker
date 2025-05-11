package ch4.someCode.pizzastore;

import ch4.someCode.pizza.Pizza;
import ch4.someCode.pizza.franchiseBased.NYStyleCheesePizza;
import ch4.someCode.pizza.franchiseBased.NYStylePepperoniPizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (type.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else return null;
    }
    
}
