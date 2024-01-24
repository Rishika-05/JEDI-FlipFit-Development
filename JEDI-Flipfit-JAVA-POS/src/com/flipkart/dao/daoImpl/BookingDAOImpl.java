/**
 * 
 */
package com.flipkart.dao.daoImpl;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingDAO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */
public class BookingDAOImpl implements BookingDAO {
    ArrayList<Booking> bookings = new ArrayList<Booking>();

    @Override
    public boolean insertBooking(Booking booking)
    {
        bookings.add(booking);
        return true;
    }
    /**
     * Remove the booking from the database
     * @param slotID
     * @param customerID
     * @return boolean value whether the removal was successful or not
     */
    @Override
    public boolean removeBooking(int slotID, int customerID) {
        Iterator<Booking> iterator = bookings.iterator(); // Assuming bookings is a collection of Booking objects

        while (iterator.hasNext()) {
            Booking booking = iterator.next();

            if (booking.getSlotId() == slotID) {
                // Found a booking with the given slot ID
                iterator.remove(); // Remove the booking from the collection
                System.out.println("Booking with Slot ID " + slotID + " deleted.");
                break; // Assuming there's only one booking per slot ID, you can exit the loop after deleting.
            }
        }

        return true;
    }
    /**
     * Get a list of all of the bookings of a user
     * @param customerID
     * @return List containing all the bookings of a user
     */
    public ArrayList<Booking> viewBookings(int UserID)
    {
        ArrayList<Booking> customerBookings = new ArrayList<>();

        for (Booking booking : bookings) {
            if (booking.getUserId() == UserID) {
                // Found a booking associated with the given customer ID
                customerBookings.add(booking);
            }
        }
        return customerBookings;
    }
}
