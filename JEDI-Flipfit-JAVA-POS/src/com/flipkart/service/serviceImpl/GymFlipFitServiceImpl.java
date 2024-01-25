/**
 * 
 */
package com.flipkart.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.service.GymFlipFitService;

/**
 * 
 */
public class GymFlipFitServiceImpl implements GymFlipFitService {
	
	public GymFlipFitServiceImpl() {
	}


	@Override
	public List<Gym> viewAllGyms() {
		// TODO Auto-generated method stub
		Gym g = new Gym(77, 10, false, "Bellandur", "Cultfit");
		List<Gym> gyms = new ArrayList<Gym>();
		gyms.add(g);
		return gyms;
	}

	@Override
	public void displayGymDetails(int gymId) {
		System.out.println("This gym has 10 remaining slots."); 
	}


	@Override
	public Gym getGym(int gymId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Gym> pendingGymRequest() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addGym(Gym gym) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeGym(int gymId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateGym(int gymId, Gym gym) {
		// TODO Auto-generated method stub
		
	}

}
