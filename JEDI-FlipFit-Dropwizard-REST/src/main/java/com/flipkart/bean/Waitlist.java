/**
 * The Waitlist class represents a waitlist entry for a user in a slot.
 */
package com.flipkart.bean;

import java.time.LocalDateTime;

public class Waitlist {
    private int id; // The unique identifier for the waitlist entry
    private int userId; // The ID of the user associated with the waitlist entry
    private int slotId; // The ID of the slot associated with the waitlist entry
    private LocalDateTime bookingDate = LocalDateTime.now(); // The date and time when the waitlist entry was created
    private boolean isCancelled; // Indicates whether the waitlist entry has been cancelled

    /**
     * Retrieves the ID of the waitlist entry.
     *
     * @return The ID of the waitlist entry.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the waitlist entry.
     *
     * @param id The ID of the waitlist entry.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the ID of the user associated with the waitlist entry.
     *
     * @return The ID of the user associated with the waitlist entry.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user associated with the waitlist entry.
     *
     * @param userId The ID of the user associated with the waitlist entry.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Retrieves the ID of the slot associated with the waitlist entry.
     *
     * @return The ID of the slot associated with the waitlist entry.
     */
    public int getSlotId() {
        return slotId;
    }

    /**
     * Sets the ID of the slot associated with the waitlist entry.
     *
     * @param slotId The ID of the slot associated with the waitlist entry.
     */
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    /**
     * Retrieves the date and time when the waitlist entry was created.
     *
     * @return The date and time when the waitlist entry was created.
     */
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the date and time when the waitlist entry was created.
     *
     * @param bookingDate The date and time when the waitlist entry was created.
     */
    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    /**
     * Checks if the waitlist entry has been cancelled.
     *
     * @return true if the waitlist entry has been cancelled, false otherwise.
     */
    public boolean isCancelled() {
        return isCancelled;
    }

    /**
     * Sets the cancelled status of the waitlist entry.
     *
     * @param cancelled true if the waitlist entry has been cancelled, false otherwise.
     */
    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
