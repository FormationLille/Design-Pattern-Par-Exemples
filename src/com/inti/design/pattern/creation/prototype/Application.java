package com.inti.design.pattern.creation.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Romain Parisot
 * 
 *         Tuto de pr�sentation du Design Pattern Prototype
 * 
 *         Le but est de comprendre comment utiliser la fonction clone() et
 *         pourquoi l'utiliser
 *
 */
public class Application {
	public static void main(String[] args) {

		// On cr�e un premier burger :
		Burger vegi = new Burger("Vegi Burger");
		vegi.addIngredient("Bun");
		vegi.addIngredient("Steak de soja");
		vegi.addIngredient("Salade");
		vegi.addIngredient("Radis");
		vegi.addIngredient("Concombre");
		vegi.addIngredient("Guacamole");
		vegi.addIngredient("Bun");

		System.out.println(vegi);
		System.out.println();

		
		// On clone ensuite ce burger pour les diff�rents clients :

		// La liste des burgers cr�es
		List<Burger> burgers = new ArrayList<Burger>();
		// La liste des clients
		String[] clients = { "Marcel", "G�rard", "Alice", "Paula" };

		// Pour chaque client, on clone le burger type et on l'ajoute � la liste des
		// burgers cr�es.
		for (int i = 0; i < clients.length; i++) {

			burgers.add((Burger) vegi.clone());

			// on peut ensuite les modifier ind�pendemment :
			burgers.get(i).setNom(vegi.getNom() + " de " + clients[i]);
		}

		
		// Les burgers cr��s :
		for (Burger burger : burgers) {
			System.out.println(burger);
		}

	}
}
