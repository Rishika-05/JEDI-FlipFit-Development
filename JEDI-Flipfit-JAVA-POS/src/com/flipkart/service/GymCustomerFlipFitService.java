package com.flipkart.service;


import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.User;

public interface GymCustomerFlipFitService {
	boolean updateProfile(int gymCustomerId , GymCustomer newGymCustomer );

	GymCustomer viewProfile(int gymCustomerId);
	
	int getGymCustomerId(int userId);
}
