package com.inti.design.pattern.comportement.iterator;

	import java.util.Iterator;

	public class NameRepository implements Container {
	   public String noms[] = {"Yann" , "Florian" ,"Antoine" , "Taoufik"};

	   @Override
	   public Iterator getIterator() {
	      return new NameIterator();
	   }

	   private class NameIterator implements Iterator {

	      int index;

	      @Override
	      public boolean hasNext() {
	      
	         if(index < noms.length){
	            return true;
	         }
	         return false;
	      }

	      @Override
	      public Object next() {
	      
	         if(this.hasNext()){
	            return noms[index++];
	         }
	         return null;
	      }		
	   }
	}