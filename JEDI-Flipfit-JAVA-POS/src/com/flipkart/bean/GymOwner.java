/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */

public class GymOwner extends User {
	private String username;
	private String password;
	private String name;
	private int age;
	private String panCard;
	private String aadharCard;
	private String gstin;
	private String location;
	private boolean approved;
	/**
	 * @return the approved
	 */
	public boolean isApproved() {
		return approved;
	}
	/**
	 * @param approved the approved to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the address
	 */
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the panCard
	 */
	public String getPanCard() {
		return panCard;
	}
	/**
	 * @param panCard the panCard to set
	 */
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	/**
	 * @return the aadharCard
	 */
	public String getAadharCard() {
		return aadharCard;
	}
	/**
	 * @param aadharCard the aadharCard to set
	 */
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	/**
	 * @return the gstin
	 */
	public String getGstin() {
		return gstin;
	}
	/**
	 * @param gstin the gstin to set
	 */
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	
}
