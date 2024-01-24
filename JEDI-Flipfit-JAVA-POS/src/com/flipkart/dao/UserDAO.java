/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;

/**
 * 
 */
public interface UserDAO {
	
	public boolean createUser(User user);
	
	public int verifyUser(String username,String password );
	
	public boolean updatePassword(int userId, String newPassword);
	
	public RoleType getUserRole(int userId);
	

}
