package com.inti.design.pattern.comportement.memento;

public class Memento {
	private String nomDeQuelqunDeLaFormation;

	public Memento(String nomDeQuelqunDeLaFormation) {
		this.nomDeQuelqunDeLaFormation = nomDeQuelqunDeLaFormation;
	}

	public String getNomDeQuelqunDeLaFormation() {
		return nomDeQuelqunDeLaFormation;
	}
}
