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
    public void insertBooking(int userId,int gymID,int slotId);
    public boolean cancelBooking(int bookingId);
    Booking getBooking(int bookingId);
    List<Booking> getBookingsByUserId(int userId);
    List<Booking> getBookingsByGymId(int gymId);
    List<Booking> getBookingsBySlotId(int slotId);
    List<Booking> getAllBookings();
    public boolean removeBookingOfInactiveGym(int gymId);
}
