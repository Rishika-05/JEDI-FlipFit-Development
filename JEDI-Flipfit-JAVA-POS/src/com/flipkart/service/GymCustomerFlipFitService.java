package com.flipkart.service;


import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.User;

public interface GymCustomerFlipFitService {
	void bookWorkout(Booking booking);
	
	void cancelBooking(int bookingId);
	
	List<Booking> getBookings(int userId);

	boolean updateProfile(int gymCustomerId , GymCustomer newGymCustomer );

	GymCustomer viewProfile(int gymCustomerId);
	
	int getGymCustomerId(int userId);
	

	void cancelSlot(int gymID, int slotHour, int userID);

	void bookSlot(int gymId, int slotHour, int userId);
}
