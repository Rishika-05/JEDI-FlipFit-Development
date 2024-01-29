/**
 * 
 */
package com.flipkart.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBUtils;
import com.flipkart.dao.GymDAO;

/**
 * 
 */
public class GymDAOImpl implements GymDAO {
private static GymDAO gymDAOObj = null;
	
	private GymDAOImpl() {
		
	}
	
	public static synchronized GymDAO
	getInstance() {
		if (gymDAOObj == null)
			gymDAOObj = new GymDAOImpl();

		return gymDAOObj;
	}
	


    @Override
    public List<Gym> getAllGyms() {
        List<Gym> gyms = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(SQLConstants.SELECT_ALL_GYMS)) {
                while (resultSet.next()) {
                    Gym gym = extractGymFromResultSet(resultSet);
                    gyms.add(gym);
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
        return gyms;
    }

    @Override
    public Gym getGym(int gymId) {
        Gym gym = null;
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_GYM_BY_ID)) {
                preparedStatement.setInt(1, gymId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    gym = extractGymFromResultSet(resultSet);
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
        return gym;
    }

    @Override
    public void addGym(Gym gym) {
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.INSERT_GYM)) {
                prepareStatementForGym(preparedStatement, gym);
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

    @Override
    public boolean removeGym(int gymId) {
    	int rowsUpdated = 0;
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.DELETE_GYM)) {
                preparedStatement.setInt(1, gymId);
                rowsUpdated = preparedStatement.executeUpdate();
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
        return rowsUpdated > 0;
    }

    @Override
    public boolean updateGym(Gym gym) {
    	int rowsUpdated = 0;
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.UPDATE_GYM)) {
                prepareStatementForGymUpdate(preparedStatement, gym);
                rowsUpdated = preparedStatement.executeUpdate();
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
        return rowsUpdated > 0;
    }

    @Override
    public List<Gym> getAllGymsById(int userId) {
        List<Gym> gyms = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_ALL_GYMS_BY_OWNER_ID)) {
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Gym gym = extractGymFromResultSet(resultSet);
                    gyms.add(gym);
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
        return gyms;
    }

    @Override
    public List<Gym> getAllGymsByLoc(String selectedLocation) {
        List<Gym> gyms = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_ALL_GYMS_BY_LOCATION)) {
                preparedStatement.setString(1, selectedLocation);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Gym gym = extractGymFromResultSet(resultSet);
                    gyms.add(gym);
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
        return gyms;
    }
    
    private Gym extractGymFromResultSet(ResultSet rs) throws SQLException {
        Gym gym = new Gym();
        gym.setGymId(rs.getInt("ID"));
        gym.setTotalSlots(rs.getInt("totalSlots"));
        gym.setApproved(rs.getBoolean("approved"));
        gym.setActive(rs.getBoolean("active"));
        gym.setLocation(rs.getString("location"));
        gym.setGymName(rs.getString("gymName"));
        gym.setGymDescription(rs.getString("gymDescription"));
        gym.setGymOwnerId(rs.getInt("gymOwnerId"));
        gym.setPricePerSlot(rs.getInt("pricePerSlot"));
        return gym;
    }
    
    private void prepareStatementForGymUpdate(PreparedStatement preparedStatement, Gym gym) throws SQLException {
        preparedStatement.setInt(1, gym.getTotalSlots());
        preparedStatement.setBoolean(2, gym.isApproved());
        preparedStatement.setBoolean(3, gym.isActive());
        preparedStatement.setString(4, gym.getLocation());
        preparedStatement.setString(5, gym.getGymName());
        preparedStatement.setString(6, gym.getGymDescription());
        preparedStatement.setInt(7, gym.getGymOwnerId());
        preparedStatement.setInt(8, gym.getPricePerSlot());
        preparedStatement.setInt(9, gym.getGymId());
    }

    private void prepareStatementForGym(PreparedStatement preparedStatement, Gym gym) throws SQLException {
        preparedStatement.setInt(1, gym.getTotalSlots());
        preparedStatement.setBoolean(2, gym.isApproved());
        preparedStatement.setBoolean(3, gym.isActive());
        preparedStatement.setString(4, gym.getLocation());
        preparedStatement.setString(5, gym.getGymName());
        preparedStatement.setString(6, gym.getGymDescription());
        preparedStatement.setInt(7, gym.getGymOwnerId());
        preparedStatement.setInt(8, gym.getPricePerSlot());
    }

    @Override
    public boolean approveGymsById(int gymId) {
    	int rowsUpdated = 0;
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.APPROVE_GYM_BY_ID)) {
                preparedStatement.setInt(1, gymId);
                rowsUpdated = preparedStatement.executeUpdate();
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
        return rowsUpdated > 0;
    }

    @Override
    public List<Gym> getAllActiveGyms() {
        List<Gym> activeGyms = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(SQLConstants.SELECT_ALL_ACTIVE_GYMS)) {
                while (resultSet.next()) {
                    Gym gym = extractGymFromResultSet(resultSet);
                    activeGyms.add(gym);
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
        return activeGyms;
    }


}
