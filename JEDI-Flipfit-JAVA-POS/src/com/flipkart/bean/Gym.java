/**
 * 
 */
package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Gym {
    /**
	 * @return the gymId
	 */
	/**
	 * Returns the gym ID.
	 *
	 * @return the gym ID
	 */
	public int getGymId() {
		return gymId;
	}



	/**
	 * @param gymId the gymId to set
	 */
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}



	/**
	 * @return the totalSlots
	 */
	public int getTotalSlots() {
		return totalSlots;
	}



	/**
	 * @param totalSlots the totalSlots to set
	 */
	public void setTotalSlots(int totalSlots) {
		this.totalSlots = totalSlots;
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
	 * @return the gymName
	 */
	public String getGymName() {
		return gymName;
	}



	/**
	 * @param gymName the gymName to set
	 */
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}



	/**
	 * @return the gymDescription
	 */
	public String getGymDescription() {
		return gymDescription;
	}



	/**
	 * @param gymDescription the gymDescription to set
	 */
	public void setGymDescription(String gymDescription) {
		this.gymDescription = gymDescription;
	}



	/**
	 * @return the gymOwnerId
	 */
	public int getGymOwnerId() {
		return gymOwnerId;
	}



	/**
	 * @param gymOwnerId the gymOwnerId to set
	 */
	public void setGymOwnerId(int gymOwnerId) {
		this.gymOwnerId = gymOwnerId;
	}


//
//	/**
//	 * @return the slots
//	 */
//	public List<Slot> getSlots() {
//		return slots;
//	}
//
//
//
//	/**
//	 * @param slots the slots to set
//	 */
//	public void setSlots(List<Slot> slots) {
//		this.slots = slots;
//	}
	
    /**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}


	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}





	private int gymId;
    private int totalSlots;
    private boolean approved = false;
    private boolean active = true;
	private String location;
    private String gymName;
	private String gymDescription;
    private int gymOwnerId;
    /**
	 * @return the pricePerSlot
	 */
	public int getPricePerSlot() {
		return pricePerSlot;
	}



	/**
	 * @param pricePerSlot the pricePerSlot to set
	 */
	public void setPricePerSlot(int pricePerSlot) {
		this.pricePerSlot = pricePerSlot;
	}





	private int pricePerSlot;
//    private List<Slot> slots;
    
    

    public Gym(int ownerId,  String name, String loc, String des, int slots) {
    	this.approved = false;
    	this.active = false;
    	this.totalSlots = slots;
    	this.location = loc;
    	this.gymName = name;
    	this.gymDescription = des;
    	this.gymOwnerId = ownerId;
//    	this.slots = new ArrayList<Slot>();
	}



	public Gym() {
		// TODO Auto-generated constructor stub
	}




}
