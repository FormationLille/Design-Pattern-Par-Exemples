package com.inti.design.pattern.choixpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Aleatoire {
	public static void main(String[] args) {
		Random rand = new Random();
		
		// On cree une liste des nombres à tirer
		//	utiliser une liste nous permet de retirer les nombres une fois sortis
		List<Integer> nbrToPick = new ArrayList<Integer>();
		
		// On initialise la liste avec les nombres à tirer
		for (int i = 1; i <= 14; i++) {
			nbrToPick.add(i);
		}
		
		// Un Scanner pour sortir un nombre à chaque fois que l'on entre queqluechose dans la console
		Scanner sc = new Scanner(System.in);
		
		while (sc.next() != "end") {
			// On choisit une case aléatoire de la liste
			int index = rand.nextInt(nbrToPick.size());
			System.out.println("Le nombre choisit est le : " + nbrToPick.get(index));
			
			// on retire le nombre tiré de la liste
			nbrToPick.remove(index);
		}
		sc.close();
	}
}
