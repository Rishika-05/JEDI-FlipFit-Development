package com.flipkart.service.serviceImpl;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;
import com.flipkart.dao.UserDAO;
import com.flipkart.dao.UserDAOImpl;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gymOwnerRegistration(GymOwner gymOwner) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registration(User user) {
		if(UserDAOImpl.getInstance().createUser(user)) return true;
		return false;
	}

	@Override
	public int login(String username, String password) {
		
		return UserDAOImpl.getInstance().verifyUser(username , password);
	}

	@Override
	public int updatePassword(int userId, String newPassword) {
		
		return 0;
	}

	@Override
	public RoleType getUserRole(int userId) {
		// TODO Auto-generated method stub
		return UserDAOImpl.getInstance().getUserRole(userId);
	}
	
	

}
