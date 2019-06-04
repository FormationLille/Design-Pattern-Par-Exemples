package com.inti.design.pattern.structure.facade;

public class FlightBooking implements FlightBookingInterface{

	@Override
	public void book() {
		
		System.out.println("Flight booked successfully");
	}

}
