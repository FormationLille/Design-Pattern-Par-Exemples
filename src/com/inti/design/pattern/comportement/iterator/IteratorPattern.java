package com.inti.design.pattern.comportement.iterator;

	import java.util.Iterator;

	public class IteratorPattern {
	
	   public static void main(String[] args) {
	      NameRepository namesRepository = new NameRepository();

	      for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
	         String nom = (String)iter.next();
	         System.out.println("Nom : " + nom);
	      } 	
	   }
	}