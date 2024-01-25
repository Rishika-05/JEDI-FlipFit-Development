package com.flipkart.service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import com.flipkart.bean.Slot;

public interface SlotFlipFitService {
	
	boolean isAvailable(int slotId);

	boolean addSlot(int slotHour, int gymID, LocalDateTime startTime, LocalDateTime endTime, Duration slotTime);

	boolean updateSlot(int slotHour, int slotId, LocalDateTime startTime, LocalDateTime endTime, Duration slotTime);

	ArrayList<Slot> getAllAvailableSlots(int gymId);

	void incrementFilledSeats(int slotId);

	void decrementFilledSeats(int slotId);

}



