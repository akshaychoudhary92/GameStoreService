package com.company.customerservice.service;

import com.company.customerservice.dao.CustomerDao;
import com.company.customerservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceLayer {
    //customer api

    @Autowired
    CustomerDao customerDao;

    public Customer addCustomer(Customer customer){
        return null;
    }

    public Customer getCustomer(int customerId){
        return null;
    }

    public List<Customer> getAllCustomers(){
        return null;
    }

    public void updateCustomer(Customer customer){

    }

    public void deleteCustomer(int customerId){

    }
}
