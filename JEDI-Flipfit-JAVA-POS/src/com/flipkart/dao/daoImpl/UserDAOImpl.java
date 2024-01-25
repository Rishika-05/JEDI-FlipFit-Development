/**
 * 
 */
package com.flipkart.dao.daoImpl;

import java.util.ArrayList;

import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;
import com.flipkart.dao.UserDAO;
import com.flipkart.service.UserFlipFitService;
import com.flipkart.service.serviceImpl.UserFlipFitServiceImpl;

/**
 * 
 */
public class UserDAOImpl implements UserDAO {
	
	private static UserDAO userDAOObj = null;
	
	private UserDAOImpl() {
		
	}
	
	public static synchronized UserDAO getInstance() {
		if (userDAOObj == null)
			userDAOObj = new UserDAOImpl();

		return userDAOObj;
	}
	
	private ArrayList<User> users = new ArrayList<User>();
	private int userCount = 0;

	@Override
	public boolean createUser(User user) {
		for(User u: users) {
			if(u.getUsername().equals(user.getUsername())) {
				System.out.println("Username already exists!!!");
				return false;
			}
		}
		
		user.setUserId(userCount++);
		users.add(user);
		System.out.println("User added successfully");
		return true;
	}

	@Override
	public int verifyUser(String username, String password) {
		for(User user : users) {
			if(user.getUsername().equals(username)) {
				if(user.getPassword().equals(password)) {
					return user.getUserId();
				} else {
					return -1;
				}
			}
		}
		return -1;
	}

	@Override
	public boolean updatePassword(int userId, String newPassword) {
		if(userId >= userCount) return false;
		users.get(userId).setPassword(newPassword);
		return true;
	}

	@Override
	public RoleType getUserRole(int userId) {
		
		return users.get(userId).getRole();
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		for(User u: users) {
			if(u.getUserId() == userId) {
				return u;
			}
		}
		return null;
	}
	

}