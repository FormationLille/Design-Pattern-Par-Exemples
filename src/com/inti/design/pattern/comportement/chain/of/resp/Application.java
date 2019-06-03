package com.inti.design.pattern.comportement.chain.of.resp;

public class Application {
	public static void main(String[] args) {

		// Création des maillons
		Maillon lMaillonA = new MaillonA();
		Maillon lMaillonB = new MaillonB();
		Maillon lMaillonC = new MaillonC();

		// Définition de l'enchainement des maillons
		lMaillonA.setSuivant(lMaillonB);
		lMaillonB.setSuivant(lMaillonC);

		// Appel de la méthode du premier maillon
		// avec des valeurs différentes
		System.out.println("--> Appel de la méthode avec paramètre '1' : ");
		lMaillonA.operation(1);
		System.out.println("--> Appel de la méthode avec paramètre '2' : ");
		lMaillonA.operation(2);
		System.out.println("--> Appel de la méthode avec paramètre '3' : ");
		lMaillonA.operation(3);
		System.out.println("--> Appel de la méthode avec paramètre '4' : ");
		lMaillonA.operation(4);

	}

}