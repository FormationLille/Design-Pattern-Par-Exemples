package com.inti.design.pattern.comportement.observerV2;

public class ObserverConcretImpl1 implements IObserver {

	@Override
	public void update(int etat) {

		System.out.println("Température actuelle: " + etat + "°C");

	}

}

