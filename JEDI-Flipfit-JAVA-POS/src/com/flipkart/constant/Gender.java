/**
 * 
 */
package com.flipkart.constant;

/**
 * 
 */
public enum Gender {
	
	MALE("Male"),
	FEMALE("Female"),
	OTHER("Other");
	
	
	private Gender(String gender) {
		this.gender = gender;
	}
	
	private final String gender;
}
