package ch4.somecode.factory;

import ch4.somecode.pizza.CheesePizza;
import ch4.somecode.pizza.ClamPizza;
import ch4.somecode.pizza.PepperoniPizza;
import ch4.somecode.pizza.Pizza;
import ch4.somecode.pizza.VeggiePizza;

public class SimplePizzaFactory {
    
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        // part which was getting modified - start
        if(type.equals("cheese")) {
            pizza = new CheesePizza();
        }
        else if(type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        else if(type.equals("clam")) {
            pizza = new ClamPizza();
        }
        else if(type.equals("pepperonni")) {
            pizza = new PepperoniPizza();
        }
        // part which was getting modified - end

        return pizza;
    }
}
