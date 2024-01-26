/**
 * 
 */
package com.flipkart.bean;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 
 */
public class Slot {
    private int slotId;
    private int gymId;
    private LocalTime startTime;
    private int slotTime = 1;
    private int totalSeats;
	private boolean active;
	private boolean approved;
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the approved
	 */
	public boolean isApproved() {
		return approved;
	}

	/**
	 * @param approved the approved to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}


    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime2) {
        this.startTime = startTime2;
    }


    public int getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(int slotTime) {
        this.slotTime = 1;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int avilableSeats) {
        this.totalSeats = avilableSeats;
    }

    public int getFilledSeats() {
        return filledSeats;
    }

    public void setFilledSeats(int filledSeats) {
        this.filledSeats = filledSeats;
    }

    private int filledSeats;
}
