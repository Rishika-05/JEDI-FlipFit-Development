/**
 * 
 */
package com.flipkart.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.dao.GymDAO;
import com.flipkart.dao.daoImpl.GymDAOImpl;
import com.flipkart.service.GymFlipFitService;
import com.flipkart.service.UserFlipFitService;

/**
 * 
 */
public class GymFlipFitServiceImpl implements GymFlipFitService {
	
private static GymFlipFitService gymServiceObj = null;
	
	public GymFlipFitServiceImpl() {
		
	}
	
	public static synchronized GymFlipFitService getInstance() {
		if (gymServiceObj == null)
			gymServiceObj = new GymFlipFitServiceImpl();

		return gymServiceObj;
	}
	
	GymDAO gymDAO = GymDAOImpl.getInstance();

	@Override
	public List<Gym> viewAllGyms() {
		return gymDAO.getAllGyms();
	}

	
	//Remove
	@Override
	public void displayGymDetails(int gymId) {
		Gym g = gymDAO.getGym(gymId);
		System.out.println("Name: " + g.getGymName() + "\n Address: " + g.getLocation() +
				"\n Description: "+g.getGymDescription() + "\n Total Slots: "+ g.getTotalSlots() +"\n");
	}


	@Override
	public Gym getGym(int gymId) {
		return gymDAO.getGym(gymId);
	}

	@Override
	public void addGym(Gym gym) {
		//  ownerId,  slots,  name,  loc,  des
		
		gymDAO.addGym(gym);
	}


	@Override
	public boolean removeGym(int gymId) {
		gymDAO.removeGym(gymId);
		return true;
	}


	@Override
	public void updateGym(Gym gym) {
		gymDAO.updateGym(gym);
	}

	@Override
	public List<Gym> getAllGymsById(int gymOwnerId) {
		return gymDAO.getAllGymsById(gymOwnerId);
	}

	@Override
	public List<Gym> getAllGymsByLoc(String selectedLocation) {
		return gymDAO.getAllGymsByLoc(selectedLocation);
	}

}
