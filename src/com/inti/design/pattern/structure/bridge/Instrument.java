package com.inti.design.pattern.structure.bridge.abstraction;

import com.inti.design.pattern.structure.bridge.implementation.OrdrePrix;

public abstract class Instrument {

	protected OrdrePrix ordrePrix;

	public Instrument(OrdrePrix ordrePrix) {
		super();
		this.ordrePrix = ordrePrix;
	}

	public abstract void assigner();

}