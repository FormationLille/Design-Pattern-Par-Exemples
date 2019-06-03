package com.inti.design.pattern.comportement.memento;

public class Originator {
	private String nomDeQuelqunDeLaFormation;

	public void setNomDeQuelqunDeLaFormation(String nomDeQuelqunDeLaFormation) {
		this.nomDeQuelqunDeLaFormation = nomDeQuelqunDeLaFormation;
	}

	public String getNomDeQuelqunDeLaFormation() {
		return nomDeQuelqunDeLaFormation;
	}

	public Memento saveNomDeQuelqunDeLaFormationToMemento() {
		return new Memento(nomDeQuelqunDeLaFormation);
	}

	public void getNomDeQuelqunDeLaFormationFromMemento(Memento memento) {
		nomDeQuelqunDeLaFormation = memento.getNomDeQuelqunDeLaFormation();
	}
}
