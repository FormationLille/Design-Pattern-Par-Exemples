package com.inti.design.pattern.comportement.observerV2;

public class ObserverConcretImpl2 implements IObserver {

	@Override
	public void update(int etat) {

		

		System.out.println("  Température ressentie " + (etat- 2));
	}

}
