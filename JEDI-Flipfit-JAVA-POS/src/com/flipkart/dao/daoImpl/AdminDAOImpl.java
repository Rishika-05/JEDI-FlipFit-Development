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


   

}
