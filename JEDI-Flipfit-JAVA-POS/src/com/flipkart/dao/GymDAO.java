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
	
	void addGym(Gym gym);
	
	boolean removeGym(int gymId);

	boolean updateGym(Gym gym);

	List<Gym> getAllGymsById(int userId);

	List<Gym> getAllGymsByLoc(String selectedLocation);
	
	boolean approveGymsById(int gymId);

	List<Gym> getAllActiveGyms();
}
