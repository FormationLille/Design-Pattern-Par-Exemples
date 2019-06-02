package com.inti.design.pattern.structure.bridge;

import com.inti.design.pattern.structure.bridge.abstraction.*;
import com.inti.design.pattern.structure.bridge.implementation.*;

public class Application {

	/*
	 * on utilise l'interface OrdrePrix pour assigner un ordre de prix à chaque
	 * instrument.
	 */

	public static void main(String[] args) {
		Instrument instr1 = new InstruVent(new PetitPrix(), "Flûte à bec");
		instr1.assigner();

		Instrument instr2 = new InstruCordes(new PrixMoyen(), "Guitar Fender");
		instr2.assigner();

		Instrument instr3 = new InstruPercu(new PrixEleve(), "Batterie Pearl");
		instr3.assigner();

	}

}