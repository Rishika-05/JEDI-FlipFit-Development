/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public interface BookingDAO {
    public boolean insertBooking(int userId,int gymID,int slotId);
    /**
     * Remove the booking from the database
     * @param slotID
     * @param customerID
     * @return boolean value whether the removal was successful or not
     */
    public boolean cancelBooking(int bookingId);
    /**
     * Get a list of all of the bookings of a user
     * @param customerID
     * @return List containing all the bookings of a user
     */

    Booking getBooking(int bookingId);
    List<Booking> getBookingsByUserId(int userId);
    List<Booking> getBookingsByGymId(int gymId);
    List<Booking> getBookingsBySlotId(int slotId);
    List<Booking> getAllBookings();

}
