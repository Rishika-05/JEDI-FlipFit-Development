/**
 * This class implements the GymFlipFitService interface and provides the implementation for various gym-related operations.
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
 * This class provides the implementation for the GymFlipFitService interface.
 */
public class GymFlipFitServiceImpl implements GymFlipFitService {
	
	private static GymFlipFitService gymServiceObj = null;
	
	public GymFlipFitServiceImpl() {
		
	}
	
	/**
	 * Returns the singleton instance of GymFlipFitService.
	 * 
	 * @return The singleton instance of GymFlipFitService.
	 */
	public static synchronized GymFlipFitService getInstance() {
		if (gymServiceObj == null)
			gymServiceObj = new GymFlipFitServiceImpl();

		return gymServiceObj;
	}
	
	GymDAO gymDAO = GymDAOImpl.getInstance();

	/**
	 * Returns a list of all gyms.
	 * 
	 * @return A list of Gym objects representing all gyms.
	 */
	@Override
	public List<Gym> viewAllGyms() {
		return gymDAO.getAllGyms();
	}

	/**
	 * Displays the details of a gym.
	 * 
	 * @param gymId The ID of the gym.
	 */
	@Override
	public void displayGymDetails(int gymId) {
		Gym g = gymDAO.getGym(gymId);
		System.out.println("Name: " + g.getGymName() + "\n Address: " + g.getLocation() +
				"\n Description: "+g.getGymDescription() + "\n Total Slots: "+ g.getTotalSlots() +"\n");
	}

	/**
	 * Retrieves a gym by its ID.
	 * 
	 * @param gymId The ID of the gym.
	 * @return The Gym object representing the gym.
	 */
	@Override
	public Gym getGym(int gymId) {
		return gymDAO.getGym(gymId);
	}

	/**
	 * Adds a new gym.
	 * 
	 * @param gym The Gym object representing the new gym.
	 */
	@Override
	public void addGym(Gym gym) {
		gymDAO.addGym(gym);
	}

	/**
	 * Removes a gym.
	 * 
	 * @param gymId The ID of the gym to be removed.
	 * @return true if the gym is successfully removed, false otherwise.
	 */
	@Override
	public boolean removeGym(int gymId) {
		gymDAO.removeGym(gymId);
		return true;
	}

	/**
	 * Updates the details of a gym.
	 * 
	 * @param gym The Gym object representing the updated gym details.
	 */
	@Override
	public void updateGym(Gym gym) {
		gymDAO.updateGym(gym);
	}

	/**
	 * Retrieves a list of all gyms owned by a gym owner.
	 * 
	 * @param gymOwnerId The ID of the gym owner.
	 * @return A list of Gym objects representing the gyms owned by the gym owner.
	 */
	@Override
	public List<Gym> getAllGymsById(int gymOwnerId) {
		return gymDAO.getAllGymsById(gymOwnerId);
	}

	/**
	 * Retrieves a list of all gyms in a specific location.
	 * 
	 * @param selectedLocation The location to filter the gyms by.
	 * @return A list of Gym objects representing the gyms in the specified location.
	 */
	@Override
	public List<Gym> getAllGymsByLoc(String selectedLocation) {
		return gymDAO.getAllGymsByLoc(selectedLocation);
	}

}
