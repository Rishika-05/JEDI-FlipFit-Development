/**
 * This class represents a Gym Owner.
 */
package com.flipkart.bean;

/**
 * This class represents a Gym Owner.
 */
public class GymOwner {
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
	 * Returns the owner ID.
	 * 
	 * @return the owner ID
	 */
	public int getOwnerId() {
		return ownerId;
	}
	
	/**
	 * Sets the owner ID.
	 * 
	 * @param ownerId the owner ID to set
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
	/**
	 * Returns the user ID.
	 * 
	 * @return the user ID
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * Sets the user ID.
	 * 
	 * @param userId the user ID to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * Returns whether the Gym Owner is approved or not.
	 * 
	 * @return true if approved, false otherwise
	 */
	public boolean isApproved() {
		return approved;
	}
	
	/**
	 * Sets the approval status of the Gym Owner.
	 * 
	 * @param approved the approval status to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	/**
	 * Returns the location of the Gym Owner.
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the location of the Gym Owner.
	 * 
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Returns the name of the Gym Owner.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the Gym Owner.
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the age of the Gym Owner.
	 * 
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Sets the age of the Gym Owner.
	 * 
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Returns the PAN card number of the Gym Owner.
	 * 
	 * @return the PAN card number
	 */
	public String getPanCard() {
		return panCard;
	}
	
	/**
	 * Sets the PAN card number of the Gym Owner.
	 * 
	 * @param panCard the PAN card number to set
	 */
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	
	/**
	 * Returns the Aadhar card number of the Gym Owner.
	 * 
	 * @return the Aadhar card number
	 */
	public String getAadharCard() {
		return aadharCard;
	}
	
	/**
	 * Sets the Aadhar card number of the Gym Owner.
	 * 
	 * @param aadharCard the Aadhar card number to set
	 */
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	
	/**
	 * Returns the GSTIN (Goods and Services Tax Identification Number) of the Gym Owner.
	 * 
	 * @return the GSTIN
	 */
	public String getGstin() {
		return gstin;
	}
	
	/**
	 * Sets the GSTIN (Goods and Services Tax Identification Number) of the Gym Owner.
	 * 
	 * @param gstin the GSTIN to set
	 */
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
}
