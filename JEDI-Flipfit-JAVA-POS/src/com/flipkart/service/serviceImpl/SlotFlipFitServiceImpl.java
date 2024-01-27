/**
 * 
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
 * 
 */
public class SlotFlipFitServiceImpl implements SlotFlipFitService {
	
private static SlotFlipFitService slotServiceObj = null;
	
	public SlotFlipFitServiceImpl() {
		
	}
	
	public static synchronized SlotFlipFitService getInstance() {
		if (slotServiceObj == null)
			slotServiceObj = new SlotFlipFitServiceImpl();

		return slotServiceObj;
	}
	
	SlotDAO slotDAO = SlotDAOImpl.getInstance();

    @Override
    public boolean isAvailable(int slotId) {
    	Slot slot = slotDAO.getSlot(slotId);
    	if(slot.getTotalSeats() - slot.getFilledSeats() > 0) {
			return true;
		}
        return false;
    }


	
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

	@Override
	public void addSlot(int gymID, LocalTime startTime, int slotTime, int seats) {
		Slot slot = new Slot();
		slot.setGymId(gymID);
		slot.setSlotTime(slotTime);
		slot.setStartTime(startTime);
		slot.setTotalSeats(seats);
		slotDAO.createSlot(slot);
	}

	@Override
	public void updateSlot(Slot slot) {
		// TODO Auto-generated method stub
		slotDAO.updateSlot(slot);	}

	@Override
	public void removeSlot(int slotId) {
		slotDAO.deleteSlot(slotId);
	}


	@Override
	public Slot getSlot(int slotId) {
		return slotDAO.getSlot(slotId);
	}



	@Override
	public List<Slot> getAllSlotsByGymId(int gymId) {
		return slotDAO.getAllSlots(gymId);
	}
	
	@Override
	public List<Slot> getAllApprovedSlotsByGymId(int gymId) {
		return slotDAO.getAllApprovedSlots(gymId);
	}



	@Override
	public List<Slot> getAllSlot() {
		return slotDAO.getAllSlots();
	}
	


	@Override
	public void approveSlot(int slotId) {
		slotDAO.approveSlot(slotId);
	}

	@Override
	public int getAvailableSeats(int slotId) {
		
		return slotDAO.getAvailableSeats(slotId);
	}


}