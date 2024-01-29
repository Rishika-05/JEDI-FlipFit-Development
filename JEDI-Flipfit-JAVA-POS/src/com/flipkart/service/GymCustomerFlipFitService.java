/**
 * This interface represents the service layer for managing Gym Customers in the FlipFit application.
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.User;

public interface GymCustomerFlipFitService {
	
	/**
	 * Updates the profile of a Gym Customer.
	 * 
	 * @param gymCustomerId the ID of the Gym Customer
	 * @param newGymCustomer the updated Gym Customer object
	 * @return true if the profile is successfully updated, false otherwise
	 */
	boolean updateProfile(int gymCustomerId , GymCustomer newGymCustomer );

	/**
	 * Retrieves the profile of a Gym Customer.
	 * 
	 * @param gymCustomerId the ID of the Gym Customer
	 * @return the Gym Customer object representing the profile
	 */
	GymCustomer viewProfile(int gymCustomerId);
	
	/**
	 * Retrieves the Gym Customer ID associated with a User ID.
	 * 
	 * @param userId the ID of the User
	 * @return the Gym Customer ID associated with the User ID
	 */
	int getGymCustomerId(int userId);
}
