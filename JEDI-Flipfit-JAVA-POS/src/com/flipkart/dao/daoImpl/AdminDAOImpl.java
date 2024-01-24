/**
 * 
 */
package com.flipkart.dao.daoImpl;

import com.flipkart.bean.GymOwner;
import com.flipkart.dao.AdminDAO;

import java.util.ArrayList;

/**
 * 
 */
public class AdminDAOImpl implements AdminDAO {

    private static AdminDAOImpl adminDaoObj = null;

    private AdminDAOImpl() {
    }

    public static synchronized AdminDAOImpl getInstance() {
        if (adminDaoObj == null)
            adminDaoObj = new AdminDAOImpl();

        return adminDaoObj;
    }


    @Override
    public boolean approveGymOwner() {
        // TODO Auto-generated method stub

        return false;
    }

    @Override
    public ArrayList<GymOwner> getPendingGymOwnerApprovals() {
        return null;

    }

    @Override
    public boolean approveGymRegistrationRequest() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void getPendingGymLocationRegistrationRequests() {
        // TODO Auto-generated method stub

    }

    public void viewAllGymOwners() {

    }

}
