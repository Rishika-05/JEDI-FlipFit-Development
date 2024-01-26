/**
 * 
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
 * 
 */

public class AdminFlipFitServiceImpl implements AdminFlipfitService {

	@Override
	public void verifyGymOwnerRequest(int gym_owner_id) {
		GymOwnerDAOImpl.getInstance().approveGymOwnerById(gym_owner_id); 
	}

	@Override
	public void approveGymRequest(int gym_id) {
		GymDAOImpl.getInstance().approveGymsById(gym_id);
	}

	@Override
	public List<Gym> getGymRequests() {
		return GymDAOImpl.getInstance().getAllGyms();
	}

	@Override
	public List<GymOwner> getGymOwnerRequests() {
		return GymOwnerDAOImpl.getInstance().getAllOwners();
	}

	@Override
	public List<GymCustomer> getAllGymCustomers() {
		return GymCustomerDAOImpl.getInstance().getAllGymCustomers();
	}

	@Override
	public List<GymOwner> getAllGymOwners() {
		return GymOwnerDAOImpl.getInstance().getAllOwners();
	}

	@Override
	public void approveSlotRequest(int slot_id) {
		SlotDAOImpl.getInstance().approveSlot(slot_id);
		
	}

	@Override
	public List<Slot> getSlotRequests() {
		return SlotDAOImpl.getInstance().getAllSlots();
	}

}
