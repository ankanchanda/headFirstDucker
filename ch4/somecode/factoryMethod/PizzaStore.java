package ch4.someCode.factoryMethod;

import ch4.someCode.pizza.Pizza;
import ch4.someCode.pizza.franchiseBased.ChicagoStylePepperoniPizza;
import ch4.someCode.pizza.franchiseBased.ChicagoStyleVeggiePizza;
import ch4.someCode.pizza.franchiseBased.NYStyleCheesePizza;
import ch4.someCode.pizza.franchiseBased.NYStylePepperoniPizza;

public class PizzaStore {
    public Pizza createPizza(String style, String type) {
        Pizza pizza = null;

        if(style.equals("NY")) {
            if(type.equals("cheese")) {
                pizza = new NYStyleCheesePizza();
            }
            else if(type.equals("pepperoni")) {
                pizza = new NYStylePepperoniPizza();
            }
        } else if (style.equals("Chicago")) {
            if(type.equals("pepperoni")) {
                pizza = new ChicagoStylePepperoniPizza();
            }
            else if(type.equals("veggie")) {
                pizza = new ChicagoStyleVeggiePizza();
            }
        }

        if(pizza == null) {
            System.out.println("Error: invalid type or style of pizza");
            return null;
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
