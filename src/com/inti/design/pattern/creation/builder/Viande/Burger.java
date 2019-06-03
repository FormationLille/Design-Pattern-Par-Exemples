package Viande;

import Emaballage.Item;
import Emaballage.Packing;
import Emaballage.Wrapper;

public abstract class Burger implements Item {
	@Override
	   public Packing packing() {
	      return new Wrapper();
	   }

	   @Override
	   public abstract float price();
	
}
