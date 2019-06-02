package com.inti.design.pattern.comportement.observerV2;

public class ObserverConcretImpl1 implements IObserver {

	@Override
	public void update(IObservable o) {

		int etat = ((ObservableConcret) o).getEtat();

		System.out.println("Température actuelle: " + etat + "°C");

	}

}

