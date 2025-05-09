package ch4.somecode;

import ch4.somecode.pizza.CheesePizza;
import ch4.somecode.pizza.Pizza;
import ch4.somecode.pizza.VeggiePizza;

public class PizzaStore {

    public PizzaStore () {}

    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        // part which is getting modified - start
        if(type == "cheese") {
            pizza = new CheesePizza();
        }
        else if(type == "veggie") {
            pizza = new VeggiePizza();
        }
        // ... so on
        // part which is getting modified - end

        // the above has to be moved out since it will be varying
        // with new additions or deletions

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
