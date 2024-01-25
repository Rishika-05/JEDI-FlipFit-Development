/**
 * 
 */
package com.flipkart.dao;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.flipkart.bean.Slot;

/**
 * 
 */
public interface SlotDAO {
	public boolean createSlot(int slotHour, int gymID, LocalDateTime startTime, LocalDateTime endTime, Duration slotTime, int availableSlots);
	
	public boolean deleteSlot(int slotId);
	
	public Slot getSlot(int slotId);
	
	public ArrayList<Slot> getAllSlots();
	
	public ArrayList<Slot> getAllSlots(int gymId);
		
	public Slot updateSlot(Slot slot);
}
