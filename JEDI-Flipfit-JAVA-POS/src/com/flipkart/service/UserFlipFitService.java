/**
 * This interface represents the User FlipFit Service, which provides methods for user registration, login, and password management.
 */
package com.flipkart.service;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;

public interface UserFlipFitService {
	
	/**
	 * Registers a new customer in the FlipFit gym system.
	 * 
	 * @param customer the GymCustomer object representing the customer to be registered
	 * @return true if the registration is successful, false otherwise
	 */
	public boolean customerRegistration(GymCustomer customer);
	
	/**
	 * Registers a new gym owner in the FlipFit gym system.
	 * 
	 * @param gymOwner the GymOwner object representing the gym owner to be registered
	 * @return true if the registration is successful, false otherwise
	 */
	public boolean gymOwnerRegistration(GymOwner gymOwner);
	
	/**
	 * Registers a new user in the FlipFit gym system.
	 * 
	 * @param user the User object representing the user to be registered
	 * @return the user ID if the registration is successful, -1 otherwise
	 */
	public int registration(User user);

	/**
	 * Logs in a user to the FlipFit gym system.
	 * 
	 * @param username the username of the user
	 * @param password the password of the user
	 * @return the user ID if the login is successful, -1 otherwise
	 */
	public int login(String username, String password);

	/**
	 * Retrieves the user object for the given user ID.
	 * 
	 * @param userId the ID of the user
	 * @return the User object representing the user, or null if the user is not found
	 */
	public User getUser(int userId);
	
	/**
	 * Retrieves the role type of the user with the given user ID.
	 * 
	 * @param userId the ID of the user
	 * @return the RoleType enum representing the role of the user, or null if the user is not found
	 */
	public RoleType getUserRole(int userId);

	/**
	 * Updates the password of the user with the given username.
	 * 
	 * @param userName the username of the user
	 * @param newPassword the new password to be set
	 * @return true if the password update is successful, false otherwise
	 */
	public boolean updatePassword(String userName, String newPassword);
}