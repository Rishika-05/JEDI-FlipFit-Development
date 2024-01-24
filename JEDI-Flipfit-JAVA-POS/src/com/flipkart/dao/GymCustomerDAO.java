/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymCustomer;

/**
 * 
 */
public interface GymCustomerDAO {

    public int insert(GymCustomer customer);

    /**
     * Fetch the customer profile information from the database
     * @param username
     * @param password
     * @return customer fetched from the database
     */

    public GymCustomer viewProfile(String username, String password);

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

    public void delete(String id);


    /**
     * update a customer
     * @param id
     * @param newCustomer
     */

    public void update(String id, GymCustomer newCustomer);

}
