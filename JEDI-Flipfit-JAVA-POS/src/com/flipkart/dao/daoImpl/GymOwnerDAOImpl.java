/**
 * Implementation of the GymOwnerDAO interface.
 */
package com.flipkart.dao.daoImpl;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.GymOwnerDAO;
import com.flipkart.service.GymFlipFitService.*;

import java.util.ArrayList;
import java.util.List;

public class GymOwnerDAOImpl implements GymOwnerDAO {

    ArrayList<GymOwner> gymOwners = new ArrayList<GymOwner>();
    private static GymOwnerDAOImpl gymOwnerDaoObj = null;

    private GymOwnerDAOImpl() {
        // Initialize the gyms list or perform any necessary setup
        ArrayList<Gym> gyms = new ArrayList<>();
    }

    public static synchronized GymOwnerDAOImpl getInstance() {
        if (gymOwnerDaoObj == null)
            gymOwnerDaoObj = new GymOwnerDAOImpl();

        return gymOwnerDaoObj;
    }


    @Override
    public GymOwner viewProfile(User user) {
        // Add logic to retrieve and return the profile details of the GymOwner based on the User object
        for (GymOwner owner : gymOwners) {
            if (owner.getUsername().equals(user.getUsername())) {
                return owner;
            }
        }
        return null;
    }

    @Override
    public GymOwner updateProfile(GymOwner owner) {
        // Add logic to update the profile details of the GymOwner based on the GymOwner object
        for (GymOwner o : gymOwners) {
            if (o.getUsername().equals(owner.getUsername())) {
                o = owner;
                return o;
            }
        }
        return null;
    }
}
