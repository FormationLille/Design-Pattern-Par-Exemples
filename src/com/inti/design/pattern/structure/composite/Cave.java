package com.inti.design.pattern.structure.composite;

	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Iterator;

	public class Cave implements Bouteilles{
		private Collection elements;

		public Cave() {
			elements = new ArrayList();
		}

		public void remove(Bouteilles bouteille) {
			elements.remove(bouteille);
		}

		public void add(Bouteilles bouteille) {
			elements.add(bouteille);
		}

		public Iterator getElements() {
			return elements.iterator();
		}
		@Override
		public int NbrBouteilles() {
			int result = 0;
			for (Iterator i = elements.iterator(); i.hasNext(); ) {
				Object objet = i.next();
				Bouteilles bouteille = (Bouteilles)objet;
				result += bouteille.NbrBouteilles();
			}
			return result;
		}

	}
