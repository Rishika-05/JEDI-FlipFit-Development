/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Gym;

/**
 * 
 */
public interface GymDAO {
	
	List<Gym> getAllGyms();

	Gym getGym(int gymId);
	
	List<Gym> pendingGymRequest();
	
	void addGym(Gym gym);
	
	void removeGym(int gymId);

	void updateGym(Gym gym);

	List<Gym> getAllGymsById(int userId);

	List<Gym> getAllGymsByLoc(String selectedLocation);


}
