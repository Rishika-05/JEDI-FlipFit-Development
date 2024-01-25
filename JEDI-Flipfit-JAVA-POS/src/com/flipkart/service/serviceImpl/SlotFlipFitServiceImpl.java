/**
 * 
 */
package com.flipkart.service.serviceImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.flipkart.bean.Slot;
import com.flipkart.dao.SlotDAO;
import com.flipkart.dao.daoImpl.SlotDAOImpl;
import com.flipkart.service.GymFlipFitService;
import com.flipkart.service.SlotFlipFitService;

/**
 * 
 */
public class SlotFlipFitServiceImpl implements SlotFlipFitService {
	
	SlotDAO slotDAO = new SlotDAOImpl();

	private static SlotFlipFitService slotServiceObj = null;
	
	public SlotFlipFitServiceImpl() {
		
	}
	
	public static synchronized SlotFlipFitService getInstance() {
		if (slotServiceObj == null)
			slotServiceObj = new SlotFlipFitServiceImpl();

		return slotServiceObj;
	}
	

    @Override
    public boolean isAvailable(int slotId) {
    	Slot slot = slotDAO.getSlot(slotId);
    	if(slot.getAvilableSeats() - slot.getFilledSeats() > 0) {
			return true;
		}
        return false;
    }

	@Override
	public boolean addSlot(int slotHour, int gymID, LocalDateTime startTime, LocalDateTime endTime, Duration slotTime) {
		Duration totalDuration = Duration.between(startTime, endTime);
        int totalSlots = (int) (totalDuration.toMinutes() / slotTime.toMinutes());
        slotDAO.createSlot(totalSlots, totalSlots, endTime, endTime, slotTime, totalSlots);
		return true;
	}

	@Override
	public boolean updateSlot(int slotHour, int slotId, LocalDateTime startTime, LocalDateTime endTime, Duration slotTime) {
		Duration totalDuration = Duration.between(startTime, endTime);
        int totalSlots = (int) (totalDuration.toMinutes() / slotTime.toMinutes());
        Slot slot = slotDAO.getSlot(slotId);
        
        slot.setStartTime(startTime);
        slot.setEndTime(endTime);
        slot.setSlotTime(slotTime);
        slot.setAvilableSeats(totalSlots);
        
        slotDAO.updateSlot(slot);
		return true;
	}
	
	@Override
	public ArrayList<Slot> getAllAvailableSlots(int gymId) {
		LocalDateTime startTime = LocalDateTime.now();
    	LocalDateTime endTime = LocalDateTime.now().plusHours(3);
    	Duration slotTime = Duration.ofMinutes(30);
    	
    	slotDAO.createSlot(1, 1, startTime, endTime, slotTime, 10);
    	
		ArrayList<Slot> slots = slotDAO.getAllSlots(gymId);
    	
		 
//		ArrayList<Slot> availableSlots = new ArrayList<Slot>();
//		
//		for(Slot slot: slots) {
//			if(slot.getAvilableSeats() - slot.getFilledSeats() > 0) {
//				availableSlots.add(slot);
//			}
//		}
		
//		return availableSlots;
		return slots;
	}
	
	@Override
	public void incrementFilledSeats(int slotId) {
		Slot slot = slotDAO.getSlot(slotId);
		if(slot.getAvilableSeats() > 0) {
			slot.setAvilableSeats(slot.getAvilableSeats()+1);
		}
		slotDAO.updateSlot(slot);
	}
	
	@Override
	public void decrementFilledSeats(int slotId) {
		Slot slot = slotDAO.getSlot(slotId);
		if(slot.getAvilableSeats() > 0) {
			slot.setAvilableSeats(slot.getAvilableSeats()-1);
		}
		slotDAO.updateSlot(slot);
	}
	
}