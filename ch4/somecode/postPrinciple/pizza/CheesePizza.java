package ch4.someCode.postPrinciple.pizza;

import ch4.someCode.postPrinciple.ingredientsFactories.PizzaIngredientFactory;

public class CheesePizza extends Pizza {

    private PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + this.getName());
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
    
}
