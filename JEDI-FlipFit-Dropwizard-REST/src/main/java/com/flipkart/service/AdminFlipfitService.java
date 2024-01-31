/**
 * The AdminFlipfitService interface provides methods to manage gym requests, slot requests, and gym customers in the Flipfit application.
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

public interface AdminFlipfitService {
	
	/**
	 * Verifies the gym owner request with the specified gym owner ID.
	 * 
	 * @param gym_owner_id The ID of the gym owner to be verified.
	 */
	void verifyGymOwnerRequest(int gym_owner_id);
	
	/**
	 * Approves the gym request with the specified gym ID.
	 * 
	 * @param gym_id The ID of the gym to be approved.
	 */
	void approveGymRequest(int gym_id);
	
	/**
	 * Approves the slot request with the specified slot ID.
	 * 
	 * @param slot_id The ID of the slot to be approved.
	 */
	void approveSlotRequest(int slot_id);
	
	/**
	 * Retrieves a list of gym requests.
	 * 
	 * @return A list of Gym objects representing the gym requests.
	 */
	List<Gym> getGymRequests();
	
	/**
	 * Retrieves a list of gym owner requests.
	 * 
	 * @return A list of GymOwner objects representing the gym owner requests.
	 */
	List<GymOwner> getGymOwnerRequests();
	
	/**
	 * Retrieves a list of slot requests.
	 * 
	 * @return A list of Slot objects representing the slot requests.
	 */
	List<Slot> getSlotRequests();
	
	/**
	 * Retrieves a list of all gym customers.
	 * 
	 * @return A list of GymCustomer objects representing all gym customers.
	 */
	List<GymCustomer> getAllGymCustomers();
	
	/**
	 * Retrieves a list of all gym owners.
	 * 
	 * @return A list of GymOwner objects representing all gym owners.
	 */
	List<GymOwner> getAllGymOwners();
}
