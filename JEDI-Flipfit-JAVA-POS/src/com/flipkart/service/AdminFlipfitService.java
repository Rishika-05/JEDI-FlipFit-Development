package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

public interface AdminFlipfitService {
	
	void handleGymOwnerRequest(int gymOwnerId, boolean isApproved);
	
	void handleGymRequest(int gymId, boolean isApproved);
	
	void handleGymSlotRequest(int slotId ,  boolean isApproved );
	
	ArrayList<Slot> getSlotRequests();	
	
	ArrayList<Gym> getGymRequests();
	
	ArrayList<GymOwner> getGymOwnerRequests();
	
	ArrayList<GymCustomer> getAllGymCustomers();
	
	ArrayList<GymOwner> getAllGymOwners();
	
	ArrayList<Gym> getAllGym();
	
}
