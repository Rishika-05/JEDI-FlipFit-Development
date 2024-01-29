package com.flipkart.service.serviceImpl;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;
import com.flipkart.dao.daoImpl.GymCustomerDAOImpl;
import com.flipkart.dao.daoImpl.GymOwnerDAOImpl;
import com.flipkart.dao.daoImpl.UserDAOImpl;
import com.flipkart.exception.InvalidCredentialsException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.UserFlipFitService;

public class UserFlipFitServiceImpl implements UserFlipFitService {
	
	private static UserFlipFitService userServiceObj = null;
	
	private UserFlipFitServiceImpl() {
		
	}
	
	public static synchronized UserFlipFitService getInstance() {
		if (userServiceObj == null)
			userServiceObj = new UserFlipFitServiceImpl();

		return userServiceObj;
	}

	@Override
	public boolean customerRegistration(GymCustomer customer) {
		
		return GymCustomerDAOImpl.getInstance().register(customer);
	}

	@Override
	public boolean gymOwnerRegistration(GymOwner gymOwner) {
		return GymOwnerDAOImpl.getInstance().register(gymOwner);
	}

	@Override
	public int registration(User user) {
		
		return UserDAOImpl.getInstance().createUser(user);
	}

	@Override
	public int login(String username, String password) {
		
		try {
			return UserDAOImpl.getInstance().verifyUser(username , password);
		} catch (InvalidCredentialsException | UserNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			 System.out.println(e.getMessage());
		}
		
		
		return -1;
	}

	@Override
	public boolean updatePassword(String userName, String newPassword) {
		
		return UserDAOImpl.getInstance().updatePassword(userName , newPassword);
	}

	@Override
	public RoleType getUserRole(int userId) {
		// TODO Auto-generated method stub
		return UserDAOImpl.getInstance().getUserRole(userId);
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return UserDAOImpl.getInstance().getUser(userId);
	}
	

}