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
    public static final String UPDATE_PROFILE = "UPDATE GymOwner SET name=?, age=?, panCard=?, aadharCard=?, gstin=?, location=?, approved=? WHERE ID=?";
    public static final String SELECT_OWNER_BY_ID = "SELECT * FROM GymOwner WHERE ID=?";
    public static final String SELECT_ALL_OWNERS = "SELECT * FROM GymOwner";
    public static final String SELECT_OWNER_BY_USER_ID = "SELECT * FROM GymOwner WHERE ID=?";
    public static final String INSERT_OWNER = "INSERT INTO GymOwner (name, age, panCard, aadharCard, gstin, location, approved, userId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String APPROVE_GYM_OWNER = "UPDATE GymOwner SET approved = ? WHERE ID = ?";
    public static final String SELECT_GYM_OWNER_ID_FROM_USER_ID = "SELECT ID FROM GymOwner WHERE userId = ?";
	// Gym
    public static final String INSERT_GYM = "INSERT INTO gym (totalSlots, approved, active, location, gymName, gymDescription, gymOwnerId, pricePerSlot) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String SELECT_ALL_GYMS = "SELECT * FROM gym;";
    public static final String SELECT_GYM_BY_ID = "SELECT * FROM gym WHERE ID = ?;";
    public static final String SELECT_ALL_GYMS_BY_OWNER_ID = "SELECT * FROM gym WHERE gymOwnerId = ?;";
    public static final String SELECT_ALL_GYMS_BY_LOCATION = "SELECT * FROM gym WHERE location = ? AND approved = true AND active = true ;";
    public static final String SELECT_PENDING_GYMS = "SELECT * FROM gym WHERE approved = false;";

    public static final String UPDATE_GYM = "UPDATE gym SET totalSlots = ?, approved = ?, active = ?, location = ?, gymName = ?, gymDescription = ?, gymOwnerId = ?, pricePerSlot = ? WHERE ID = ?;";
    public static final String DELETE_GYM = "UPDATE Gym SET active = false  WHERE ID = ?;";

    public static final String APPROVE_GYM_BY_ID = "UPDATE Gym SET approved = true, active = true WHERE ID = ?;";
    public static final String SELECT_ALL_ACTIVE_GYMS = "SELECT * FROM Gym WHERE approved = true AND active = true;";

	// Slot
    public static final String INSERT_SLOT = "INSERT INTO Slot (gymId, startTime, slotTime, totalSeats, active, approved) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String DELETE_SLOT = "UPDATE Slot SET active = ? WHERE ID = ?";
    public static final String APPROVE_SLOT = "UPDATE Slot SET approved = ? WHERE ID = ?";
    public static final String SELECT_SLOT = "SELECT * FROM Slot WHERE ID = ?";
    public static final String SELECT_ALL_SLOTS = "SELECT * FROM Slot";
    public static final String SELECT_SLOTS_BY_GYM = "SELECT * FROM Slot WHERE gymId = ?";
    public static final String UPDATE_SLOT = "UPDATE Slot SET gymId = ?, startTime = ?, slotTime = ?, totalSeats = ?, active = ?, approved = ? WHERE ID = ?";
    public static final String AVAILABLE_SEATS = "SELECT (SELECT s.totalSeats FROM Slot AS s WHERE s.Id = ?) - (SELECT count(b.slotId) FROM Booking AS b WHERE b.slotId = ? AND b.isCancelled = FALSE) AS Available;";


	//Booking
	  public static final String INSERT_BOOKING = "INSERT INTO Booking (userId, gymId, slotId, isCancelled) VALUES (?, ?, ?, false)";
	    public static final String CANCEL_BOOKING = "UPDATE Booking SET isCancelled = true WHERE ID = ?";
	    public static final String SELECT_BOOKING_BY_ID = "SELECT * FROM Booking WHERE ID = ?";
	    public static final String SELECT_BOOKINGS_BY_USER_ID = "SELECT * FROM Booking WHERE userId = ?";
	    public static final String SELECT_BOOKINGS_BY_GYM_ID = "SELECT * FROM Booking WHERE gymId = ?";
	    public static final String SELECT_BOOKINGS_BY_SLOT_ID = "SELECT * FROM Booking WHERE slotId = ?";
	    public static final String SELECT_ALL_BOOKINGS = "SELECT * FROM Booking";
	    public static final String REMOVE_BOOKING_OF_INACTIVE_GYM = "DELETE FROM Booking WHERE gymId NOT IN (SELECT ID FROM Gym WHERE active = true)";
		
	    // Notification
		public static final String TABLE_NOTIFICATION = "NOTIFICATION";
		public static final String INSERT_NOTIFICATION = "INSERT INTO " + TABLE_NOTIFICATION + " (userid, usertype, content, isViewed) "
				+ " VALUES (?, ?, ?, ?)";	
		public static final String SELECT_NOTIFICATION = "SELECT * FROM " + TABLE_NOTIFICATION;	

		public static final String UPDATE_NOTIFICATION = "UPDATE " + TABLE_NOTIFICATION + " SET ISVIEWED = 1";
		public static final String DELETE_NOTIFICATION = "DELETE FROM " + TABLE_NOTIFICATION;
		public static final String WHERE_NOT_VIEWED_NOTIFICATION = " WHERE USERID=(?) AND USERTYPE=(?) AND ISVIEWED=0";
		
		public static final String WHERE__NOT_VIEWED_NOTIFICATION = " WHERE USERID=(?) AND USERTYPE=(?) AND ISVIEWED=0";
		
	// common WHERE clauses
	public static final String WHERE_ID = " WHERE ID=(?)";
	public static final String WHERE_PENDING_APPROVAL_FALSE = " WHERE ISAPPROVED = FALSE";
	public static final String WHERE_APPROVAL_TRUE = " WHERE ISAPPROVED = TRUE";
	

}