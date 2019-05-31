package tuto.bridge.abstraction;

import tuto.bridge.implementation.OrdrePrix;

public abstract class Instrument {

	protected OrdrePrix ordrePrix; // on utilise l'interface OrdrePrix

	public Instrument(OrdrePrix ordrePrix) {
		super();
		this.ordrePrix = ordrePrix;
	}

	public abstract void assigner();

}