package ch4.someCode;

import ch4.someCode.factoryMethod.PizzaStore;
import ch4.someCode.pizza.Pizza;

public class FactoryMethodPizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore();

        Pizza pizza = pizzaStore.createPizza("NY", "cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = pizzaStore.createPizza("NY", "pepperoni");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = pizzaStore.createPizza("Chicago", "pepperoni");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");
 
		pizza = pizzaStore.createPizza("Chicago", "veggie");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
