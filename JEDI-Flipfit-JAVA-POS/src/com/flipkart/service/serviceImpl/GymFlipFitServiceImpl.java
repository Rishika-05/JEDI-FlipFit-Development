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
	public List<Slot> getSlots(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gym> viewGymList() {
		// TODO Auto-generated method stub
		Gym g = new Gym(77, 10, false, "Bellandur", "Cultfit");
		List<Gym> gyms = new ArrayList<Gym>();
		gyms.add(g);
		return gyms;
	}

	@Override
	public String displayGymDetails(int gymId) {
		// TODO Auto-generated method stub
		return "This gym has 10 remaining slots.";
	}

}
