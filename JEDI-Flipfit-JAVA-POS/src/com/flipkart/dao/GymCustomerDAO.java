/**
 * This interface represents the Data Access Object (DAO) for GymCustomer entities.
 * It provides methods to interact with the database and perform CRUD operations on GymCustomer objects.
 */
package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.GymCustomer;

/**
 * This interface defines the contract for GymCustomerDAO implementations.
 */
public interface GymCustomerDAO {

    /**
     * Retrieves the profile of a GymCustomer based on the provided gymCustomerId.
     * @param gymCustomerId The ID of the GymCustomer
     * @return The GymCustomer object representing the profile
     */
    public GymCustomer viewProfile(int gymCustomerId);

    /**
     * Registers a new GymCustomer.
     * @param customer The GymCustomer object to be registered
     * @return true if the customer was successfully registered, false otherwise
     */
    public boolean register(GymCustomer customer);

    /**
     * Deletes a GymCustomer based on the provided gymCustomerId.
     * @param gymCustomerId The ID of the GymCustomer to be deleted
     */
    public void delete(int gymCustomerId);

    /**
     * Updates the details of a GymCustomer.
     * @param gymCustomerId The ID of the GymCustomer to be updated
     * @param newCustomer The updated GymCustomer object
     * @return true if the customer was successfully updated, false otherwise
     */
    public boolean update(int gymCustomerId, GymCustomer newCustomer);
    
    /**
     * Retrieves all GymCustomers from the database.
     * @return An ArrayList containing all GymCustomer objects
     */
    public ArrayList<GymCustomer> getAllGymCustomers();
    
    /**
     * Retrieves the gymCustomerId associated with the provided userId.
     * @param userId The ID of the user
     * @return The gymCustomerId associated with the user
     */
    public int getGymCustomerIdFromUserId(int userId);

}
