/**
 * 
 */
package com.flipkart.dao.daoImpl;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constant.SQLConstants;
import com.flipkart.dao.DBConnection;
import com.flipkart.dao.GymOwnerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 */
public class GymOwnerDAOImpl implements GymOwnerDAO {
    ArrayList<GymOwner> gymOwners = new ArrayList<GymOwner>();
    private static GymOwnerDAO gymOwnerDaoObj = null;

    private GymOwnerDAOImpl() {
    }

    public static synchronized GymOwnerDAO getInstance() {
        if (gymOwnerDaoObj == null)
            gymOwnerDaoObj = new GymOwnerDAOImpl();

        return gymOwnerDaoObj;
    }


    @Override
    public GymOwner getGymOwnerById(int gymOwnerId) {
    	System.out.println(gymOwnerId);
        Connection connection = DBConnection.getConnection();
        GymOwner gymOwner = null;
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_OWNER_BY_ID)) {
                preparedStatement.setInt(1, gymOwnerId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    gymOwner = extractGymOwnerFromResultSet(resultSet);
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
        return gymOwner;
    }

    @Override
    public GymOwner updateProfile(GymOwner owner) {
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.UPDATE_PROFILE)) {
                preparedStatement.setString(1, owner.getName());
                preparedStatement.setInt(2, owner.getAge());
                preparedStatement.setString(3, owner.getPanCard());
                preparedStatement.setString(4, owner.getAadharCard());
                preparedStatement.setString(5, owner.getGstin());
                preparedStatement.setString(6, owner.getLocation());
                preparedStatement.setInt(7, owner.getUserId());
                preparedStatement.executeUpdate();
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
        return owner;
    }

    @Override
    public List<GymOwner> getAllOwners() {
        List<GymOwner> gymOwners = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(SQLConstants.SELECT_ALL_OWNERS)) {
                while (resultSet.next()) {
                    GymOwner owner = extractGymOwnerFromResultSet(resultSet);
                    gymOwners.add(owner);
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
        return gymOwners;
    }


    @Override
    public boolean register(GymOwner owner) {
        Connection connection = DBConnection.getConnection();
        boolean registered = false;
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.INSERT_OWNER)) {
                prepareStatementForGymOwnerRegistration(preparedStatement, owner);
                int rowsUpdated = preparedStatement.executeUpdate();
                registered = rowsUpdated > 0;
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
        return registered;
    }

    @Override
    public void approveGymOwnerById(int gymOwnerId) {
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.APPROVE_GYM_OWNER)) {
                preparedStatement.setBoolean(1, true);
                preparedStatement.setInt(2, gymOwnerId);
                preparedStatement.executeUpdate();
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
    }

    // Helper method to extract GymOwner from ResultSet
    private GymOwner extractGymOwnerFromResultSet(ResultSet resultSet) throws SQLException {
        GymOwner owner = new GymOwner();
        owner.setUserId(resultSet.getInt("userId"));
        owner.setOwnerId(resultSet.getInt("ID"));
        owner.setName(resultSet.getString("name"));
        owner.setAge(resultSet.getInt("age"));
        owner.setPanCard(resultSet.getString("panCard"));
        owner.setAadharCard(resultSet.getString("aadharCard"));
        owner.setGstin(resultSet.getString("gstin"));
        owner.setLocation(resultSet.getString("location"));
        owner.setApproved(resultSet.getBoolean("approved"));
        return owner;
    }

    // Helper method to prepare statement for GymOwner registration
    private void prepareStatementForGymOwnerRegistration(PreparedStatement preparedStatement, GymOwner owner) throws SQLException {
        preparedStatement.setString(1, owner.getName());
        preparedStatement.setInt(2, owner.getAge());
        preparedStatement.setString(3, owner.getPanCard());
        preparedStatement.setString(4, owner.getAadharCard());
        preparedStatement.setString(5, owner.getGstin());
        preparedStatement.setString(6, owner.getLocation());
        preparedStatement.setBoolean(7, owner.isApproved());
        preparedStatement.setInt(8, owner.getUserId());
    }

	@Override
	public int getGymOwnerIdByUserId(int userId) {
		int gymOwnerId = -1;
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_GYM_OWNER_ID_FROM_USER_ID)) {
                preparedStatement.setInt(1, userId);
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        gymOwnerId = rs.getInt("ID");
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
        return gymOwnerId;
		
	}
    
}
