/**
 * 
 */
package com.flipkart.service.serviceImpl;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.service.GymOwnerFlipFitService;

/**
 * 
 */
public class GymOwnerFlipFitServiceImpl implements GymOwnerFlipFitService {

	@Override
	public void addGym(Gym gmy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Gym> getAllGyms(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addTimeSlot(Gym gym) {
		//logic to add time slot
		return;
	}
	

	
	@Override
	public GymOwner viewProfile(User user) {
		//Get gym owner profile from username and password
		
		GymOwner gymOwnerProfile = new GymOwner();
		return gymOwnerProfile;
	}
	
	@Override
	public GymOwner updateProfile(GymOwner gymOwner) {
		//get details and update accordingly
		
		return gymOwner;
	}
}
