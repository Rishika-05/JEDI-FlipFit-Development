/**
 * 
 */
package com.flipkart.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;
import com.flipkart.constant.SQLConstants;
import com.flipkart.dao.DBConnection;
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
	public int createUser(User user) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.INSERT_USER);
				prepareStatement(preparedStatement, user);
				rowsUpdated = preparedStatement.executeUpdate();
				if(rowsUpdated != 0) {
					return verifyUser(user.getUsername(), user.getPassword());
				}
			} catch(SQLIntegrityConstraintViolationException e) {
				System.out.println("This username already exists!!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsUpdated;
	}

	@Override
	public int verifyUser(String username, String password) {
		User user = null;
		Connection connection = DBConnection.getConnection();
		String generatedColumns[] = { "ID" };
		if (connection != null) {
			try {
				String selectQuery = SQLConstants.SELECT_USER + SQLConstants.WHERE_USERNAME + "'"+username+"'";
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery, generatedColumns);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					 //Retrieve by column name
					 int userID  = rs.getInt("ID");
					 String usernameRecieved = rs.getString("username");
					 String passwordRecieved = rs.getString("password");
					 String roleRecieved = rs.getString("role");
					 
					 if(!password.equals(passwordRecieved)) {
						 System.out.println("Wrong username or password please try again!!");
					 }else {
						 user = new User();
						 user.setUserId(userID);
						 user.setPassword(passwordRecieved);
						 user.setRole(RoleType.valueOf(roleRecieved));
						 user.setUsername(usernameRecieved);
					 }
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(user);
		return user != null ? user.getUserId(): -1 ;
	}

	@Override
	public boolean updatePassword(String userName, String newPassword) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.UPDATE_USER_PASSWORD);
				preparedStatement.setString(1,newPassword);
				preparedStatement.setString(2,userName);
				rowsUpdated = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsUpdated > 0;
	}

	@Override
	public RoleType getUserRole(int userId) {
		
		RoleType role = null;
	    Connection connection = DBConnection.getConnection();
	    if (connection != null) {
	        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_USER +
	                SQLConstants.WHERE_ID)) {
	            preparedStatement.setInt(1, userId);
	            try (ResultSet rs = preparedStatement.executeQuery()) {
	                if (rs.next()) {
	                    String roleRecieved = rs.getString("role");
	                    role = RoleType.valueOf(roleRecieved); // Assuming role is stored as string in DB
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return role;
	}

	@Override
	public User getUser(int userId) {
		User user = null;
	    Connection connection = DBConnection.getConnection();
	    if (connection != null) {
	        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_USER +
	                SQLConstants.WHERE_ID)) {
	            preparedStatement.setInt(1, userId);
	            try (ResultSet rs = preparedStatement.executeQuery()) {
	                if (rs.next()) {
	                    user = new User();
	                    user.setUserId(rs.getInt("ID"));
	                    user.setUsername(rs.getString("username"));
	                    user.setPassword(rs.getString("password"));
	                    user.setRole(RoleType.valueOf(rs.getString("role"))); // Assuming role is stored as string in DB
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return user;
	}
	
	private void prepareStatement(PreparedStatement preparedStatement, User user) {
		try {
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRole().toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
