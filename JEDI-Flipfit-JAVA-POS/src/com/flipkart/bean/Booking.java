/**
 * The Booking class represents a booking made by a user for a gym slot.
 */
package com.flipkart.bean;

import java.time.LocalDateTime;

/**
 * The Booking class represents a booking made by a user for a gym slot.
 */
public class Booking {

    private int bookingId; // The unique identifier for the booking
    private int userId; // The ID of the user making the booking
    private int gymId; // The ID of the gym for which the booking is made
    private int slotId; // The ID of the gym slot for which the booking is made
    private LocalDateTime bookingDate = LocalDateTime.now(); // The date and time of the booking
    private boolean isCancelled; // Indicates whether the booking has been cancelled

    /**
     * Returns the booking ID.
     *
     * @return The booking ID
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * Sets the booking ID.
     *
     * @param bookingId The booking ID to set
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * Returns the user ID.
     *
     * @return The user ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId The user ID to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Returns the gym ID.
     *
     * @return The gym ID
     */
    public int getGymId() {
        return gymId;
    }

    /**
     * Sets the gym ID.
     *
     * @param gymId The gym ID to set
     */
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    /**
     * Returns the slot ID.
     *
     * @return The slot ID
     */
    public int getSlotId() {
        return slotId;
    }

    /**
     * Sets the slot ID.
     *
     * @param slotId The slot ID to set
     */
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    /**
     * Returns the booking date and time.
     *
     * @return The booking date and time
     */
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the booking date and time.
     *
     * @param bookingDate The booking date and time to set
     */
    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    /**
     * Returns whether the booking has been cancelled.
     *
     * @return true if the booking has been cancelled, false otherwise
     */
    public boolean isCancelled() {
        return isCancelled;
    }

    /**
     * Sets whether the booking has been cancelled.
     *
     * @param cancelled true if the booking has been cancelled, false otherwise
     */
    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
