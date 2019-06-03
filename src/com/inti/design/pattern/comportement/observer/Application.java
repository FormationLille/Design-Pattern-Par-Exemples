package com.inti.design.pattern.comportement.observer;

import com.inti.design.pattern.comportement.observer.ObservableConcret;
import com.inti.design.pattern.comportement.observer.ObserverConcretImpl2;
import com.inti.design.pattern.comportement.observer.ObserverConcretImpl1;

public class Application {

	public static void main(String[] args) {

		ObservableConcret lobservable = new ObservableConcret();
		ObserverConcretImpl1 obs1 = new ObserverConcretImpl1();
		ObserverConcretImpl2 obs2 = new ObserverConcretImpl2();

		//lobservable.setTemperature(10);

		lobservable.addObserver(obs1);
		lobservable.addObserver(obs2);

		lobservable.setTemperature(1);
		lobservable.setTemperature(5);
		lobservable.removeObserver(obs2);
		lobservable.setTemperature(10);
	}
}
