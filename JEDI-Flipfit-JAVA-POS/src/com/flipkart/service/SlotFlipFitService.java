package com.flipkart.service;
import java.util.ArrayList;
import com.flipkart.bean.Slot;

public interface SlotFlipFitService {
	
	boolean isAvailable();

	
	boolean addSlot(int slotHour, int gymID, int availableSeats);

	boolean updateSlot(int slotHour, int gymID, int changeInSeats);


	ArrayList<Slot> getAllAvailableSlots();

}



