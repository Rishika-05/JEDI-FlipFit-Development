package com.flipkart.dao.daoImpl;

import java.util.ArrayList;

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
    
    private ArrayList<GymCustomer> gymCustomers = new ArrayList<GymCustomer>();

    @Override
    public GymCustomer viewProfile(int gymCustomerId) {

        if(gymCustomerId >= gymCustomers.size())
        return null;
        
        return gymCustomers.get(gymCustomerId);
    }

    @Override
    public boolean register(GymCustomer customer) {
    	customer.setCustomerId(gymCustomers.size());
        return true;
    }
    

    @Override
    public boolean update(int gymCustomerId, GymCustomer newCustomer) {
    	if(gymCustomerId >= gymCustomers.size())
            return false;
    	
    	gymCustomers.set(gymCustomerId, newCustomer);
    	return true;

    }

	@Override
	public void delete(int gymCustomerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<GymCustomer> getAllGymCustomers() {
		return gymCustomers;
	}

}
