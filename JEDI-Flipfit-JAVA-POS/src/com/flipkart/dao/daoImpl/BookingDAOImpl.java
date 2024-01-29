/**
 * 
 */
package com.flipkart.dao.daoImpl;

import com.flipkart.bean.Booking;
import com.flipkart.constant.SQLConstants;
import com.flipkart.dao.BookingDAO;
import com.flipkart.dao.DBConnection;
import com.flipkart.dao.GymDAO;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 */
public class BookingDAOImpl implements BookingDAO {
	private static BookingDAO bookingDAOObj = null;
	
	private BookingDAOImpl() {
		
	}
	
	public static synchronized BookingDAO getInstance() {
		if (bookingDAOObj == null)
			bookingDAOObj = new BookingDAOImpl();

		return bookingDAOObj;
	}
	 @Override
	    public void insertBooking(int userId, int gymID, int slotId) {
	        Connection connection = DBUtils.getConnection();
	        if (connection != null) {
	            try {
	                PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.INSERT_BOOKING);
	                preparedStatement.setInt(1, userId);
	                preparedStatement.setInt(2, gymID);
	                preparedStatement.setInt(3, slotId);
//	                preparedStatement.setBoolean(4, false); // isCancelled default to false
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
	    public boolean cancelBooking(int bookingId) {
	        Connection connection = DBUtils.getConnection();
	        if (connection != null) {
	            try {
	                PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.CANCEL_BOOKING);
	                preparedStatement.setInt(1, bookingId);
	                int rowsUpdated = preparedStatement.executeUpdate();
	                return rowsUpdated > 0;
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
	        return false;
	    }

	    @Override
	    public Booking getBooking(int bookingId) {
	        Connection connection = DBUtils.getConnection();
	        if (connection != null) {
	            try {
	                PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_BOOKING_BY_ID);
	                preparedStatement.setInt(1, bookingId);
	                ResultSet resultSet = preparedStatement.executeQuery();
	                if (resultSet.next()) {
	                    return extractBookingFromResultSet(resultSet);
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
	        return null;
	    }

	    @Override
	    public List<Booking> getBookingsByUserId(int userId) {
	        Connection connection = DBUtils.getConnection();
	        List<Booking> bookings = new ArrayList<>();
	        if (connection != null) {
	            try {
	                PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_BOOKINGS_BY_USER_ID);
	                preparedStatement.setInt(1, userId);
	                ResultSet resultSet = preparedStatement.executeQuery();
	                while (resultSet.next()) {
	                    bookings.add(extractBookingFromResultSet(resultSet));
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
	        return bookings;
	    }
	    @Override
	    public List<Booking> getBookingsByGymId(int gymId) {
	        Connection connection = DBUtils.getConnection();
	        List<Booking> bookings = new ArrayList<>();
	        if (connection != null) {
	            try {
	                PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_BOOKINGS_BY_GYM_ID);
	                preparedStatement.setInt(1, gymId);
	                ResultSet resultSet = preparedStatement.executeQuery();
	                while (resultSet.next()) {
	                    bookings.add(extractBookingFromResultSet(resultSet));
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
	        return bookings;
	    }
	    
	    @Override
	    public List<Booking> getBookingsBySlotId(int slotId) {
	        Connection connection = DBUtils.getConnection();
	        List<Booking> bookings = new ArrayList<>();
	        if (connection != null) {
	            try {
	                PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_BOOKINGS_BY_SLOT_ID);
	                preparedStatement.setInt(1, slotId);
	                ResultSet resultSet = preparedStatement.executeQuery();
	                while (resultSet.next()) {
	                    bookings.add(extractBookingFromResultSet(resultSet));
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
	        return bookings;
	    }

	    @Override
	    public List<Booking> getAllBookings() {
	        Connection connection = DBUtils.getConnection();
	        List<Booking> bookings = new ArrayList<>();
	        if (connection != null) {
	            try {
	                PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_ALL_BOOKINGS);
	                ResultSet resultSet = preparedStatement.executeQuery();
	                while (resultSet.next()) {
	                    bookings.add(extractBookingFromResultSet(resultSet));
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
	        return bookings;
	    }

	    @Override
	    public boolean removeBookingOfInactiveGym(int gymId) {
	        Connection connection = DBUtils.getConnection();
	        if (connection != null) {
	            try {
	                PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.REMOVE_BOOKING_OF_INACTIVE_GYM);
	                preparedStatement.setInt(1, gymId);
	                int rowsUpdated = preparedStatement.executeUpdate();
	                return rowsUpdated > 0;
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
	        return false;
	    }

	    private Booking extractBookingFromResultSet(ResultSet resultSet) throws SQLException {
	        Booking booking = new Booking();
	        booking.setBookingId(resultSet.getInt("ID"));
	        booking.setUserId(resultSet.getInt("userId"));
	        booking.setGymId(resultSet.getInt("gymId"));
	        booking.setSlotId(resultSet.getInt("slotId"));
	        Timestamp timestamp = resultSet.getTimestamp("bookingDate");
	        booking.setBookingDate(timestamp.toLocalDateTime());
	        booking.setCancelled(resultSet.getBoolean("isCancelled"));
	        return booking;
	    }
}

