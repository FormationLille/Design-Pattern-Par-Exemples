package com.inti.design.pattern.structure.composite;

public class BouteilleVin implements Bouteilles {
	private int nombreV;

	public BouteilleVin(int nbre) {
		this.nombreV = nbre;
	}
	@Override
	public int NbrBouteilles() {
		return this.nombreV;
	}

}
