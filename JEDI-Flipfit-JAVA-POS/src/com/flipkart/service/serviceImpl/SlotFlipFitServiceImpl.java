/**
 * 
 */
package com.flipkart.service.serviceImpl;

import java.util.ArrayList;

import com.flipkart.bean.Slot;
import com.flipkart.service.SlotFlipFitService;

/**
 * 
 */
public class SlotFlipFitServiceImpl implements SlotFlipFitService {

    @Override
    public boolean isAvailable() {
        return false;
    }
    
  

	@Override
	public boolean addSlot(int slotHour, int gymID, int availableSeats) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateSlot(int slotHour, int gymID, int changeInSeats) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public ArrayList<Slot> getAllAvailableSlots() {
		// TODO Auto-generated method stub
		return null;
	}
}