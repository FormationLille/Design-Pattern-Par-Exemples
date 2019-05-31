package tuto.bridge.abstraction;

import tuto.bridge.implementation.OrdrePrix;

public class InstruVent extends Instrument {

	public String nom;

	public InstruVent(OrdrePrix ordrePrix, String nom) {
		super(ordrePrix);
		this.nom = nom;
	}

	@Override
	public void assigner() {
		System.out.println(nom + ", ordre de prix :");
		ordrePrix.assigner();

	}
}