package ch4.someCode.postPrinciple.ingredientsFactories;

import ch4.someCode.postPrinciple.ingredients.Cheese;
import ch4.someCode.postPrinciple.ingredients.Clams;
import ch4.someCode.postPrinciple.ingredients.Dough;
import ch4.someCode.postPrinciple.ingredients.Pepperoni;
import ch4.someCode.postPrinciple.ingredients.Sauce;
import ch4.someCode.postPrinciple.ingredients.Veggies;

public interface PizzaIngredientFactory {
    public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
}
