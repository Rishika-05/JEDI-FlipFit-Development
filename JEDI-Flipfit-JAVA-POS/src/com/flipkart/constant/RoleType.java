/**
 * 
 */
package com.flipkart.constant;

/**
 * 
 */
public enum RoleType {
	
	ADMIN("Admin"),
	GYM_CUSTOMER("Gym Customer"),
	GYM_OWNER("Gym Owner");
	
	private RoleType(String role) {
		this.role = role;
	}
	
	private final String role;
}
