package com.inti.design.pattern.comportement.memento;

public class MementoPatternDemo {
	public static void main(String[] args) {
		Originator originator = new Originator();
		ListeDeNosObjetsSauvegardes ListeDesNoms = new ListeDeNosObjetsSauvegardes();
		originator.setNomDeQuelqunDeLaFormation("Yann Marson");
		originator.setNomDeQuelqunDeLaFormation("Antoine Storme");
		ListeDesNoms.add(originator.saveNomDeQuelqunDeLaFormationToMemento());
		originator.setNomDeQuelqunDeLaFormation("Noémie Eliazord");
		ListeDesNoms.add(originator.saveNomDeQuelqunDeLaFormationToMemento());
		originator.setNomDeQuelqunDeLaFormation("Florian Ledunkerquois");
		System.out.println("Nom ajouté en dernier :  " + originator.getNomDeQuelqunDeLaFormation());
		originator.getNomDeQuelqunDeLaFormationFromMemento(ListeDesNoms.get(0));
		System.out.println("Premier nom sauvegardé : " + originator.getNomDeQuelqunDeLaFormation());
		originator.getNomDeQuelqunDeLaFormationFromMemento(ListeDesNoms.get(1));
		System.out.println("Deuxième nom sauvegardé : " + originator.getNomDeQuelqunDeLaFormation());
	}
}