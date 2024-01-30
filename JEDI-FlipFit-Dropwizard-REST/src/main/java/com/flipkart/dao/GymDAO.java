/**
 * This interface represents the Data Access Object (DAO) for Gym entities.
 * It provides methods to interact with the gym data in the database.
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Gym;

/**
 * This interface defines the contract for GymDAO implementations.
 */
public interface GymDAO {
	
	/**
	 * Retrieves a list of all gyms.
	 * 
	 * @return the list of all gyms
	 */
	List<Gym> getAllGyms();

	/**
	 * Retrieves a gym by its ID.
	 * 
	 * @param gymId the ID of the gym to retrieve
	 * @return the gym with the specified ID, or null if not found
	 */
	Gym getGym(int gymId);
	
	/**
	 * Adds a new gym to the database.
	 * 
	 * @param gym the gym to add
	 */
	void addGym(Gym gym);
	
	/**
	 * Removes a gym from the database.
	 * 
	 * @param gymId the ID of the gym to remove
	 * @return true if the gym was successfully removed, false otherwise
	 */
	boolean removeGym(int gymId);

	/**
	 * Updates an existing gym in the database.
	 * 
	 * @param gym the updated gym object
	 * @return true if the gym was successfully updated, false otherwise
	 */
	boolean updateGym(Gym gym);

	/**
	 * Retrieves a list of all gyms associated with a specific user ID.
	 * 
	 * @param userId the ID of the user
	 * @return the list of gyms associated with the specified user ID
	 */
	List<Gym> getAllGymsById(int userId);

	/**
	 * Retrieves a list of all gyms located in the specified location.
	 * 
	 * @param selectedLocation the location to filter gyms by
	 * @return the list of gyms located in the specified location
	 */
	List<Gym> getAllGymsByLoc(String selectedLocation);
	
	/**
	 * Approves a gym by its ID.
	 * 
	 * @param gymId the ID of the gym to approve
	 * @return true if the gym was successfully approved, false otherwise
	 */
	boolean approveGymsById(int gymId);

	/**
	 * Retrieves a list of all active gyms.
	 * 
	 * @return the list of all active gyms
	 */
	List<Gym> getAllActiveGyms();
}
