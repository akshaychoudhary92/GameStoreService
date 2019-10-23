package com.company.customerservice.service;

import com.company.customerservice.dao.CustomerDao;
import com.company.customerservice.model.Customer;
import com.company.customerservice.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServiceLayer {
    //customer api

    @Autowired
    CustomerDao customerDao;

    public CustomerViewModel addCustomer(CustomerViewModel custVm){
        Customer customer = new Customer();
        customer.setFirstName(custVm.getFirstName());
        customer.setLastName(custVm.getLastName());
        customer.setCity(custVm.getCity());
        customer.setZip(custVm.getZip());
        customer.setStreet(custVm.getStreet());
        customer.setPhone(custVm.getPhone());
        customer.setEmail(custVm.getEmail());

        Customer savedCustomer = customerDao.addCustomer(customer);

        CustomerViewModel savedCustVm = buildCVM(savedCustomer);
        return savedCustVm;

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
