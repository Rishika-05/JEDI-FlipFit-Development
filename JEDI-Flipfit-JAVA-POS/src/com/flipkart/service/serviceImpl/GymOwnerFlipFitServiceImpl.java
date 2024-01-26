/**
 * 
 */
package com.flipkart.service.serviceImpl;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.GymOwnerDAO;
import com.flipkart.dao.daoImpl.GymOwnerDAOImpl;
import com.flipkart.service.GymFlipFitService;
import com.flipkart.service.GymOwnerFlipFitService;

/**
 * 
 */
public class GymOwnerFlipFitServiceImpl implements GymOwnerFlipFitService {
	
	
	private static GymOwnerFlipFitService ownerServiceObj = null;
	GymFlipFitService gymService = new GymFlipFitServiceImpl();
	GymOwnerDAO ownerDAO = GymOwnerDAOImpl.getInstance();
	
	private GymOwnerFlipFitServiceImpl() {
		
	}
	
	public static synchronized GymOwnerFlipFitService getInstance() {
		if (ownerServiceObj == null)
			ownerServiceObj = new GymOwnerFlipFitServiceImpl();

		return ownerServiceObj;
	}


	@Override
	public void addGym(Gym gym) {
		gymService.addGym(gym);
	}

	@Override
	public List<Gym> getAllGyms(int userId) {
		return gymService.getAllGymsById(userId);
	}
	@Override
	public void addTimeSlot(Gym gym) {
		//logic to add time slot
		return;
	}
	

	
	@Override
	public GymOwner getGymOwnerById(int userId) {
		return ownerDAO.getGymOwnerById(userId);
	}
	
	@Override
	public GymOwner updateProfile(GymOwner gymOwner) {
		return ownerDAO.updateProfile(gymOwner);
	}

	@Override
	public List<GymOwner> getOwners() {
		return ownerDAO.getAllOwners();
	}
}
