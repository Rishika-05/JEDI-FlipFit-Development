/**
 * This class represents a User in the system.
 */
package com.flipkart.bean;

import com.flipkart.constant.RoleType;

/**
 * This class represents a User in the system.
 */
public class User {
    private int userId;
	private String username;
    private String password;
    private RoleType  role;
    
    /**
	 * Get the role of the user.
	 * 
	 * @return the role of the user
	 */
	public RoleType getRole() {
		return role;
	}
	
	/**
	 * Set the role of the user.
	 * 
	 * @param role the role to set
	 */
	public void setRole(RoleType role) {
		this.role = role;
	}
	
	/**
	 * Get the user ID.
	 * 
	 * @return the user ID
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * Set the user ID.
	 * 
	 * @param userId the user ID to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * Get the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Set the username.
	 * 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Get the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Set the password.
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}