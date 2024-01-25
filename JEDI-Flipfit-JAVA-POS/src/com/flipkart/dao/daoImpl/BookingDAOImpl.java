/**
 * 
 */
package com.flipkart.dao.daoImpl;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingDAO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 */
public class BookingDAOImpl implements BookingDAO {
    ArrayList<Booking> bookings = new ArrayList<Booking>();

    @Override
    public boolean insertBooking(int userId, int gymID, int slotId) {

        Booking newBooking = new Booking();
        newBooking.setBookingId(bookings.size() + 1);
        newBooking.setBookingDate(LocalDateTime.now());
        newBooking.setUserId(userId);
        newBooking.setGymId(gymID);
        newBooking.setSlotId(slotId);
        bookings.add(newBooking);
        return true;
    }

    /**
     * Remove the booking from the database
     *
     * @param slotID
     * @param customerID
     * @return boolean value whether the removal was successful or not
     */
    @Override
    public boolean cancelBooking(int bookingId) {
        Iterator<Booking> iterator = bookings.iterator(); // Assuming bookings is a collection of Booking objects

        while (iterator.hasNext()) {
            Booking booking = iterator.next();

            if (booking.getBookingId() == bookingId) {
                // Found a booking with the given bookingId
                booking.setCancelled(true); // Remove the booking from the collection
                System.out.println("Booking with Gym ID " + booking.getGymId() + ",Booking ID " + booking.getBookingId() + " and Slot ID " + booking.getSlotId() + " cancelled.");
                break;
            }
        }

        return true;
    }

    @Override
    public Booking getBooking(int bookingId) {
        return bookings.get(bookingId);
    }

    @Override
    public List<Booking> getBookingsByUserId(int userId) {
        Iterator<Booking> iterator = bookings.iterator(); // Assuming bookings is a collection of Booking objects
        List<Booking> userBookings = new ArrayList<Booking>();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();

            if (booking.getUserId() == userId) {
                // Found a booking with the given bookingId
                userBookings.add(booking);
            }
        }
        return userBookings;
    }

    @Override
    public List<Booking> getBookingsByGymId(int gymId) {

        Iterator<Booking> iterator = bookings.iterator(); // Assuming bookings is a collection of Booking objects
        List<Booking> gymBookings = new ArrayList<Booking>();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();

            if (booking.getGymId() == gymId) {
                // Found a booking with the given bookingId
                gymBookings.add(booking);
            }
        }
        return gymBookings;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookings;
    }

    @Override
    public List<Booking> getBookingsBySlotId(int slotId) {

        Iterator<Booking> iterator = bookings.iterator(); // Assuming bookings is a collection of Booking objects
        List<Booking> slotBookings = new ArrayList<Booking>();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();

            if (booking.getSlotId() == slotId) {
                // Found a booking with the given bookingId
                slotBookings.add(booking);
            }
        }
        return slotBookings;
    }
}

