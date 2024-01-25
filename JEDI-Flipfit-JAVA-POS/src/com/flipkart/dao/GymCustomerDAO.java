/**
 * 
 */
package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.GymCustomer;

/**
 * 
 */
public interface GymCustomerDAO {

   
    public GymCustomer viewProfile(int gymCustomerId);

    /**
     * Register the customer
     * @param customer
     * @return boolean value whether the customer was registered or not
     */

    public boolean register(GymCustomer customer);

    /**
     * Delete a customer
     * @param id
     */

    public void delete(int gymCustomerId);


    /**
     * update a customer
     * @param id
     * @param newCustomer
     */

    public boolean update(int gymCustomerId, GymCustomer newCustomer);
    
    public ArrayList<GymCustomer> getAllGymCustomers();

}
