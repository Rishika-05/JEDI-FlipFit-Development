/**
 * 
 */
package com.flipkart.dao;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import com.flipkart.bean.Slot;

/**
 * 
 */
public interface SlotDAO {
	public void createSlot( Slot slot);
	
	public void deleteSlot(int slotId);
	
	public void approveSlot(int slotId);
	
	public Slot getSlot(int slotId);
	
	public ArrayList<Slot> getAllSlots();
	
	public ArrayList<Slot> getAllSlots(int gymId);
		
	public Slot updateSlot(Slot slot);
	
	public int getAvailableSeats(int slotId);

    //ArrayList<Slot> getAllAvailableSlots();
}
