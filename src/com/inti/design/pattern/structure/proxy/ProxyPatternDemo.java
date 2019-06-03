package com.inti.design.pattern.structure.proxy;

public class ProxyPatternDemo {
	
	public static void main(String[] args) {
		
		Image image = new ProxyImage("test_10mb.jpg");

		// L'image sera charg�e
		image.display(); 
		System.out.println("");
	      
		// L'image ne sera pas charg�e
		image.display(); 	
	}
}
