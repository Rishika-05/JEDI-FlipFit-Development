/**
 * 
 */

package com.flipkart.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBUtils;
import com.flipkart.dao.GymCustomerDAO;

/**
 * 
 */

public class GymCustomerDAOImpl implements GymCustomerDAO {

    private static GymCustomerDAO customerDaoObj = null;

    public static synchronized GymCustomerDAO getInstance() {
        if (customerDaoObj == null)
            customerDaoObj = new GymCustomerDAOImpl();

        return customerDaoObj;
    }
    
    @Override
    public GymCustomer viewProfile(int gymCustomerId) {
        GymCustomer gymCustomer = null;
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_GYM_CUSTOMER +
                    SQLConstants.WHERE_GYM_CUSTOMER_ID)) {
                preparedStatement.setInt(1, gymCustomerId);

                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        gymCustomer = new GymCustomer();
                        gymCustomer.setCustomerId(rs.getInt("ID"));
                        gymCustomer.setName(rs.getString("name"));
                        gymCustomer.setLocation(rs.getString("location"));
                        gymCustomer.setUserId(rs.getInt("userId"));
                        gymCustomer.setAge(rs.getInt("age"));
                        gymCustomer.setPhoneNo(rs.getString("phoneNo"));
                        gymCustomer.setEmail(rs.getString("email"));
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
        return gymCustomer;
    }


    /**
     * 
     */
    @Override
    public boolean register(GymCustomer customer) {
        int rowsUpdated = 0;
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.INSERT_GYM_CUSTOMER)) {
                prepareStatement(preparedStatement, customer);
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
    public void delete(int gymCustomerId) {
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.DELETE_GYM_CUSTOMER)) {
                preparedStatement.setInt(1, gymCustomerId);
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
    public boolean update(int gymCustomerId, GymCustomer newCustomer) {
        int rowsUpdated = 0;
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.UPDATE_GYM_CUSTOMER)) {
                prepareStatementForGymCustomerUpdate(preparedStatement, newCustomer);
                preparedStatement.setInt(4, gymCustomerId);
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
    public ArrayList<GymCustomer> getAllGymCustomers() {
        ArrayList<GymCustomer> gymCustomers = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_ALL_GYM_CUSTOMERS)) {
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        GymCustomer gymCustomer = new GymCustomer();
                        gymCustomer.setCustomerId(rs.getInt("ID"));
                        gymCustomer.setName(rs.getString("name"));
                        gymCustomer.setLocation(rs.getString("location"));
                        gymCustomer.setUserId(rs.getInt("userId"));
                        gymCustomer.setAge(rs.getInt("age"));
                        gymCustomer.setPhoneNo(rs.getString("phoneNo"));
                        gymCustomer.setEmail(rs.getString("email"));
                        gymCustomers.add(gymCustomer);
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
        return gymCustomers;
    }

    @Override
    public int getGymCustomerIdFromUserId(int userId) {
        int gymCustomerId = -1;
        Connection connection = DBUtils.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_GYM_CUSTOMER_ID_FROM_USER_ID)) {
                preparedStatement.setInt(1, userId);
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        gymCustomerId = rs.getInt("ID");
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
        return gymCustomerId;
    }
    private void prepareStatementForGymCustomerUpdate(PreparedStatement preparedStatement, GymCustomer newCustomer) throws SQLException {
        preparedStatement.setString(1, newCustomer.getName());
        preparedStatement.setInt(3, newCustomer.getAge());
        preparedStatement.setString(2, newCustomer.getLocation());
    }
    private void prepareStatement(PreparedStatement preparedStatement, GymCustomer gymCustomer) throws SQLException {
        preparedStatement.setString(1, gymCustomer.getName());
        preparedStatement.setString(2, gymCustomer.getLocation());
        preparedStatement.setInt(3, gymCustomer.getUserId());
        preparedStatement.setInt(4, gymCustomer.getAge());
        preparedStatement.setString(5, gymCustomer.getPhoneNo());
        preparedStatement.setString(6, gymCustomer.getEmail());
    }

}
