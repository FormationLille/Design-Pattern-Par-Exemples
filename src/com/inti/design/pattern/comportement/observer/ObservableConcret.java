package com.inti.design.pattern.comportement.observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableConcret implements IObservable {

	private List<IObserver> observers = new ArrayList<>();

	private int temperature;

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

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
		notifyObservers();
	}

}
