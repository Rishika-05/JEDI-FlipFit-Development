/**
 * Data Access Object (DAO) interface for GymOwner operations.
 */
package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.List;

public interface GymOwnerDAO {

    /**
     * Adds a new gym to the database.
     *
     * @param gym The Gym object containing gym details.
     */
    void addGym(Gym gym);

    /**
     * Retrieves all gyms associated with a specific GymOwner.
     *
     * @param userId The user ID of the GymOwner.
     * @return List of Gym objects associated with the GymOwner.
     */
    List<Gym> getAllGyms(int userId);

    /**
     * Removes a gym based on its gym ID.
     *
     * @param gymId The ID of the gym to be removed.
     * @return True if the gym is successfully removed, false otherwise.
     */
    boolean removeGym(int gymId);

    /**
     * Modifies gym details based on its gym ID.
     *
     * @param gymId The ID of the gym to be modified.
     * @return True if the gym is successfully modified, false otherwise.
     */
    boolean modifyGym(int gymId);

    /**
     * Adds a new slot for the specified gym.
     *
     * @param gym The Gym object for which the slot needs to be added.
     */
    void addSlot(Gym gym);

    /**
     * Modifies an existing slot for the specified gym.
     *
     * @param gymId The ID of the gym for which the slot needs to be modified.
     */
    void modifySlot(int gymId);

    /**
     * Retrieves the list of slots for a specific gym.
     *
     * @param gymId The ID of the gym for which slots need to be retrieved.
     * @return List of strings representing slots for the specified gym.
     */
    List<String> viewSlots(int gymId);

    /**
     * Removes a slot for the specified gym.
     *
     * @param gymId The ID of the gym for which the slot needs to be removed.
     */
    void removeSlot(int gymId);

    /**
     * Retrieves the profile details of the GymOwner.
     *
     * @param user The User object representing the GymOwner.
     * @return The GymOwner object containing profile details.
     */
    GymOwner viewProfile(User user);

    /**
     * Updates the profile details of the GymOwner.
     *
     * @param owner The GymOwner object containing updated profile details.
     * @return The GymOwner object after the update.
     */
    GymOwner updateProfile(GymOwner owner);
}
