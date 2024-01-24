package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Slot;

public interface GymFlipFitService {
	List<Slot> getSlots(int userId);
	
	GymDetails getGymDetails(int gymId);
}
