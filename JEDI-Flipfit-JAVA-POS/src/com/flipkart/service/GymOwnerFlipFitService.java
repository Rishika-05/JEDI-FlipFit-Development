/**
 * This interface represents the service layer for Gym Owners in the FlipFit application.
 * It provides methods to add a gym, retrieve all gyms associated with a user, update the profile of a gym owner,
 * retrieve a gym owner by their user ID, retrieve a list of all gym owners, and retrieve the gym owner ID for a given user ID.
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

public interface GymOwnerFlipFitService {
	
	/**
	 * Adds a new gym to the FlipFit application.
	 * 
	 * @param gym The gym object to be added.
	 */
	void addGym(Gym gym);
	
	/**
	 * Retrieves all gyms associated with a user.
	 * 
	 * @param userId The ID of the user.
	 * @return A list of gyms associated with the user.
	 */
	List<Gym> getAllGyms(int userId);
	
	/**
	 * Updates the profile of a gym owner.
	 * 
	 * @param owner The updated gym owner object.
	 * @return The updated gym owner object.
	 */
	GymOwner updateProfile(GymOwner owner);
	
	/**
	 * Retrieves a gym owner by their user ID.
	 * 
	 * @param userId The ID of the user.
	 * @return The gym owner object.
	 */
	GymOwner getGymOwnerById(int userId);
	
	/**
	 * Retrieves a list of all gym owners.
	 * 
	 * @return A list of all gym owners.
	 */
	List<GymOwner> getOwners();
	
	/**
	 * Retrieves the gym owner ID for a given user ID.
	 * 
	 * @param userId The ID of the user.
	 * @return The gym owner ID.
	 */
	int getGymOwnerId(int userId);
}
