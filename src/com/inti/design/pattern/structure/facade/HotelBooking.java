package com.inti.design.pattern.structure.facade;

public class HotelBooking implements HotelBookingInterface{

	@Override
	public void book() {
	
		System.out.println("Hotel booked successfully");
	}

}
