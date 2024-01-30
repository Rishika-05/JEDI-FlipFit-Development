/**
 * Represents the gender of a person.
 */
package com.flipkart.constant;

/**
 * Enum class that defines the possible genders.
 */
public enum Gender {
	
	/**
	 * Represents the male gender.
	 */
	MALE("Male"),
	
	/**
	 * Represents the female gender.
	 */
	
	FEMALE("Female"),
	
	/**
	 * Represents a gender other than male or female.
	 */
	OTHER("Other");
	
	
	private Gender(String gender) {
		this.gender = gender;
	}
	
	private final String gender;
}
