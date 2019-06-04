package com.inti.design.pattern.structure.facade;

public class FacadeClient {

	public static void main(String[] args) {

		TravelPackageInterface travelPackageInterface = new TravelPackageFacade();
		travelPackageInterface.book();
	}

}
