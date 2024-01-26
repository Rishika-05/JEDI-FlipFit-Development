/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */

public class GymOwner extends User {
	private int userId;
	private int ownerId;
	private String name;
	private int age;
	private String panCard;
	private String aadharCard;
	private String gstin;
	private String location;
	private boolean approved = false;
	
	/**
	 * @return the ownerId
	 */
	public int getOwnerId() {
		return ownerId;
	}
	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
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
