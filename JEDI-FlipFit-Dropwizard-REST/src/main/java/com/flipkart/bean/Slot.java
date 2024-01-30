/**
 * This class represents a time slot for a gym in the FlipFit application.
 */
package com.flipkart.bean;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * This class represents a time slot for a gym in the FlipFit application.
 */
public class Slot {
    private int slotId; // The unique identifier for the slot
    private int gymId; // The ID of the gym associated with the slot
    private LocalTime startTime; // The start time of the slot
    private int slotTime = 1; // The duration of the slot in hours
    private Integer totalSeats; // The total number of seats available in the slot
	private boolean active = true; // Indicates if the slot is active or not
	private boolean approved = false; // Indicates if the slot is approved or not

	/**
	 * Returns whether the slot is active or not.
	 * 
	 * @return true if the slot is active, false otherwise
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active status of the slot.
	 * 
	 * @param active the active status to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Returns whether the slot is approved or not.
	 * 
	 * @return true if the slot is approved, false otherwise
	 */
	public boolean isApproved() {
		return approved;
	}

	/**
	 * Sets the approved status of the slot.
	 * 
	 * @param approved the approved status to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}

    /**
     * Returns the ID of the slot.
     * 
     * @return the slot ID
     */
    public int getSlotId() {
        return slotId;
    }

    /**
     * Sets the ID of the slot.
     * 
     * @param slotId the slot ID to set
     */
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    /**
     * Returns the ID of the gym associated with the slot.
     * 
     * @return the gym ID
     */
    public int getGymId() {
        return gymId;
    }

    /**
     * Sets the ID of the gym associated with the slot.
     * 
     * @param gymId the gym ID to set
     */
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    /**
     * Returns the start time of the slot.
     * 
     * @return the start time
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the slot.
     * 
     * @param startTime the start time to set
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Returns the duration of the slot in hours.
     * 
     * @return the slot duration
     */
    public int getSlotTime() {
        return slotTime;
    }

    /**
     * Sets the duration of the slot in hours.
     * 
     * @param slotTime the slot duration to set
     */
    public void setSlotTime(int slotTime) {
        this.slotTime = slotTime;
    }

    /**
     * Returns the total number of seats available in the slot.
     * 
     * @return the total number of seats
     */
    public Integer getTotalSeats() {
        return totalSeats;
    }

    /**
     * Sets the total number of seats available in the slot.
     * 
     * @param totalSeats the total number of seats to set
     */
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    /**
     * Returns the number of filled seats in the slot.
     * 
     * @return the number of filled seats
     */
    public int getFilledSeats() {
        return filledSeats;
    }

    /**
     * Sets the number of filled seats in the slot.
     * 
     * @param filledSeats the number of filled seats to set
     */
    public void setFilledSeats(int filledSeats) {
        this.filledSeats = filledSeats;
    }

    private int filledSeats; // The number of filled seats in the slot
}
