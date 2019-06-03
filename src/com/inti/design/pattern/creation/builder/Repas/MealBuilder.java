package Repas;

import Boisson.Coke;
import Boisson.Pepsi;
import Viande.PouletBurger;
import Viande.VegBurger;

public class MealBuilder {
	public Meal prepareVegMeal (){
	      Meal meal = new Meal();
	      meal.addItem(new VegBurger());
	      meal.addItem(new Coke());
	      return meal;
	   }   

	   public Meal prepareNonVegMeal (){
	      Meal meal = new Meal();
	      meal.addItem(new PouletBurger());
	      meal.addItem(new Pepsi());
	      return meal;
	   }
}
