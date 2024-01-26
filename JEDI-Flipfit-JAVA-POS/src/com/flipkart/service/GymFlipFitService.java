package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;

public interface GymFlipFitService {
	

	List<Gym> viewAllGyms();
	
	List<Gym> getAllGymsById(int userId);

	Gym getGym(int gymId);
	
	void addGym(Gym gym);
	
	void displayGymDetails(int gymId);
	
	boolean removeGym(int gymId);

	void updateGym(Gym gym);

	List<Gym> getAllGymsByLoc(String selectedLocation);

}
