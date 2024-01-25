package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;

public interface GymFlipFitService {
	

	List<Gym> viewAllGyms();

	Gym getGym(int gymId);
	
	List<Gym> pendingGymRequest();
	
	void addGym(Gym gym);
	
	void displayGymDetails(int gymId);
	
	void removeGym(int gymId);

	void updateGym(int gymId, Gym gym);

}
