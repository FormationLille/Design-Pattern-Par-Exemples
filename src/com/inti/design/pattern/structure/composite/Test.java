package com.inti.design.pattern.structure.composite;

public class Test {

	public static void main(String[] args) {

		System.out.println("Nombre de bouteilles : ");
		System.out.println("");

		BouteilleBiere maBiere = new BouteilleBiere(10);
		System.out.println("-Bière : "+maBiere.NbrBouteilles()+" bouteilles");
		System.out.println("");

		BouteilleVin monVin = new BouteilleVin(20);
		System.out.println("-Vin : "+monVin.NbrBouteilles()+" bouteilles");

		System.out.println("");

		Cave maCave = new Cave();
		maCave.add(monVin);
		maCave.add(maBiere);
		System.out.println("-Total : "+maCave.NbrBouteilles()+" bouteilles");

	}
}
