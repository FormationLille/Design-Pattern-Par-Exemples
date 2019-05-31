package com.inti.design.pattern.comportement.memento;

import java.util.ArrayList;
import java.util.List;

public class ListeDeNosObjetsSauvegardes {
	private List<Memento> mementoList = new ArrayList<Memento>();

	public void add(Memento nomDeQuelqunDeLaFormation) {
		mementoList.add(nomDeQuelqunDeLaFormation);
	}

	public Memento get(int index) {
		return mementoList.get(index);
	}
}
