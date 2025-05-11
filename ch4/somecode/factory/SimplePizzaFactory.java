package ch4.someCode.factory;

import ch4.someCode.pizza.CheesePizza;
import ch4.someCode.pizza.ClamPizza;
import ch4.someCode.pizza.PepperoniPizza;
import ch4.someCode.pizza.Pizza;
import ch4.someCode.pizza.VeggiePizza;

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
