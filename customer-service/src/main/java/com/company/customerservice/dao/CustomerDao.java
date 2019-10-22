package com.company.customerservice.dao;

import com.company.customerservice.model.Customer;

import java.util.List;
/**
 * creating a customerdao interface
 */
public interface CustomerDao {

    /**
     * a method that creates a customer and adds it.
     * @param customer
     * @return customer
     */
    public Customer addCustomer(Customer customer);

    /**
     * a method that gets a customer by its id
     * @param customerId
     * @return cutomer
     */
    public Customer getCustomer(int customerId);

    /**
     * a method that gives you a list of all the customers
     * @return
     */
    public List<Customer> getAllCustomers();

    /**
     * a method that updates the customer
     * @param customer
     */
    public void updateCustomer(Customer customer);

    /**
     * a method that deletes the customer using the id provided
     * @param customerId
     */
    public void deleteCustomer(int customerId);
}
