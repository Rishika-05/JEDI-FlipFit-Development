/**
 * This class implements the BookingFlipFitService interface and provides the implementation for various booking-related operations.
 */
package com.flipkart.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.BookingDetails;
import com.flipkart.bean.Slot;
import com.flipkart.bean.User;
import com.flipkart.dao.BookingDAO;
import com.flipkart.dao.daoImpl.BookingDAOImpl;
import com.flipkart.service.BookingFlipFitService;

/**
 * This class implements the BookingFlipFitService interface and provides the implementation for various booking-related operations.
 */
public class BookingFlipFitServiceImpl implements BookingFlipFitService {

	BookingDAO bookingDao = BookingDAOImpl.getInstance();

	/**
	 * Inserts a new booking into the database.
	 * 
	 * @param userId  the ID of the user making the booking
	 * @param gymID   the ID of the gym for the booking
	 * @param slotId  the ID of the time slot for the booking
	 * @return        true if the booking is successfully inserted, false otherwise
	 */
	@Override
	public boolean insertBooking(int userId, int gymID, int slotId) {
		bookingDao.insertBooking(userId, gymID, slotId);
		return true;
	}

	/**
	 * Cancels a booking with the given booking ID.
	 * 
	 * @param bookingId  the ID of the booking to be canceled
	 * @return           true if the booking is successfully canceled, false otherwise
	 */
	@Override
	public boolean cancelBooking(int bookingId) {
		bookingDao.cancelBooking(bookingId);
		return true;
	}

	/**
	 * Removes all bookings associated with an inactive gym.
	 * 
	 * @param gymId  the ID of the inactive gym
	 * @return       true if the bookings are successfully removed, false otherwise
	 */
	@Override
	public boolean removeBookingOfInactiveGym(int gymId) {
		return bookingDao.removeBookingOfInactiveGym(gymId);
	}

	/**
	 * Retrieves a booking with the given booking ID.
	 * 
	 * @param bookingId  the ID of the booking to be retrieved
	 * @return           the Booking object if found, null otherwise
	 */
	@Override
	public Booking getBooking(int bookingId) {
		return bookingDao.getBooking(bookingId);
	}

	/**
	 * Retrieves all bookings made by a user with the given user ID.
	 * 
	 * @param userId  the ID of the user
	 * @return        a list of Booking objects made by the user
	 */
	@Override
	public List<Booking> getBookingsByUserId(int userId) {
		return bookingDao.getBookingsByUserId(userId);
	}

	/**
	 * Retrieves all bookings associated with a gym with the given gym ID.
	 * 
	 * @param gymId  the ID of the gym
	 * @return       a list of Booking objects associated with the gym
	 */
	@Override
	public List<Booking> getBookingsByGymId(int gymId) {
		return bookingDao.getBookingsByGymId(gymId);
	}

	/**
	 * Retrieves all bookings in the system.
	 * 
	 * @return  a list of all Booking objects in the system
	 */
	@Override
	public List<Booking> getAllBookings() {
		return bookingDao.getAllBookings();
	}

	/**
	 * Retrieves all bookings associated with a time slot with the given slot ID.
	 * 
	 * @param slotId  the ID of the time slot
	 * @return        a list of Booking objects associated with the time slot
	 */
	@Override
	public List<Booking> getBookingsBySlotId(int slotId) {
		return getBookingsBySlotId(slotId);
	}
}
