package com.inti.design.pattern.comportement.observer;

public class ObserverConcretImpl2 implements IObserver {

	@Override
	public void update(IObservable o) {

		int etat = ((ObservableConcret) o).getEtat();

		System.out.println("  Temp�rature ressentie " + (etat - 2));
	}

}
