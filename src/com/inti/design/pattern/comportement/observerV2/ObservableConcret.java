package com.inti.design.pattern.comportement.observerV2;

import java.util.ArrayList;
import java.util.List;

public class ObservableConcret implements IObservable {

	private List<IObserver> observers = new ArrayList<>();

	private int etat;

	@Override
	public void addObserver(IObserver o) {
		observers.add(o);

	}

	@Override
	public void removeObserver(IObserver o) {
		observers.remove(o);

	}

	@Override
	public void notifyObservers() {

		for (IObserver o : observers) {
			o.update(this);

		}

	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;

		notifyObservers();
	}

}
