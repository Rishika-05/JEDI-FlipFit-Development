/**
 * This class implements the UserFlipFitService interface and provides the implementation for various user-related operations.
 */
package com.flipkart.service.serviceImpl;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;
import com.flipkart.dao.daoImpl.GymCustomerDAOImpl;
import com.flipkart.dao.daoImpl.GymOwnerDAOImpl;
import com.flipkart.dao.daoImpl.UserDAOImpl;
import com.flipkart.exception.InvalidCredentialsException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.UserFlipFitService;

public class UserFlipFitServiceImpl implements UserFlipFitService {
	
	private static UserFlipFitService userServiceObj = null;
	
	private UserFlipFitServiceImpl() {
		
	}
	
	/**
	 * Returns the singleton instance of UserFlipFitService.
	 * @return The singleton instance of UserFlipFitService.
	 */
	public static synchronized UserFlipFitService getInstance() {
		if (userServiceObj == null)
			userServiceObj = new UserFlipFitServiceImpl();

		return userServiceObj;
	}

	/**
	 * Registers a customer in the gym.
	 * @param customer The GymCustomer object representing the customer to be registered.
	 * @return true if the registration is successful, false otherwise.
	 */
	@Override
	public boolean customerRegistration(GymCustomer customer) {
		return GymCustomerDAOImpl.getInstance().register(customer);
	}

	/**
	 * Registers a gym owner.
	 * @param gymOwner The GymOwner object representing the gym owner to be registered.
	 * @return true if the registration is successful, false otherwise.
	 */
	@Override
	public boolean gymOwnerRegistration(GymOwner gymOwner) {
		return GymOwnerDAOImpl.getInstance().register(gymOwner);
	}

	/**
	 * Creates a new user.
	 * @param user The User object representing the user to be created.
	 * @return The ID of the created user.
	 */
	@Override
	public int registration(User user) {
		return UserDAOImpl.getInstance().createUser(user);
	}

	/**
	 * Verifies the user's login credentials.
	 * @param username The username of the user.
	 * @param password The password of the user.
	 * @return The ID of the user if the credentials are valid, -1 otherwise.
	 */
	@Override
	public int login(String username, String password) {
		try {
			return UserDAOImpl.getInstance().verifyUser(username , password);
		} catch (InvalidCredentialsException | UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return -1;
	}

	/**
	 * Updates the password of a user.
	 * @param userName The username of the user.
	 * @param newPassword The new password to be set.
	 * @return true if the password update is successful, false otherwise.
	 */
	@Override
	public boolean updatePassword(String userName, String newPassword) {
		return UserDAOImpl.getInstance().updatePassword(userName , newPassword);
	}

	/**
	 * Retrieves the role type of a user.
	 * @param userId The ID of the user.
	 * @return The RoleType of the user.
	 */
	@Override
	public RoleType getUserRole(int userId) {
		return UserDAOImpl.getInstance().getUserRole(userId);
	}

	/**
	 * Retrieves the user with the specified ID.
	 * @param userId The ID of the user.
	 * @return The User object representing the user.
	 */
	@Override
	public User getUser(int userId) {
		return UserDAOImpl.getInstance().getUser(userId);
	}
}