package com.inti.design.pattern.comportement.observerV2;

public interface IObservable {

	public void addObserver(IObserver o);

	public void removeObserver(IObserver o);

	public void notifyObservers();

}
