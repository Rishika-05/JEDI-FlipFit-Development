/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Gym {
    private int gymId;
    private int totalSlots;
    private boolean approved;
    private String location;
    private String gymName;
    private String gymDescription;
    private int gymOwnerId;
    
    

    public Gym(int id, int ownerId, int slots, String name, String loc, String des) {
    	this.gymId = id;
    	this.approved = false;
    	this.totalSlots = slots;
    	this.location = loc;
    	this.gymName = name;
    	this.gymDescription = des;
	}

	public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

//    public int getPincode() {
//        return pincode;
//    }
//
//    public void setPincode(int pincode) {
//        this.pincode = pincode;
//    }

	public String getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	public String getGymName() {
		return gymName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setGymName(String gymName) {
		this.gymName = gymName;
	}



}
