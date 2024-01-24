package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Booking;

public interface GymCustomerFlipFitService {
	void bookWorkout(Booking booking);
	
	void cancelBooking(int bookingId);
	
	List<Booking> getBookings(int userId);
}
