/**
 * The BookingDAO interface represents the data access object for managing bookings in the FlipFit application.
 * It provides methods to insert, cancel, retrieve, and remove bookings.
 */
package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.util.ArrayList;
import java.util.List;

/**
 * The BookingDAO interface defines the contract for managing bookings in the FlipFit application.
 */
public interface BookingDAO {
    /**
     * Inserts a new booking into the database.
     *
     * @param userId  the ID of the user making the booking
     * @param gymID   the ID of the gym for the booking
     * @param slotId  the ID of the time slot for the booking
     */
    public void insertBooking(int userId, int gymID, int slotId);

    /**
     * Cancels a booking with the specified booking ID.
     *
     * @param bookingId  the ID of the booking to be canceled
     * @return true if the booking is successfully canceled, false otherwise
     */
    public boolean cancelBooking(int bookingId);

    /**
     * Retrieves a booking with the specified booking ID.
     *
     * @param bookingId  the ID of the booking to retrieve
     * @return the Booking object representing the retrieved booking, or null if not found
     */
    Booking getBooking(int bookingId);

    /**
     * Retrieves all bookings made by a user with the specified user ID.
     *
     * @param userId  the ID of the user
     * @return a list of Booking objects representing the bookings made by the user
     */
    List<Booking> getBookingsByUserId(int userId);

    /**
     * Retrieves all bookings made at a gym with the specified gym ID.
     *
     * @param gymId  the ID of the gym
     * @return a list of Booking objects representing the bookings made at the gym
     */
    List<Booking> getBookingsByGymId(int gymId);

    /**
     * Retrieves all bookings made for a time slot with the specified slot ID.
     *
     * @param slotId  the ID of the time slot
     * @return a list of Booking objects representing the bookings made for the time slot
     */
    List<Booking> getBookingsBySlotId(int slotId);

    /**
     * Retrieves all bookings in the system.
     *
     * @return a list of all Booking objects in the system
     */
    List<Booking> getAllBookings();

    /**
     * Removes bookings associated with an inactive gym.
     *
     * @param gymId  the ID of the inactive gym
     * @return true if the bookings are successfully removed, false otherwise
     */
    public boolean removeBookingOfInactiveGym(int gymId);
}
