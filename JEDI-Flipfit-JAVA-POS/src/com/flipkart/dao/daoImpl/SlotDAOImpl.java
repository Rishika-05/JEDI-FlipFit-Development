/**
 * 
 */
package com.flipkart.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import com.flipkart.bean.Slot;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBUtils;
import com.flipkart.dao.SlotDAO;

/**
 * 
 */
public class SlotDAOImpl implements SlotDAO {	
	
	private static SlotDAO slotDAOObj = null;
	
	
	
	public static synchronized SlotDAO getInstance() {
		if (slotDAOObj == null)
			slotDAOObj = new SlotDAOImpl();

		return slotDAOObj;
	}
	
	  @Override
	    public void createSlot(Slot slot) {
	        Connection connection = DBUtils.getConnection();
	        if (connection != null) {
	            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.INSERT_SLOT)) {
	                prepareStatementForSlot(preparedStatement, slot);
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
	    public boolean deleteSlot(int slotId) {
	    	int rowsUpdated = 0;
	        Connection connection = DBUtils.getConnection();
	        if (connection != null) {
	            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.DELETE_SLOT)) {
	                preparedStatement.setBoolean(1, false);
	                preparedStatement.setInt(2, slotId);
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
	    public boolean approveSlot(int slotId) {
	    	int rowsUpdated = 0;
	        Connection connection = DBUtils.getConnection();
	        if (connection != null) {
	            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.APPROVE_SLOT)) {
	                preparedStatement.setBoolean(1, true);
	                preparedStatement.setInt(2, slotId);
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
	    public Slot getSlot(int slotId) {
	        Slot slot = null;
	        Connection connection = DBUtils.getConnection();
	        if (connection != null) {
	            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_SLOT)) {
	                preparedStatement.setInt(1, slotId);
	                ResultSet resultSet = preparedStatement.executeQuery();
	                while (resultSet.next()) {
	                    slot = extractSlotFromResultSet(resultSet);
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
	        return slot;
	    }

	    @Override
	    public ArrayList<Slot> getAllSlots() {
	        ArrayList<Slot> slots = new ArrayList<>();
	        Connection connection = DBUtils.getConnection();
	        if (connection != null) {
	            try (Statement statement = connection.createStatement()) {
	                ResultSet resultSet = statement.executeQuery(SQLConstants.SELECT_ALL_SLOTS);
	                while (resultSet.next()) {
	                    Slot slot = extractSlotFromResultSet(resultSet);
	                    slots.add(slot);
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
	        return slots;
	    }

	    @Override
	    public ArrayList<Slot> getAllSlots(int gymId) {
	        ArrayList<Slot> slots = new ArrayList<>();
	        Connection connection = DBUtils.getConnection();
	        if (connection != null) {
	            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_SLOTS_BY_GYM)) {
	                preparedStatement.setInt(1, gymId);
	                ResultSet resultSet = preparedStatement.executeQuery();
	                while (resultSet.next()) {
	                    Slot slot = extractSlotFromResultSet(resultSet);
	                    slots.add(slot);
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
	        return slots;
	    }
	    
	    @Override
	    public ArrayList<Slot> getAllApprovedSlots(int gymId) {
	        ArrayList<Slot> slots = new ArrayList<>();
	        Connection connection = DBUtils.getConnection();
	        if (connection != null) {
	            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SELECT_APPROVED_SLOTS_BY_GYM)) {
	                preparedStatement.setInt(1, gymId);
	                ResultSet resultSet = preparedStatement.executeQuery();
	                while (resultSet.next()) {
	                    Slot slot = extractSlotFromResultSet(resultSet);
	                    slots.add(slot);
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
	        return slots;
	    }

	    @Override
	    public Slot updateSlot(Slot slot) {
	        Connection connection = DBUtils.getConnection();
	        if (connection != null) {
	            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.UPDATE_SLOT)) {
	                prepareStatementForSlot(preparedStatement, slot);
	                preparedStatement.setInt(7, slot.getSlotId());
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
	        return slot;
	    }

	    // Helper method to prepare statement for Slot
	    private void prepareStatementForSlot(PreparedStatement preparedStatement, Slot slot) throws SQLException {
	        preparedStatement.setInt(1, slot.getGymId());
	        preparedStatement.setTime(2, Time.valueOf(slot.getStartTime()));
	        preparedStatement.setInt(3, slot.getSlotTime());
	        preparedStatement.setInt(4, slot.getTotalSeats());
	        preparedStatement.setBoolean(5, slot.isActive());
	        preparedStatement.setBoolean(6, slot.isApproved());
	    }

	    // Helper method to extract Slot from ResultSet
	    private Slot extractSlotFromResultSet(ResultSet resultSet) throws SQLException {
	        Slot slot = new Slot();
	        slot.setSlotId(resultSet.getInt("ID"));
	        slot.setGymId(resultSet.getInt("gymId"));
	        slot.setStartTime(resultSet.getTime("startTime").toLocalTime());
	        slot.setSlotTime(resultSet.getInt("slotTime"));
	        slot.setTotalSeats(resultSet.getInt("totalSeats"));
	        slot.setActive(resultSet.getBoolean("active"));
	        slot.setApproved(resultSet.getBoolean("approved"));
	        return slot;
	    }

		@Override
		public int getAvailableSeats(int slotId) {
			int availableSeats = 0;
			 Connection connection = DBUtils.getConnection();
		        if (connection != null) {
		            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.AVAILABLE_SEATS)) {
		                
		                preparedStatement.setInt(1, slotId);
		                preparedStatement.setInt(2, slotId);
		                ResultSet resultSet = preparedStatement.executeQuery();
		                while (resultSet.next()) {
		                    availableSeats = resultSet.getInt("Available");
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
		        return availableSeats;
		}

}
