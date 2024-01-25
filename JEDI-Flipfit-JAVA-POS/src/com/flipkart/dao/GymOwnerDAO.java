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
