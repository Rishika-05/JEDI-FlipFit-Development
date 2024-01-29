/**
 * This class implements the GymOwnerFlipFitService interface and provides the implementation for the methods defined in the interface.
 * It interacts with the GymFlipFitService, SlotFlipFitService, and GymOwnerDAO to perform various operations related to gym owners.
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
import com.flipkart.service.SlotFlipFitService;

/**
 * This class provides the implementation for the GymOwnerFlipFitService interface.
 */
public class GymOwnerFlipFitServiceImpl implements GymOwnerFlipFitService {
	
	
	private static GymOwnerFlipFitService ownerServiceObj = null;
	GymFlipFitService gymService = new GymFlipFitServiceImpl();
	SlotFlipFitService slotService = SlotFlipFitServiceImpl.getInstance();
	GymOwnerDAO ownerDAO = GymOwnerDAOImpl.getInstance();
	
	private GymOwnerFlipFitServiceImpl() {
		
	}
	
	/**
	 * Returns the instance of GymOwnerFlipFitService.
	 * @return The instance of GymOwnerFlipFitService.
	 */
	public static synchronized GymOwnerFlipFitService getInstance() {
		if (ownerServiceObj == null)
			ownerServiceObj = new GymOwnerFlipFitServiceImpl();

		return ownerServiceObj;
	}


	/**
	 * Adds a new gym.
	 * 
	 */
	@Override
	public void addGym(Gym gym) {
		gymService.addGym(gym);
	}

	@Override
	public List<Gym> getAllGyms(int userId) {
		return gymService.getAllGymsById(userId);
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

	@Override
	public int getGymOwnerId(int userId) {
		return ownerDAO.getGymOwnerIdByUserId(userId);
	}
}
