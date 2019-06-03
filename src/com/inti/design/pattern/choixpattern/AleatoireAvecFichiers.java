package com.inti.design.pattern.choixpattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AleatoireAvecFichiers {

	/**
	 * Permet de relier un item aleatoire d'un fichier a chaque element d'un autre
	 * fichier sans doublons
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// fichier avec les clefs auquelles on veut assigner une valeur
		URL urlKey = AleatoireAvecFichiers.class.getResource("ListeEleves.txt");
		File fileKey = new File(urlKey.getPath());
		// fichier avec les valeurs possibles
		URL urlToPick = AleatoireAvecFichiers.class.getResource("ListeDesignPatterns.txt");
		File fileToPick = new File(urlToPick.getPath());

		// On transforme les fichiers en liste afin de pouvoir plus facilement les
		// exploiter
		List<String> listKey = fileToList(fileKey);
		List<String> listToPick = fileToList(fileToPick);

		// On verifie qu'il y a au moins un item possible par personne
		if (listToPick.size() >= listKey.size()) {
			// On affecte a chaque clef une valeur aleatoire
			for (String key : listKey) {
				// On recupere une valeur aleatoire dans la liste des valeurs a affecter
				Random rand = new Random();
				int index = rand.nextInt(listToPick.size());
				System.out.println(key + " : " + listToPick.get(index));
				// Pour eviter les doublons, on eleve la valeur de la liste
				listToPick.remove(index);
			}
		} else {
			System.out.println("Pas assez d'elements a choisir !");
		}
	}

	/**
	 * Permet de recuperer les informations d'un fichier dans une liste
	 * 
	 * @param file : le fichier a extraire
	 * @return une liste avec les informations du fichier
	 */
	private static List<String> fileToList(File file) {
		List<String> list = new ArrayList<>();
		try {
			// On ouvre le fichier
			Scanner sc = new Scanner(file);

			// On parcours tout le fichier pour recuperer chaque item
			while (sc.hasNext()) {
				list.add(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}
}
