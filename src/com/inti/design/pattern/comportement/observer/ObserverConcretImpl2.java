package com.inti.design.pattern.comportement.observer;

public class ObserverConcretImpl2 implements IObserver {

	@Override
	public void update(IObservable o) {

		int etat = ((ObservableConcret) o).getEtat();

		System.out.println("  Température ressentie " + (etat - 2));
	}

}
