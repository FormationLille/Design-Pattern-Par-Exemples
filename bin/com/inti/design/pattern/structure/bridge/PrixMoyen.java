package com.inti.design.pattern.structure.bridge.implementation;

public class PrixMoyen implements OrdrePrix { // classes de mise en �uvre du Bridge

	@Override
	public void assigner() {
		System.out.println(" prix moyen ");

	}
}