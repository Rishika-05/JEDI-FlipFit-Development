package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;

public interface GymFlipFitService {
	
	List<Slot> getSlots(int userId);


	List<Gym> viewGymList();


	String displayGymDetails(int gymId);



}
