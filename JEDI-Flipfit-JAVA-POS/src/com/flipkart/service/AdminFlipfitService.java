package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

public interface AdminFlipfitService {
	
	void verifyGymOwnerRequest(int gym_owner_id);
	
	void approveGymRequest(int gym_id);
	
	void approveSlotRequest(int slot_id);
	
	List<Gym> getGymRequests();
	
	List<GymOwner> getGymOwnerRequests();
	
	List<Slot> getSlotRequests();
	
	List<GymCustomer> getAllGymCustomers();
	
	List<GymOwner> getAllGymOwners();
}
