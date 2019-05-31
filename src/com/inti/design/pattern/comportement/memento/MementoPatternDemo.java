package com.inti.design.pattern.comportement.memento;

public class MementoPatternDemo {
	public static void main(String[] args) {
		Originator originator = new Originator();
		ListeDeNosObjetsSauvegardes ListeDesNoms = new ListeDeNosObjetsSauvegardes();
		originator.setNomDeQuelqunDeLaFormation("Yann Marson");
		originator.setNomDeQuelqunDeLaFormation("Antoine Storme");
		ListeDesNoms.add(originator.saveNomDeQuelqunDeLaFormationToMemento());
		originator.setNomDeQuelqunDeLaFormation("No�mie Eliazord");
		ListeDesNoms.add(originator.saveNomDeQuelqunDeLaFormationToMemento());
		originator.setNomDeQuelqunDeLaFormation("Florian Ledunkerquois");
		System.out.println("Nom ajout� en dernier :  " + originator.getNomDeQuelqunDeLaFormation());
		originator.getNomDeQuelqunDeLaFormationFromMemento(ListeDesNoms.get(0));
		System.out.println("Premier nom sauvegard� : " + originator.getNomDeQuelqunDeLaFormation());
		originator.getNomDeQuelqunDeLaFormationFromMemento(ListeDesNoms.get(1));
		System.out.println("Deuxi�me nom sauvegard� : " + originator.getNomDeQuelqunDeLaFormation());
	}
}