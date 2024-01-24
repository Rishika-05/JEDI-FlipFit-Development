package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Booking;

public interface GymCustomerService {
	void bookWorkout(Booking booking);
	
	void cancelBooking(int bookingId);
	
	List<Booking> getBookings(int userId);
}
