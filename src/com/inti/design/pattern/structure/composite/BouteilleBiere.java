package com.inti.design.pattern.structure.composite;

public class BouteilleBiere implements Bouteilles{
	private int nombreB;

	public BouteilleBiere(int nbre) {
		this.nombreB = nbre;
	}
	@Override
	public int NbrBouteilles() {
		return this.nombreB;
	}
}

