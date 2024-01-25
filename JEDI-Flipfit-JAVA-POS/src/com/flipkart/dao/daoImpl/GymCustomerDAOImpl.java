package com.flipkart.dao.daoImpl;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.GymCustomerDAO;

public class GymCustomerDAOImpl implements GymCustomerDAO {

    private static GymCustomerDAO customerDaoObj = null;

    public static synchronized GymCustomerDAO getInstance() {
        if (customerDaoObj == null)
            customerDaoObj = new GymCustomerDAOImpl();

        return customerDaoObj;
    }

    @Override
    public GymCustomer viewProfile(String username, String password) {

        return null;
    }

    @Override
    public boolean register(GymCustomer customer) {

        return false;
    }
    @Override
    public int insert(GymCustomer customer) {
    	return 0;
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(String id, GymCustomer newCustomer) {
        // TODO Auto-generated method stub

    }

}
