/**
 * This enum represents the different types of roles in the FlipFit application.
 */
package com.flipkart.constant;

/**
 * This enum represents the different types of roles in the FlipFit application.
 */
public enum RoleType {
	
	/**
	 * Represents the role of an admin.
	 */
	ADMIN("Admin"),
	
	/**
	 * Represents the role of a gym customer.
	 */
	GYM_CUSTOMER("Gym Customer"),
	
	/**
	 * Represents the role of a gym owner.
	 */
	GYM_OWNER("Gym Owner");
	
	private RoleType(String role) {
		this.role = role;
	}
	
	private final String role;
}
