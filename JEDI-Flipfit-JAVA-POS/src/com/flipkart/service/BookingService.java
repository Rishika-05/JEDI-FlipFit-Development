package com.flipkart.service;

import com.flipkart.bean.BookingDetails;

public interface BookingService {
	
	boolean updateBooking(int bookingId);
	
	boolean cancelBooking(int bookingId);
	
	BookingDetails getBookingDetails(int bookingId);

}
