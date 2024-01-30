/**
 * The AdminDAO interface provides methods to interact with the database for administrative tasks related to gym owners and gym registrations.
 */
package com.flipkart.dao;

import com.flipkart.bean.GymOwner;

import java.util.ArrayList;

/**
 * The AdminDAO interface defines methods for administrative tasks related to gym owners and gym registrations.
 */
public interface AdminDAO {

    /**
     * Approves a gym owner's registration.
     * @return true if the registration is approved, false otherwise
     */
    public boolean approveGymOwner();

    /**
     * Fetches all pending gym owner approvals.
     * @return a list of pending gym owners
     */
    public ArrayList<GymOwner> getPendingGymOwnerApprovals();

    /**
     * Approves a gym registration request.
     * @return true if the request is approved, false otherwise
     */
    public boolean approveGymRegistrationRequest();

    /**
     * Fetches all pending gym location registration requests.
     */
    public void getPendingGymLocationRegistrationRequests();

    /**
     * Fetches all approved gym owners.
     */
    public void viewAllGymOwners();

}
