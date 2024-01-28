/**
 * 
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
 * 
 */

public class GymCustomerFlipFitServiceImpl implements GymCustomerFlipFitService {
	
	private static GymCustomerFlipFitService gymCustomerServiceObj = null;
	
	private GymCustomerFlipFitServiceImpl() {
		
	}
	
	public static synchronized GymCustomerFlipFitService getInstance() {
		if (gymCustomerServiceObj == null)
			gymCustomerServiceObj = new GymCustomerFlipFitServiceImpl();

		return gymCustomerServiceObj;
	}
	

	@Override
	public boolean updateProfile(int gymCustomerId, GymCustomer newGymCustomer) {
		// TODO Auto-generated method stub
		return GymCustomerDAOImpl.getInstance().update(gymCustomerId, newGymCustomer);
	}

	@Override
	public GymCustomer viewProfile(int gymCustomerId) {
		
		return GymCustomerDAOImpl.getInstance().viewProfile(gymCustomerId);
	}



	@Override
	public int getGymCustomerId(int userId) {
		return GymCustomerDAOImpl.getInstance().getGymCustomerIdFromUserId(userId);
	}
	
	
		


}
