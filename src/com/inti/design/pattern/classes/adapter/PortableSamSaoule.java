package com.inti.design.pattern.classes.adapter;

public class PortableSamSaoule {

	//Portable se chargeant avec du 5Volts.
	public void chargerPortable(int volts) {
		System.out.println("Portable SamSaoul en charge");
		System.out.println("voltage : " + volts + "\n");
	}
}
