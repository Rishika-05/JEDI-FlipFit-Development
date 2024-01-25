package com.flipkart.service;

import com.flipkart.bean.Booking;
import com.flipkart.bean.BookingDetails;

import java.util.ArrayList;
import java.util.List;

public interface BookingFlipFitService {
	
	boolean insertBooking(int userId,int gymID,int slotId);
	
	boolean cancelBooking(int bookingId);
	
	Booking getBooking(int bookingId);
	List<Booking> getBookingsByUserId(int userId);
	List<Booking> getBookingsByGymId(int gymId);
	List<Booking> getBookingsBySlotId(int slotId);
	List<Booking> getAllBookings();



}
