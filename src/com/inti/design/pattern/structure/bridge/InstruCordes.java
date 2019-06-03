package com.inti.design.pattern.structure.bridge.abstraction;

import com.inti.design.pattern.structure.bridge.implementation.OrdrePrix;

public class InstruCordes extends Instrument {

	public String nom;

	public InstruCordes(OrdrePrix ordrePrix, String nom) {
		super(ordrePrix);
		this.nom = nom;
	}

	@Override
	public void assigner() {
		System.out.println(nom + ", ordre de prix :");
		ordrePrix.assigner();

	}

}