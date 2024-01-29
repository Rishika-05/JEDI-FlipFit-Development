/**
 * This class implements the GymCustomerFlipFitService interface and provides the implementation for various operations related to GymCustomer.
 */
package com.flipkart.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.User;
import com.flipkart.dao.daoImpl.GymCustomerDAOImpl;
import com.flipkart.service.GymCustomerFlipFitService;
import com.flipkart.service.UserFlipFitService;

/**
 * This class provides the implementation for the GymCustomerFlipFitService interface.
 */
public class GymCustomerFlipFitServiceImpl implements GymCustomerFlipFitService {
	
	private static GymCustomerFlipFitService gymCustomerServiceObj = null;
	
	private GymCustomerFlipFitServiceImpl() {
		
	}
	
	/**
	 * Returns the singleton instance of GymCustomerFlipFitService.
	 * 
	 * @return The singleton instance of GymCustomerFlipFitService.
	 */
	public static synchronized GymCustomerFlipFitService getInstance() {
		if (gymCustomerServiceObj == null)
			gymCustomerServiceObj = new GymCustomerFlipFitServiceImpl();

		return gymCustomerServiceObj;
	}
	
	/**
	 * Registers a new GymCustomer.
	 * 
	 * @param gymCustomerId The ID of the GymCustomer.
	 * @param newGymCustomer The new GymCustomer object.
	 * @return True if the profile is updated successfully, false otherwise.
	 */
	@Override
	public boolean updateProfile(int gymCustomerId, GymCustomer newGymCustomer) {
		// TODO Auto-generated method stub
		return GymCustomerDAOImpl.getInstance().update(gymCustomerId, newGymCustomer);
	}

	/**
	 * Retrieves the profile of a GymCustomer.
	 * 
	 * @param gymCustomerId The ID of the GymCustomer.
	 * @return The GymCustomer object.
	 */
	@Override
	public GymCustomer viewProfile(int gymCustomerId) {
		return GymCustomerDAOImpl.getInstance().viewProfile(gymCustomerId);
	}

	/**
	 * Retrieves the GymCustomer ID associated with a user.
	 * 
	 * @param userId The ID of the user.
	 * @return The GymCustomer ID.
	 */
	@Override
	public int getGymCustomerId(int userId) {
		return GymCustomerDAOImpl.getInstance().getGymCustomerIdFromUserId(userId);
	}
}
