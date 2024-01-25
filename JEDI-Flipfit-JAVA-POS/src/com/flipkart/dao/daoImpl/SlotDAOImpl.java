/**
 * 
 */
package com.flipkart.dao.daoImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import com.flipkart.bean.Slot;
import com.flipkart.dao.SlotDAO;

/**
 * 
 */
public class SlotDAOImpl implements SlotDAO {	
	
	private static SlotDAO slotDAOObj = null;
	
	
	
	public static synchronized SlotDAO getInstance() {
		if (slotDAOObj == null)
			slotDAOObj = new SlotDAOImpl();

		return slotDAOObj;
	}
	
	private ArrayList<Slot> slots = new ArrayList<Slot>();
	

	@Override
	public boolean createSlot(int slotHour, int gymID, LocalDateTime startTime, LocalDateTime endTime, Duration slotTime, int availableSlots) {
		Slot slot = new Slot();
		for(Slot slotItem: slots) {
			if(slotItem.getGymId() == slot.getGymId() && (slotItem.getStartTime().isBefore(slot.getEndTime()) || slotItem.getEndTime().isAfter(slot.getStartTime()))) {
				System.out.println("A Slot already exists in this time interval. Slot time is overlapping with existing slot.");
				return false;
			}
		}
		
		int slotId = slots.size()+1;
		
		slot.setSlotId(slotId);
		slot.setStartTime(startTime);
		slot.setEndTime(endTime);
		slot.setSlotTime(slotTime);
		slot.setGymId(gymID);
		slot.setAvilableSeats(availableSlots);
		
		slots.add(slot);
		return true;
	}

	@Override
	public boolean deleteSlot(int slotId) {
		Iterator<Slot> iterator = slots.iterator(); // Assuming bookings is a collection of Booking objects

        while (iterator.hasNext()) {
            Slot slot = iterator.next();

            if (slot.getSlotId() == slotId) {
                // Found a booking with the given slot ID
                iterator.remove(); // Remove the booking from the collection
                System.out.println("Slot with Slot ID " + slotId + " deleted.");
                 
                return true;
            }
        }

        System.out.println("Did not find slot with Slot ID " + slotId + ".");
        return true;
	}

	@Override
	public ArrayList<Slot> getAllSlots() {
		return slots;
	}

	@Override
	public Slot updateSlot(Slot slot) {
		ListIterator<Slot> iterator = slots.listIterator(); // Assuming bookings is a collection of Booking objects

        while (iterator.hasNext()) {
            Slot slotItem = iterator.next();

            if (slotItem.getSlotId() == slot.getSlotId()) {
                // Found a booking with the given slot ID
                iterator.set(slot); // Remove the booking from the collection
//                System.out.println("Slot with Slot ID " + slotId + " deleted.");
                 
                return slot;
            }
        }
		
		System.out.println("Slot with slot id "+ slot.getSlotId() + " not found.");
		return null;
	}

	@Override
	public ArrayList<Slot> getAllSlots(int gymId) {
		ArrayList<Slot> newSlotsArray = new ArrayList<Slot>();
		for(Slot slotItem: slots) {
			if(slotItem.getGymId() == gymId) {
				newSlotsArray.add(slotItem);
			}
		}
		return newSlotsArray;
	}

	@Override
	public Slot getSlot(int slotId) {
		for(Slot slotItem: slots) {
			if(slotItem.getSlotId() == slotId) {
				return slotItem;
			}
		}
		
		System.out.println("Slot with slot id "+ slotId + " not found.");
		return null;
	}

	@Override
	public ArrayList<Slot> getAllAvailableSlots() {
		return slots;
	}

}
