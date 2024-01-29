/**
 * This interface represents the Booking FlipFit Service, which provides methods for managing bookings in the FlipFit application.
 */
package com.flipkart.service;

import com.flipkart.bean.Booking;
import com.flipkart.bean.BookingDetails;

import java.util.ArrayList;
import java.util.List;

public interface BookingFlipFitService {
	
	/**
	 * Inserts a new booking into the system.
	 * 
	 * @param userId the ID of the user making the booking
	 * @param gymID the ID of the gym for which the booking is made
	 * @param slotId the ID of the time slot for the booking
	 * @return true if the booking is successfully inserted, false otherwise
	 */
	boolean insertBooking(int userId, int gymID, int slotId);
	
	/**
	 * Cancels a booking.
	 * 
	 * @param bookingId the ID of the booking to be canceled
	 * @return true if the booking is successfully canceled, false otherwise
	 */
	boolean cancelBooking(int bookingId);

	/**
	 * Removes bookings associated with an inactive gym.
	 * 
	 * @param gymId the ID of the inactive gym
	 * @return true if the bookings are successfully removed, false otherwise
	 */
	boolean removeBookingOfInactiveGym(int gymId);
	
	/**
	 * Retrieves a booking by its ID.
	 * 
	 * @param bookingId the ID of the booking to retrieve
	 * @return the Booking object corresponding to the given ID, or null if no such booking exists
	 */
	Booking getBooking(int bookingId);
	
	/**
	 * Retrieves all bookings made by a specific user.
	 * 
	 * @param userId the ID of the user
	 * @return a list of Booking objects representing the bookings made by the user
	 */
	List<Booking> getBookingsByUserId(int userId);
	
	/**
	 * Retrieves all bookings associated with a specific gym.
	 * 
	 * @param gymId the ID of the gym
	 * @return a list of Booking objects representing the bookings associated with the gym
	 */
	List<Booking> getBookingsByGymId(int gymId);
	
	/**
	 * Retrieves all bookings associated with a specific time slot.
	 * 
	 * @param slotId the ID of the time slot
	 * @return a list of Booking objects representing the bookings associated with the time slot
	 */
	List<Booking> getBookingsBySlotId(int slotId);
	
	/**
	 * Retrieves all bookings in the system.
	 * 
	 * @return a list of all Booking objects in the system
	 */
	List<Booking> getAllBookings();
}
