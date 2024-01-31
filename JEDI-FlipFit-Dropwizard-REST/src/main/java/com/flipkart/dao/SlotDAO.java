/**
 * This interface represents the Slot Data Access Object (DAO) which provides methods to perform operations on Slot objects.
 */
package com.flipkart.dao;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import com.flipkart.bean.Slot;

/**
 * This interface defines the contract for SlotDAO operations.
 */
public interface SlotDAO {
	/**
	 * Creates a new slot.
	 * 
	 * @param slot The Slot object to be created.
	 */
	public void createSlot(Slot slot);

	/**
	 * Deletes a slot with the specified slotId.
	 * 
	 * @param slotId The ID of the slot to be deleted.
	 * @return true if the slot is successfully deleted, false otherwise.
	 */
	public boolean deleteSlot(int slotId);

	/**
	 * Approves a slot with the specified slotId.
	 * 
	 * @param slotId The ID of the slot to be approved.
	 * @return true if the slot is successfully approved, false otherwise.
	 */
	public boolean approveSlot(int slotId);

	/**
	 * Retrieves a slot with the specified slotId.
	 * 
	 * @param slotId The ID of the slot to be retrieved.
	 * @return The Slot object with the specified slotId, or null if not found.
	 */
	public Slot getSlot(int slotId);

	/**
	 * Retrieves all slots.
	 * 
	 * @return An ArrayList of all Slot objects.
	 */
	public ArrayList<Slot> getAllSlots();

	/**
	 * Retrieves all slots for a specific gym.
	 * 
	 * @param gymId The ID of the gym.
	 * @return An ArrayList of Slot objects for the specified gym.
	 */
	public ArrayList<Slot> getAllSlots(int gymId);

	/**
	 * Updates a slot.
	 * 
	 * @param slot The updated Slot object.
	 * @return The updated Slot object.
	 */
	public Slot updateSlot(Slot slot);

	/**
	 * Retrieves the number of available seats for a slot.
	 * 
	 * @param slotId The ID of the slot.
	 * @return The number of available seats for the specified slot.
	 */
	public int getAvailableSeats(int slotId);

	/**
	 * Retrieves all approved slots for a specific gym.
	 * 
	 * @param gymId The ID of the gym.
	 * @return An ArrayList of approved Slot objects for the specified gym.
	 */
	public ArrayList<Slot> getAllApprovedSlots(int gymId);

	// ArrayList<Slot> getAllAvailableSlots();
}
