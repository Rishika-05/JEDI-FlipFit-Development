package com.flipkart.service;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;

public interface UserFlipFitService {
	public boolean customerRegistration(GymCustomer customer);
	
	/**
	 * Registers a new gym owner
	 * @param gymOwner
	 * @return boolean
	 */
	public boolean gymOwnerRegistration(GymOwner gymOwner);
	
	/**
	 * Registration Process
	 * @param username
	 * @param password
	 * @param role
	 * @return boolean
	 */
	public int registration(User user);

	/**
	 * Logs in a user
	 * @param userId
	 * @param password
	 * @return User
	 */
	public int login(String username, String password);

	/**
	 * Update user password
	 * @param user
	 * @param newPassword
	 * @return int
	 */
	public User getUser(int userId);
	
	public RoleType getUserRole(int userId);

	public boolean updatePassword(String userName, String newPassword);
	

}