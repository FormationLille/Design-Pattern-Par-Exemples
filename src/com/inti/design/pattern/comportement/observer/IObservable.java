package com.inti.design.pattern.comportement.observer;

public interface IObservable {

	public void addObserver(IObserver o);

	public void removeObserver(IObserver o);

	public void notifyObservers();

}
