package com.company.customerservice.dao;

import com.company.customerservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CustomerDaoJdbcTemplateImplTest {

    @Autowired
    CustomerDao custDao;

    @BeforeEach
    void setUp() {

        List<Customer> customerList = custDao.getAllCustomers();
        for(Customer cust: customerList){
            custDao.deleteCustomer(cust.getCustomerId());
        }
    }

    @Test
    void addCustomer() {
        //arranging the customer and setting it
        Customer customer = new Customer();
        customer.setFirstName("Akshay");
        customer.setLastName("Choudhary");
        customer.setCity("Atlanta");
        customer.setEmail("test@gmail.com");
        customer.setPhone("404-999-9999");
        customer.setStreet("testStreet");
        customer.setZip("30393");
        //creating customer2
        Customer customer2 = new Customer();
        //setting customer 2 to customer so now they are the same
        customer2 = customer;
        //sending customer to the database and seeing if it gets back with an id
        customer = custDao.addCustomer(customer);
        //now we need to compare the two but before that we have to make sure customer and customer2 are the same
        //so we set customer2 id to customer
        customer2.setCustomerId(customer.getCustomerId());
        //then we assertequal both of them to see if they are equal
        assertEquals(customer2, customer);

    }

    @Test
    void getCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Akshay");
        customer.setLastName("Choudhary");
        customer.setCity("Atlanta");
        customer.setEmail("test@gmail.com");
        customer.setPhone("404-999-9999");
        customer.setStreet("testStreet");
        customer.setZip("30393");
        customer = custDao.addCustomer(customer);

        Customer customer1 = custDao.getCustomer(customer.getCustomerId());

        assertEquals(customer1, customer);


    }

    @Test
    void getAllCustomers() {
        Customer customer = new Customer();
        customer.setFirstName("Akshay");
        customer.setLastName("Choudhary");
        customer.setCity("Atlanta");
        customer.setEmail("test@gmail.com");
        customer.setPhone("404-999-9999");
        customer.setStreet("testStreet");
        customer.setZip("30393");
        customer = custDao.addCustomer(customer);

        Customer customer1 = new Customer();
        customer1.setFirstName("Remy");
        customer1.setLastName("bridgeman");
        customer1.setCity("snellville");
        customer1.setEmail("testtest@gmail.com");
        customer1.setPhone("4049993323");
        customer1.setStreet("fjkdls");
        customer1.setZip("330000");
        customer1 = custDao.addCustomer(customer1);

        List<Customer> customersList = custDao.getAllCustomers();
        assertEquals(2, customersList.size());

    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Akshay");
        customer.setLastName("Choudhary");
        customer.setCity("Atlanta");
        customer.setEmail("test@gmail.com");
        customer.setPhone("404-999-9999");
        customer.setStreet("testStreet");
        customer.setZip("30393");
        customer = custDao.addCustomer(customer);

        customer.setCity("Orange");

        custDao.updateCustomer(customer);
        Customer updatedCustomer = custDao.getCustomer(customer.getCustomerId());
        assertEquals(updatedCustomer, customer);

    }

    @Test
    void deleteCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Akshay");
        customer.setLastName("Choudhary");
        customer.setCity("Atlanta");
        customer.setEmail("test@gmail.com");
        customer.setPhone("404-999-9999");
        customer.setStreet("testStreet");
        customer.setZip("30393");
        customer = custDao.addCustomer(customer);

       custDao.deleteCustomer(customer.getCustomerId());
       Customer retrievedCustomer = custDao.getCustomer(customer.getCustomerId());
       assertNull(retrievedCustomer);

    }
}