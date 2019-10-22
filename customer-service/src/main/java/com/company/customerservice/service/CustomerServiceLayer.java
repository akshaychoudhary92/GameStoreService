package com.company.customerservice.service;

import com.company.customerservice.dao.CustomerDao;
import com.company.customerservice.model.Customer;
import com.company.customerservice.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceLayer {
    //customer api

    @Autowired
    CustomerDao customerDao;

    public CustomerViewModel addCustomer(CustomerViewModel custVm){
        return null;
    }

    public CustomerViewModel getCustomer(int customerId){
        return null;
    }

    public List<CustomerViewModel> getAllCustomers(){
        return null;
    }

    public void updateCustomer(CustomerViewModel customer){

    }

    public void deleteCustomer(int customerId){

    }


    public CustomerViewModel buildCVM(Customer customer){
        CustomerViewModel cvm = new CustomerViewModel();
        cvm.setCustomerId(customer.getCustomerId());
        cvm.setCity(customer.getCity());
        cvm.setEmail(customer.getEmail());
        cvm.setFirstName(customer.getFirstName());
        cvm.setLastName(customer.getLastName());
        cvm.setPhone(customer.getPhone());
        cvm.setStreet(customer.getStreet());
        cvm.setZip(customer.getZip());
        return cvm;
    }


}
