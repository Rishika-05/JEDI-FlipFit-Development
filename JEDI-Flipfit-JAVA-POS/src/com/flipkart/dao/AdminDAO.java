/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymOwner;

import java.util.ArrayList;

/**
 * 
 */
public interface AdminDAO {

    public boolean approveGymOwner();

    /**
     * Fetch all pending gym owners registrations
     * @return List of pending gymowners
     */

    public ArrayList<GymOwner> getPendingGymOwnerApprovals();

    /**
     * Approve a gym registration request
     * @return boolean whether approved or not
     */
    public boolean approveGymRegistrationRequest();

    /**
     * Fetch all pending gym location registrations
     *
     */

    public void getPendingGymLocationRegistrationRequests();

    /**
     * Fetch all approved gym owners
     */
    public void viewAllGymOwners();

}
