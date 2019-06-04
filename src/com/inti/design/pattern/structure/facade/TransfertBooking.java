package com.inti.design.pattern.structure.facade;

public class TransfertBooking implements TransfertBookingInterface{

	@Override
	public void book() {
		
		System.out.println("Transfert booked successfully");
	}

}
