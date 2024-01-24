package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Slot;
import com.flipkart.bean.GymDetails;  // Add this import statement

public interface GymFlipFitService {
	List<Slot> getSlots(int userId);
<<<<<<< HEAD
	
//	GymDetails getGymDetails(int gymId);
=======

	GymDetails getGymDetails(int gymId);
>>>>>>> 4eefed4 (fix: bug fixes)
}
