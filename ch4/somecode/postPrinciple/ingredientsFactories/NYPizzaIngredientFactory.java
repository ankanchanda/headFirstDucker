package ch4.someCode.postPrinciple.ingredientsFactories;

import ch4.someCode.postPrinciple.ingredients.Cheese;
import ch4.someCode.postPrinciple.ingredients.Clams;
import ch4.someCode.postPrinciple.ingredients.FreshClams;
import ch4.someCode.postPrinciple.ingredients.Dough;
import ch4.someCode.postPrinciple.ingredients.ThinCrustDough;
import ch4.someCode.postPrinciple.ingredients.Pepperoni;
import ch4.someCode.postPrinciple.ingredients.SlicedPepperoni;
import ch4.someCode.postPrinciple.ingredients.Sauce;
import ch4.someCode.postPrinciple.ingredients.ReggianoCheese;
import ch4.someCode.postPrinciple.ingredients.Veggies;
import ch4.someCode.postPrinciple.ingredients.Garlic;
import ch4.someCode.postPrinciple.ingredients.MarinaraSauce;
import ch4.someCode.postPrinciple.ingredients.Onion;
import ch4.someCode.postPrinciple.ingredients.Mushroom;
import ch4.someCode.postPrinciple.ingredients.RedPepper;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
