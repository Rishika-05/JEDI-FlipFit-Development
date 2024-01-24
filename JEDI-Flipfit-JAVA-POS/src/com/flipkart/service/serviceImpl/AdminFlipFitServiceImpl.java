/**
 * 
 */
package com.flipkart.service.serviceImpl;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.service.AdminFlipfitService;

/**
 * 
 */

public class AdminFlipFitServiceImpl implements AdminFlipfitService {

	@Override
	public GymOwner verifyGymOwnerRequest(int gym_owner_id, boolean approved) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveGymRequest(int gym_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectGymRequest(int gym_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Gym> getGymRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GymOwner> getGymOwnerRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GymCustomer> getAllGymCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GymOwner> getAllGymOwners() {
		// TODO Auto-generated method stub
		return null;
	}

}
