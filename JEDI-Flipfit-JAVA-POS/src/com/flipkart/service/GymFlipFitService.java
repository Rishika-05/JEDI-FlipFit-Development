/**
 * This interface represents the GymFlipFitService, which provides methods to interact with gym-related functionality.
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;

public interface GymFlipFitService {
	
	/**
	 * Retrieves a list of all gyms.
	 * 
	 * @return the list of all gyms
	 */
	List<Gym> viewAllGyms();
	
	/**
	 * Retrieves a list of all gyms associated with a specific user ID.
	 * 
	 * @param userId the ID of the user
	 * @return the list of gyms associated with the user ID
	 */
	List<Gym> getAllGymsById(int userId);

	/**
	 * Retrieves a gym based on the gym ID.
	 * 
	 * @param gymId the ID of the gym
	 * @return the gym object
	 */
	Gym getGym(int gymId);
	
	/**
	 * Adds a new gym to the system.
	 * 
	 * @param gym the gym object to be added
	 */
	void addGym(Gym gym);
	
	/**
	 * Displays the details of a specific gym.
	 * 
	 * @param gymId the ID of the gym
	 */
	void displayGymDetails(int gymId);
	
	/**
	 * Removes a gym from the system.
	 * 
	 * @param gymId the ID of the gym to be removed
	 * @return true if the gym is successfully removed, false otherwise
	 */
	boolean removeGym(int gymId);

	/**
	 * Updates the details of a gym.
	 * 
	 * @param gym the updated gym object
	 */
	void updateGym(Gym gym);

	/**
	 * Retrieves a list of all gyms based on the selected location.
	 * 
	 * @param selectedLocation the selected location
	 * @return the list of gyms in the selected location
	 */
	List<Gym> getAllGymsByLoc(String selectedLocation);

}
