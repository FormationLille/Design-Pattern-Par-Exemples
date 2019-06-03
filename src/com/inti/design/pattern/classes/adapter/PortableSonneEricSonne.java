package com.inti.design.pattern.classes.adapter;

public class PortableSonneEricSonne {

	//Portable se chargeant avec du 10Volts.
	public void chargerBatteries(int volts) {
		System.out.println("Portable SonneEricSonne en charge");
		System.out.println("voltage : " + volts + "\n");
	}
}
