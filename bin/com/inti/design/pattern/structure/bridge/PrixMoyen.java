package com.inti.design.pattern.structure.bridge.implementation;

public class PrixMoyen implements OrdrePrix { // classes de mise en œuvre du Bridge

	@Override
	public void assigner() {
		System.out.println(" prix moyen ");

	}
}