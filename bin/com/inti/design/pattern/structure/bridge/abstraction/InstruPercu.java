package com.inti.design.pattern.structure.bridge.abstraction;

import com.inti.design.pattern.structure.bridge.implementation.OrdrePrix;

public class InstruPercu extends Instrument {

	public String nom;

	public InstruPercu(OrdrePrix ordrePrix, String nom) {
		super(ordrePrix);
		this.nom = nom;
	}

	@Override
	public void assigner() {
		System.out.println(nom + ", ordre de prix : ");
		ordrePrix.assigner();

	}

}