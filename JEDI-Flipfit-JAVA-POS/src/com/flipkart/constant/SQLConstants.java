package com.flipkart.constant;


public class SQLConstants {
	
	// User
	public static final String TABLE_USER = "USER";
	public static final String INSERT_USER = "INSERT INTO " + TABLE_USER + " (username, password, role) "
			+ " VALUES (?, ?, ?)";	
	public static final String SELECT_USER = "SELECT * FROM " + TABLE_USER;	
	public static final String WHERE_USERNAME = " WHERE username = ";
	public static final String UPDATE_USER_PASSWORD = "UPDATE " + TABLE_USER + " SET password = ? WHERE ID = ?";


	// Customer
	public static final String INSERT_GYM_CUSTOMER = "INSERT INTO gym_customers (name, location, userId, age) VALUES (?, ?, ?, ?)";
    public static final String SELECT_GYM_CUSTOMER = "SELECT * FROM gym_customers ";
    public static final String WHERE_GYM_CUSTOMER_ID = "WHERE ID = ?";
    public static final String UPDATE_GYM_CUSTOMER = "UPDATE gym_customers SET name = ?, location = ?, age = ? WHERE ID = ?";
    public static final String DELETE_GYM_CUSTOMER = "DELETE FROM gym_customers WHERE ID = ?";
    public static final String SELECT_ALL_GYM_CUSTOMERS = "SELECT * FROM gym_customers";
    public static final String SELECT_GYM_CUSTOMER_ID_FROM_USER_ID = "SELECT ID FROM gym_customers WHERE userId = ?";
	
	// GymOwner
    public static final String UPDATE_PROFILE = "UPDATE GymOwner SET name=?, age=?, panCard=?, aadharCard=?, gstin=?, location=? WHERE ID=?";
    public static final String SELECT_OWNER_BY_ID = "SELECT * FROM GymOwner WHERE ID=?";
    public static final String SELECT_ALL_OWNERS = "SELECT * FROM GymOwner";
    public static final String SELECT_OWNER_BY_USER_ID = "SELECT * FROM GymOwner WHERE ID=?";
    public static final String INSERT_OWNER = "INSERT INTO GymOwner (name, age, panCard, aadharCard, gstin, location, approved, userId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String APPROVE_GYM_OWNER = "UPDATE GymOwner SET approved = ? WHERE ID = ?";
	// Gym
    public static final String INSERT_GYM = "INSERT INTO gym (totalSlots, approved, active, location, gymName, gymDescription, gymOwnerId, pricePerSlot) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String SELECT_ALL_GYMS = "SELECT * FROM gym;";
    public static final String SELECT_GYM_BY_ID = "SELECT * FROM gym WHERE ID = ?;";
    public static final String SELECT_ALL_GYMS_BY_OWNER_ID = "SELECT * FROM gym WHERE gymOwnerId = ?;";
    public static final String SELECT_ALL_GYMS_BY_LOCATION = "SELECT * FROM gym WHERE location = ?;";
    public static final String SELECT_PENDING_GYMS = "SELECT * FROM gym WHERE approved = false;";

    public static final String UPDATE_GYM = "UPDATE gym SET totalSlots = ?, approved = ?, active = ?, location = ?, gymName = ?, gymDescription = ?, gymOwnerId = ?, pricePerSlot = ? WHERE ID = ?;";
    public static final String DELETE_GYM = "UPDATE Gym SET active = false,  WHERE ID = ?;";

    public static final String APPROVE_GYM_BY_ID = "UPDATE Gym SET approved = true, active = true WHERE ID = ?;";
    public static final String SELECT_ALL_ACTIVE_GYMS = "SELECT * FROM Gym WHERE approved = true AND active = true;";

	// Slot
	public static final String TABLE_TIMESLOT = "TIMESLOT";

	public static final String INSERT_TIMESLOT = "INSERT INTO " + TABLE_TIMESLOT + " (SLOTHOUR, GYMID, AVAILABLESEATS, DAY) "
			+ " VALUES (?, ?, ?, ?)";

	public static final String FIND_TIMESLOT = "SELECT * FROM " + TABLE_TIMESLOT
			+ " WHERE SLOTHOUR = (?) AND GYMID = (?)";

	public static final String UPDATE_TIMESLOT_AVAILABILITY = "UPDATE " + TABLE_TIMESLOT
			+ " SET AVAILABLESEATS = AVAILABLESEATS + (?) WHERE SLOTHOUR = (?) AND GYMID = (?)";

	public static final String GET_AVAILABLE_TIMESLOT = "SELECT * FROM " + TABLE_TIMESLOT + " WHERE availableSeats > 0";
	
	public static final String GET_SLOT_BY_ID = "SELECT * FROM " + TABLE_TIMESLOT + " WHERE SLOTID = ?";
	
	// Notification
	public static final String TABLE_NOTIFICATION = "NOTIFICATION";
	public static final String INSERT_NOTIFICATION = "INSERT INTO " + TABLE_NOTIFICATION + " (userid, usertype, content, isViewed) "
			+ " VALUES (?, ?, ?, ?)";	
	public static final String SELECT_NOTIFICATION = "SELECT * FROM " + TABLE_NOTIFICATION;	

	public static final String UPDATE_NOTIFICATION = "UPDATE " + TABLE_NOTIFICATION + " SET ISVIEWED = 1";
	public static final String DELETE_NOTIFICATION = "DELETE FROM " + TABLE_NOTIFICATION;
	public static final String WHERE_NOT_VIEWED_NOTIFICATION = " WHERE USERID=(?) AND USERTYPE=(?) AND ISVIEWED=0";
	
	public static final String WHERE__NOT_VIEWED_NOTIFICATION = " WHERE USERID=(?) AND USERTYPE=(?) AND ISVIEWED=0";
	
	//Booking
	public static final String TABLE_BOOKING = "Booking";
	public static final String INSERT_BOOKING = "INSERT INTO " + TABLE_BOOKING
	+ " (slotID, customerID) " + " VALUES (?, ?)";
	public static final String DELETE_BOOKING = "DELETE FROM " + TABLE_BOOKING + " WHERE slotID = ? AND customerID = ?";
	public static final String SELECT_BOOKING = "SELECT * FROM " + TABLE_BOOKING + " WHERE customerID = ?";

	// common WHERE clauses
	public static final String WHERE_ID = " WHERE ID=(?)";
	public static final String WHERE_PENDING_APPROVAL_FALSE = " WHERE ISAPPROVED = FALSE";
	public static final String WHERE_APPROVAL_TRUE = " WHERE ISAPPROVED = TRUE";
	

}