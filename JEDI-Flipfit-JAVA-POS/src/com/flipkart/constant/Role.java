/**
 * 
 */
package com.flipkart.constant;

/**
 * 
 */
public enum Role {
	
	ADMIN("Admin"),
	GYM_CUSTOMER("Gym Customer"),
	GYM_OWNER("Gym Owner");
	
	private Role(String role) {
		this.role = role;
	}
	
	private final String role;
}
