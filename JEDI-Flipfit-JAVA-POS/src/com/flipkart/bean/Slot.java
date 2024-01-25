/**
 * 
 */
package com.flipkart.bean;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 
 */
public class Slot {
    private int slotId;
    private int gymId;
    private LocalDateTime startTime = LocalDateTime.now();
    private LocalDateTime endTime = LocalDateTime.now();
    private Duration slotTime;
    private int avilableSeats;

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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Duration getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(Duration slotTime) {
        this.slotTime = slotTime;
    }

    public int getAvilableSeats() {
        return avilableSeats;
    }

    public void setAvilableSeats(int avilableSeats) {
        this.avilableSeats = avilableSeats;
    }

    public int getFilledSeats() {
        return filledSeats;
    }

    public void setFilledSeats(int filledSeats) {
        this.filledSeats = filledSeats;
    }

    private int filledSeats;

	public int getSlotHour() {
		// TODO Auto-generated method stub
		return 0;
	}
}
