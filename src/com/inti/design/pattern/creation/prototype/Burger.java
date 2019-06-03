package com.inti.design.pattern.creation.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Romain Parisot
 * 
 * Voici une classe de burgers particuliers car il peuvent �tre clon�s, ce qui en facilite grandement la production
 *
 */
public class Burger implements Cloneable {
	// le nom du burger
	private String nom;
	// La liste des ingr�dients du burger
	private List<String> ingredients;

	// M�thode d'jout d'un ingr�dient :
	public void addIngredient(String ingredient) {
		this.ingredients.add(ingredient);
	}

	// M�thode de clonage du burger
	@Override
	public Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return object;
	}

	// Constructeurs
	public Burger(String nom, List<String> ingredients) {
		super();
		this.nom = nom;
		this.ingredients = ingredients;
	}

	public Burger(String nom) {
		super();
		this.nom = nom;
		this.ingredients = new ArrayList<String>();
	}

	// Accesseurs
	public List<String> getIngredients() {
		return ingredients;
	}
	
	public String getNom() {
		return nom;
	}

	// Mutateurs
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	

	// Afficheur
	@Override
	public String toString() {
		return nom + " : " + ingredients;
	}

}
