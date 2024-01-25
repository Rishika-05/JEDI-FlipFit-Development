/**
 * 
 */
package com.flipkart.bean;

import com.flipkart.constant.RoleType;

/**
 * 
 */
public class User {
    private int userId;
	private String username;
    private String password;
    private RoleType  role;
    /**
	 * @return the role
	 */
	public RoleType getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(RoleType role) {
		this.role = role;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}