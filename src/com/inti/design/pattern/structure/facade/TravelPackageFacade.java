package com.inti.design.pattern.structure.facade;

public class TravelPackageFacade implements TravelPackageInterface{

	@Override
	public void book() {
		TransfertBookingInterface transfertBookingInterface = new TransfertBooking();
		transfertBookingInterface.book();
		
		HotelBookingInterface hotelBookingInterface = new HotelBooking();
		hotelBookingInterface.book();
		
		FlightBookingInterface flightBookingInterface = new FlightBooking();
		flightBookingInterface.book();
		System.out.println("Travel package booked successfully");
	}

}
