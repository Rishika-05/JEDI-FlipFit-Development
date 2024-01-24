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
    

    public Gym(int i, int j, boolean b, String l, String n) {
    	this.gymId = i;
    	this.approved = b;
    	this.totalSlots = j;
    	this.location = l;
    	this.gymName = n;
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
