package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;

public interface AdminFlipfitService {
	
	GymOwner verifyGymOwnerRequest(int gym_owner_id, boolean approved);
	
	void approveGymRequest(int gym_id);
	
	void rejectGymRequest(int gym_id);
	
	List<Gym> getGymRequests();
	
	List<GymOwner> getGymOwnerRequests();
	
	List<GymCustomer> getAllGymCustomers();
	
	List<GymOwner> getAllGymOwners();
}
