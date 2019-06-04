package com.inti.design.pattern.creation.prototype;

import java.util.HashMap;
import java.util.Map;

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

		System.out.println("Le burger type :");
		System.out.println(vegi);

		
		// On clone ensuite ce burger pour les différents clients :

		// La liste des burgers crées
		Map<String, Burger> burgersClone = new HashMap<String, Burger>();
		// La liste des clients
		String[] clients = { "Marcel", "Gérard", "Alice ", "Paula " };

		// Pour chaque client, on clone le burger type et on l'ajoute à la liste des burgers crées.
		for (String client : clients) {
			burgersClone.put(client, (Burger) vegi.clone());
		}

		// on peut ensuite les modifier indépendemment :
		// Alice ne veux pas de concombre dans son burger :
		burgersClone.get("Alice ").getIngredients().remove("Concombre");
		// Marcel veut un supplément de guacamole :
		burgersClone.get("Marcel").getIngredients().add(6, "Guacamole");
		
		
		// Les burgers créés :
		System.out.println("\nLes burgers clonés :");
		for (Map.Entry<String, Burger> commande : burgersClone.entrySet()) {
			System.out.println("Commande de " + commande.getKey() + " = " + commande.getValue());
	    }
		/* On remarque ici que la liste des ingrédients est la même pour tous les clients.
		 * C'est parceque le type List en java n'est pas Cloneable. On se retrouve donc ab=vec la même instance de List pour tous les Burgers.
		 * 
		 * On préfèrera donc créer notre propre méthode de copie des burgers afin de palier à ce problème.
		 */
		
		// Même exemple avec la fonction copy :
		vegi = new Burger("Vegi Burger");
		vegi.addIngredient("Bun");
		vegi.addIngredient("Steak de soja");
		vegi.addIngredient("Salade");
		vegi.addIngredient("Radis");
		vegi.addIngredient("Concombre");
		vegi.addIngredient("Guacamole");
		vegi.addIngredient("Bun");
		
		Map<String, Burger> burgersCopy = new HashMap<String, Burger>();

		for (String client : clients) {
			burgersCopy.put(client, (Burger) vegi.copy());
		}

		burgersCopy.get("Alice ").getIngredients().remove("Concombre");
		burgersCopy.get("Marcel").getIngredients().add(6, "Guacamole");

		System.out.println("\nLes burgers copiés :");
		for (Map.Entry<String, Burger> commande : burgersCopy.entrySet()) {
			System.out.println("Commande de " + commande.getKey() + " = " + commande.getValue());
	    }

	}
}
