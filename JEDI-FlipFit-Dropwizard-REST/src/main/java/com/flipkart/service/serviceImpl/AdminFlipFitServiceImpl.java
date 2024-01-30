/**
 * This class implements the AdminFlipfitService interface and provides the implementation for various administrative operations related to FlipFit.
 */
package com.flipkart.service.serviceImpl;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.dao.daoImpl.GymCustomerDAOImpl;
import com.flipkart.dao.daoImpl.GymDAOImpl;
import com.flipkart.dao.daoImpl.GymOwnerDAOImpl;
import com.flipkart.dao.daoImpl.SlotDAOImpl;
import com.flipkart.service.AdminFlipfitService;

/**
 * This class implements the AdminFlipfitService interface and provides the implementation for various administrative operations related to FlipFit.
 */
public class AdminFlipFitServiceImpl implements AdminFlipfitService {

	/**
	 * Verifies the gym owner request by approving the gym owner with the given ID.
	 * 
	 * @param gym_owner_id The ID of the gym owner to be verified.
	 */
	@Override
	public void verifyGymOwnerRequest(int gym_owner_id) {
		GymOwnerDAOImpl.getInstance().approveGymOwnerById(gym_owner_id); 
	}

	/**
	 * Approves the gym request with the given ID.
	 * 
	 * @param gym_id The ID of the gym to be approved.
	 */
	@Override
	public void approveGymRequest(int gym_id) {
		GymDAOImpl.getInstance().approveGymsById(gym_id);
	}

	/**
	 * Retrieves a list of gym requests.
	 * 
	 * @return A list of Gym objects representing the gym requests.
	 */
	@Override
	public List<Gym> getGymRequests() {
		return GymDAOImpl.getInstance().getAllGyms();
	}

	/**
	 * Retrieves a list of gym owner requests.
	 * 
	 * @return A list of GymOwner objects representing the gym owner requests.
	 */
	@Override
	public List<GymOwner> getGymOwnerRequests() {
		return GymOwnerDAOImpl.getInstance().getAllOwners();
	}

	/**
	 * Retrieves a list of all gym customers.
	 * 
	 * @return A list of GymCustomer objects representing all gym customers.
	 */
	@Override
	public List<GymCustomer> getAllGymCustomers() {
		return GymCustomerDAOImpl.getInstance().getAllGymCustomers();
	}

	/**
	 * Retrieves a list of all gym owners.
	 * 
	 * @return A list of GymOwner objects representing all gym owners.
	 */
	@Override
	public List<GymOwner> getAllGymOwners() {
		return GymOwnerDAOImpl.getInstance().getAllOwners();
	}

	/**
	 * Approves the slot request with the given ID.
	 * 
	 * @param slot_id The ID of the slot to be approved.
	 */
	@Override
	public void approveSlotRequest(int slot_id) {
		SlotDAOImpl.getInstance().approveSlot(slot_id);
	}

	/**
	 * Retrieves a list of slot requests.
	 * 
	 * @return A list of Slot objects representing the slot requests.
	 */
	@Override
	public List<Slot> getSlotRequests() {
		return SlotDAOImpl.getInstance().getAllSlots();
	}

}
