package com.flipkart.service;

public interface BookingService {
	
	boolean updateBooking(int bookingId);
	
	boolean cancelBooking(int bookingId);
}
