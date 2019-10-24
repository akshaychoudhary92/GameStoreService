package com.company.customerservice.service;

import com.company.customerservice.dao.CustomerDao;
import com.company.customerservice.model.Customer;
import com.company.customerservice.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerServiceLayer {

    @Autowired
    public CustomerServiceLayer(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    //customer api


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
        Customer customer = customerDao.getCustomer(customerId);

        CustomerViewModel cvm = new CustomerViewModel();
        cvm.setCustomerId(customer.getCustomerId());
        cvm.setZip(customer.getZip());
        cvm.setStreet(customer.getStreet());
        cvm.setPhone(customer.getPhone());
        cvm.setLastName(customer.getLastName());
        cvm.setFirstName(customer.getFirstName());
        cvm.setEmail(customer.getEmail());
        cvm.setCity(customer.getCity());

        return cvm;


    }

    public List<CustomerViewModel> getAllCustomers(){
        List<Customer> customer = customerDao.getAllCustomers();

        List<CustomerViewModel> customerCvm = new ArrayList<>();

        System.out.println(customer.toString());


        for(int i = 0; i < customer.size(); i++){
            CustomerViewModel cvm = new CustomerViewModel();
            System.out.println(customer.get(i).getFirstName());
            cvm.setCustomerId(customer.get(i).getCustomerId());
            cvm.setCity(customer.get(i).getCity());
            cvm.setEmail(customer.get(i).getEmail());
            cvm.setFirstName(customer.get(i).getFirstName());
            cvm.setLastName(customer.get(i).getLastName());
            cvm.setPhone(customer.get(i).getPhone());
            cvm.setStreet(customer.get(i).getStreet());
            cvm.setZip(customer.get(i).getZip());
            //System.out.println(customer.get(i).getClass());
            customerCvm.add(cvm);
        }

        return customerCvm;
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
