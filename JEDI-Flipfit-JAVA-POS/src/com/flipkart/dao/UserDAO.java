/**
 * This interface represents the User Data Access Object (DAO) which provides methods to perform operations related to users.
 */
package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;
import com.flipkart.exception.InvalidCredentialsException;
import com.flipkart.exception.UserNotFoundException;

/**
 * This interface defines the methods for User Operations.
 */
public interface UserDAO {
	
	/**
	 * Creates a new user in the system.
	 * 
	 * @param user The user object containing the details of the user to be created.
	 * @return The user ID of the newly created user.
	 */
	public int createUser(User user);
	
	/**
	 * Verifies the user credentials.
	 * 
	 * @param username The username of the user.
	 * @param password The password of the user.
	 * @return The user ID if the credentials are valid.
	 * @throws InvalidCredentialsException If the credentials are invalid.
	 * @throws UserNotFoundException If the user is not found.
	 */
	public int verifyUser(String username, String password) throws InvalidCredentialsException, UserNotFoundException;
	
	/**
	 * Updates the password of a user.
	 * 
	 * @param userName The username of the user.
	 * @param newPassword The new password to be set.
	 * @return true if the password is updated successfully, false otherwise.
	 */
	public boolean updatePassword(String userName, String newPassword);
	
	/**
	 * Retrieves the role of a user.
	 * 
	 * @param userId The user ID.
	 * @return The role type of the user.
	 */
	public RoleType getUserRole(int userId);
	
	/**
	 * Retrieves the user details.
	 * 
	 * @param userId The user ID.
	 * @return The user object containing the details of the user.
	 */
	public User getUser(int userId);

}