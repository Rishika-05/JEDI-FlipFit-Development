/**
 * 
 */
package com.flipkart.dao.daoImpl;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.GymOwnerDAO;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 */
public class GymOwnerDAOImpl implements GymOwnerDAO {
    ArrayList<GymOwner> gymOwners = new ArrayList<GymOwner>();
    private static GymOwnerDAO gymOwnerDaoObj = null;

    private GymOwnerDAOImpl() {
    }

    public static synchronized GymOwnerDAO getInstance() {
        if (gymOwnerDaoObj == null)
            gymOwnerDaoObj = new GymOwnerDAOImpl();

        return gymOwnerDaoObj;
    }
    @Override
    public void addGym(Gym gmy) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Gym> getAllGyms(int userId) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void addTimeSlot(Gym gym) {
        //logic to add time slot
        return;
    }



    @Override
    public GymOwner updateProfile(GymOwner gymOwner) {
        //get details and update accordingly

        return gymOwner;
    }

	@Override
	public GymOwner getGymOwnerById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GymOwner> getAllOwners() {
		return gymOwners;
	}
}
