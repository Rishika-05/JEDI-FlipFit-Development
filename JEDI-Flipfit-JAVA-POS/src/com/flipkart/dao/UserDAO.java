/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;
import com.flipkart.exception.InvalidCredentialsException;
import com.flipkart.exception.UserNotFoundException;

/**
 * 
 */
public interface UserDAO {
	
	public int createUser(User user);
	
	public int verifyUser(String username,String password ) throws InvalidCredentialsException, UserNotFoundException;
	
	public boolean updatePassword(String userName, String newPassword);
	
	public RoleType getUserRole(int userId);
	
	public User getUser(int userId);

}