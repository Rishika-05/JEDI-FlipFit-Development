package com.flipkart.service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Slot;

public interface SlotFlipFitService {
	
	boolean isAvailable(int slotId);

	void addSlot(int gymID, LocalTime startTime, int slotTime, int seats);

	Slot getSlot(int slotId);
	
	void removeSlot(int slotId);

	ArrayList<Slot> getAllAvailableSlots(int gymId);

	void updateSlot(Slot slot);

	List<Slot> getAllSlotsByGymId(int gymId);

	List<Slot> getAllSlot();
	
	void approveSlot(int slotId);
	
	int getAvailableSeats(int slotId);

}



