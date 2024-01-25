/**
 * 
 */
package com.flipkart.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.Slot;
import com.flipkart.bean.User;
import com.flipkart.dao.daoImpl.GymCustomerDAOImpl;
import com.flipkart.dao.daoImpl.SlotDAOImpl;
import com.flipkart.service.GymCustomerFlipFitService;
import com.flipkart.service.UserFlipFitService;

/**
 * 
 */

public class GymCustomerFlipFitServiceImpl implements GymCustomerFlipFitService {
	
	private static GymCustomerFlipFitService gymCustomerServiceObj = null;
	BookingFlipFitServiceImpl bookingService = new BookingFlipFitServiceImpl();
	SlotFlipFitServiceImpl slotService = new SlotFlipFitServiceImpl();
	SlotDAOImpl slotDAO = new SlotDAOImpl();
	
	private GymCustomerFlipFitServiceImpl() {
		
	}
	
	public static synchronized GymCustomerFlipFitService getInstance() {
		if (gymCustomerServiceObj == null)
			gymCustomerServiceObj = new GymCustomerFlipFitServiceImpl();

		return gymCustomerServiceObj;
	}


	@Override
	public void bookWorkout(int userId, int gymId, int slotId) {
		Slot slot = slotDAO.getSlot(slotId);
		
		if(slot.getAvilableSeats()-slot.getFilledSeats() <= 0) {
			System.out.println("Slots not available. Adding to Waitlist");
		} else {
			slotService.decrementFilledSeats(slotId);
			bookingService.insertBooking(slotId, gymId, slotId);
			System.out.println("Booking is successful");
		}
		
	}

	@Override
	public void cancelBooking(int bookingId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Booking> getBookings(int userId) {
		// TODO Auto-generated method stub
		return null;
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
	public void cancelSlot(int gymID, int slotHour, int userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bookSlot(int gymId, int slotHour, int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getGymCustomerId(int userId) {
		return GymCustomerDAOImpl.getInstance().getGymCustomerIdFromUserId(userId);
	}
	
	
		


}
