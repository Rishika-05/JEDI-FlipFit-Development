/**
 * 
 */
package com.flipkart.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.BookingDetails;
import com.flipkart.bean.Slot;
import com.flipkart.bean.User;
import com.flipkart.dao.BookingDAO;
import com.flipkart.dao.daoImpl.BookingDAOImpl;
import com.flipkart.service.BookingFlipFitService;

/**
 * 
 */
public class BookingFlipFitServiceImpl implements BookingFlipFitService {


	BookingDAO bookingDao = new BookingDAOImpl();
	@Override
	public boolean insertBooking(int userId,int gymID,int slotId) {
		// TODO Auto-generated method stub
		bookingDao.insertBooking(userId, gymID, slotId);

		return true;
	}

	@Override
	public boolean cancelBooking(int bookingId) {
		// TODO Auto-generated method stub
		bookingDao.cancelBooking(bookingId);
		return true;
	}

	@Override
	public Booking getBooking(int bookingId) {
		return bookingDao.getBooking(bookingId);
	}

	@Override
	public List<Booking> getBookingsByUserId(int userId) {
		return bookingDao.getBookingsByUserId(userId);
	}

	@Override
	public List<Booking> getBookingsByGymId(int gymId) {
		return bookingDao.getBookingsByGymId(gymId);
	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingDao.getAllBookings();
	}

	@Override
	public List<Booking> getBookingsBySlotId(int slotId) {
		return getBookingsBySlotId(slotId);
	}



}
