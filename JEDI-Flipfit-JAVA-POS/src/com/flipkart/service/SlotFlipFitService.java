/**
 * The SlotFlipFitService interface provides methods to manage slots for the FlipFit gym.
 */
package com.flipkart.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Slot;

public interface SlotFlipFitService {
	
	/**
	 * Checks if a slot is available.
	 * 
	 * @param slotId the ID of the slot
	 * @return true if the slot is available, false otherwise
	 */
	boolean isAvailable(int slotId);

	/**
	 * Adds a new slot to the gym.
	 * 
	 * @param gymID the ID of the gym
	 * @param startTime the start time of the slot
	 * @param slotTime the duration of the slot in minutes
	 * @param seats the number of available seats in the slot
	 */
	void addSlot(int gymID, LocalTime startTime, int slotTime, int seats);

	/**
	 * Retrieves a slot by its ID.
	 * 
	 * @param slotId the ID of the slot
	 * @return the Slot object corresponding to the ID, or null if not found
	 */
	Slot getSlot(int slotId);
	
	/**
	 * Removes a slot by its ID.
	 * 
	 * @param slotId the ID of the slot to be removed
	 */
	void removeSlot(int slotId);

	/**
	 * Retrieves all available slots for a given gym.
	 * 
	 * @param gymId the ID of the gym
	 * @return a list of available Slot objects for the gym
	 */
	ArrayList<Slot> getAllAvailableSlots(int gymId);

	/**
	 * Updates the details of a slot.
	 * 
	 * @param slot the updated Slot object
	 */
	void updateSlot(Slot slot);

	/**
	 * Retrieves all slots for a given gym.
	 * 
	 * @param gymId the ID of the gym
	 * @return a list of Slot objects for the gym
	 */
	List<Slot> getAllSlotsByGymId(int gymId);

	/**
	 * Retrieves all slots.
	 * 
	 * @return a list of all Slot objects
	 */
	List<Slot> getAllSlot();
	
	/**
	 * Approves a slot by its ID.
	 * 
	 * @param slotId the ID of the slot to be approved
	 */
	void approveSlot(int slotId);
	
	/**
	 * Retrieves the number of available seats for a slot.
	 * 
	 * @param slotId the ID of the slot
	 * @return the number of available seats
	 */
	int getAvailableSeats(int slotId);

	/**
	 * Retrieves all approved slots for a given gym.
	 * 
	 * @param gymId the ID of the gym
	 * @return a list of approved Slot objects for the gym
	 */
	List<Slot> getAllApprovedSlotsByGymId(int gymId);

}



