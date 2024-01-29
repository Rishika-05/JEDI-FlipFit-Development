/**
 * This class implements the SlotFlipFitService interface and provides the implementation for various slot-related operations.
 */
package com.flipkart.service.serviceImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Slot;
import com.flipkart.dao.SlotDAO;
import com.flipkart.dao.daoImpl.SlotDAOImpl;
import com.flipkart.service.GymFlipFitService;
import com.flipkart.service.SlotFlipFitService;

/**
 * This class provides the implementation for the SlotFlipFitService interface.
 */
public class SlotFlipFitServiceImpl implements SlotFlipFitService {
	
	private static SlotFlipFitService slotServiceObj = null;
	
	public SlotFlipFitServiceImpl() {
		
	}
	
	/**
	 * Returns the singleton instance of SlotFlipFitServiceImpl class.
	 * @return the singleton instance of SlotFlipFitServiceImpl class
	 */
	public static synchronized SlotFlipFitService getInstance() {
		if (slotServiceObj == null)
			slotServiceObj = new SlotFlipFitServiceImpl();

		return slotServiceObj;
	}
	
	SlotDAO slotDAO = SlotDAOImpl.getInstance();

    /**
     * Checks if a slot is available based on the slot ID.
     * @param slotId the ID of the slot
     * @return true if the slot is available, false otherwise
     */
    @Override
    public boolean isAvailable(int slotId) {
    	Slot slot = slotDAO.getSlot(slotId);
    	if(slot.getTotalSeats() - slot.getFilledSeats() > 0) {
			return true;
		}
        return false;
    }

	/**
	 * Retrieves all available slots for a given gym ID.
	 * @param gymId the ID of the gym
	 * @return an ArrayList of available slots
	 */
	@Override
	public ArrayList<Slot> getAllAvailableSlots(int gymId) {
		ArrayList<Slot> slots = slotDAO.getAllSlots(gymId);
		 
		ArrayList<Slot> availableSlots = new ArrayList<Slot>();
		
		for(Slot slot: slots) {
			if(slot.getTotalSeats() - slot.getFilledSeats() > 0) {
				availableSlots.add(slot);
			}
		}
		
		return availableSlots;
	}

	/**
	 * Adds a new slot to the database.
	 * @param gymID the ID of the gym
	 * @param startTime the start time of the slot
	 * @param slotTime the duration of the slot
	 * @param seats the total number of seats in the slot
	 */
	@Override
	public void addSlot(int gymID, LocalTime startTime, int slotTime, int seats) {
		Slot slot = new Slot();
		slot.setGymId(gymID);
		slot.setSlotTime(slotTime);
		slot.setStartTime(startTime);
		slot.setTotalSeats(seats);
		slotDAO.createSlot(slot);
	}

	/**
	 * Updates an existing slot in the database.
	 * @param slot the slot object to be updated
	 */
	@Override
	public void updateSlot(Slot slot) {
		slotDAO.updateSlot(slot);
	}

	/**
	 * Removes a slot from the database based on the slot ID.
	 * @param slotId the ID of the slot to be removed
	 */
	@Override
	public void removeSlot(int slotId) {
		slotDAO.deleteSlot(slotId);
	}

	/**
	 * Retrieves a slot based on the slot ID.
	 * @param slotId the ID of the slot
	 * @return the slot object
	 */
	@Override
	public Slot getSlot(int slotId) {
		return slotDAO.getSlot(slotId);
	}

	/**
	 * Retrieves all slots for a given gym ID.
	 * @param gymId the ID of the gym
	 * @return a list of slots
	 */
	@Override
	public List<Slot> getAllSlotsByGymId(int gymId) {
		return slotDAO.getAllSlots(gymId);
	}
	
	/**
	 * Retrieves all approved slots for a given gym ID.
	 * @param gymId the ID of the gym
	 * @return a list of approved slots
	 */
	@Override
	public List<Slot> getAllApprovedSlotsByGymId(int gymId) {
		return slotDAO.getAllApprovedSlots(gymId);
	}

	/**
	 * Retrieves all slots from the database.
	 * @return a list of all slots
	 */
	@Override
	public List<Slot> getAllSlot() {
		return slotDAO.getAllSlots();
	}

	/**
	 * Approves a slot based on the slot ID.
	 * @param slotId the ID of the slot to be approved
	 */
	@Override
	public void approveSlot(int slotId) {
		slotDAO.approveSlot(slotId);
	}

	/**
	 * Retrieves the number of available seats for a given slot ID.
	 * @param slotId the ID of the slot
	 * @return the number of available seats
	 */
	@Override
	public int getAvailableSeats(int slotId) {
		return slotDAO.getAvailableSeats(slotId);
	}
}