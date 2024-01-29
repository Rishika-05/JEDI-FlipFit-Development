/**
 * This interface represents the Data Access Object (DAO) for GymOwner entities.
 * It provides methods to interact with the database and perform CRUD operations on GymOwner objects.
 */
package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.List;

/**
 * This interface defines the contract for the GymOwnerDAO implementation.
 * It specifies the methods that need to be implemented to interact with the database.
 */
public interface GymOwnerDAO {
    
    /**
     * Retrieves a GymOwner object from the database based on the given gymOwnerId.
     *
     * @param gymOwnerId The ID of the GymOwner to retrieve.
     * @return The GymOwner object corresponding to the given ID, or null if not found.
     */
    GymOwner getGymOwnerById(int gymOwnerId);
    
    /**
     * Updates the profile of a GymOwner in the database.
     *
     * @param owner The updated GymOwner object.
     * @return The updated GymOwner object.
     */
    GymOwner updateProfile(GymOwner owner);
    
    /**
     * Retrieves a list of all GymOwner objects from the database.
     *
     * @return A list of all GymOwner objects.
     */
    List<GymOwner> getAllOwners();
    
    /**
     * Registers a new GymOwner in the database.
     *
     * @param owner The GymOwner object to register.
     * @return true if the registration is successful, false otherwise.
     */
    public boolean register(GymOwner owner);
    
    /**
     * Approves a GymOwner by their ID.
     *
     * @param gymOwnerId The ID of the GymOwner to approve.
     */
    void approveGymOwnerById(int gymOwnerId);
    
    /**
     * Retrieves the GymOwner ID associated with the given User ID.
     *
     * @param userId The ID of the User.
     * @return The GymOwner ID associated with the given User ID, or -1 if not found.
     */
    int getGymOwnerIdByUserId(int userId);
}
