package ch4.somecode;

import ch4.somecode.pizza.CheesePizza;
import ch4.somecode.pizza.Pizza;
import ch4.somecode.pizza.VeggiePizza;

public class SimplePizzaFactory {
    
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        // part which was getting modified - start
        if(type == "cheese") {
            pizza = new CheesePizza();
        }
        else if(type == "veggie") {
            pizza = new VeggiePizza();
        }
        // ... so on
        // part which was getting modified - end

        return pizza;
    }
}
