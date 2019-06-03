package com.inti.design.pattern.creation.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Romain Parisot
 * 
 *         Tuto de présentation du Design Pattern Prototype
 * 
 *         Le but est de comprendre comment utiliser la fonction clone() et
 *         pourquoi l'utiliser
 *
 */
public class Application {
	public static void main(String[] args) {

		// On crée un premier burger :
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

		
		// On clone ensuite ce burger pour les différents clients :

		// La liste des burgers crées
		List<Burger> burgers = new ArrayList<Burger>();
		// La liste des clients
		String[] clients = { "Marcel", "Gérard", "Alice", "Paula" };

		// Pour chaque client, on clone le burger type et on l'ajoute à la liste des
		// burgers crées.
		for (int i = 0; i < clients.length; i++) {

			burgers.add((Burger) vegi.clone());

			// on peut ensuite les modifier indépendemment :
			burgers.get(i).setNom(vegi.getNom() + " de " + clients[i]);
		}

		
		// Les burgers créés :
		for (Burger burger : burgers) {
			System.out.println(burger);
		}

	}
}
