package com.company.customerservice.service;

import com.company.customerservice.dao.CustomerDao;
import com.company.customerservice.model.Customer;
import com.company.customerservice.viewmodel.CustomerViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class CustomerServiceLayerTest {

    @InjectMocks
    CustomerServiceLayer service;

    @Mock
    CustomerDao customerDao;

    Customer inputCustomer;
    Customer outputCustomer;
    CustomerViewModel inputCvm;
    CustomerViewModel outputCvm;


    @BeforeEach
    void setUp() {
        inputCustomer = new Customer();
        inputCustomer.setFirstName("Akshay");
        inputCustomer.setLastName("Choudhary");
        inputCustomer.setCity("Atlanta");
        inputCustomer.setEmail("test@gmail.com");
        inputCustomer.setPhone("404-999-9999");
        inputCustomer.setStreet("testStreet");
        inputCustomer.setZip("30393");


        outputCustomer = new Customer();
        outputCustomer.setFirstName("Akshay");
        outputCustomer.setLastName("Choudhary");
        outputCustomer.setCity("Atlanta");
        outputCustomer.setEmail("test@gmail.com");
        outputCustomer.setPhone("404-999-9999");
        outputCustomer.setStreet("testStreet");
        outputCustomer.setZip("30393");
        outputCustomer.setCustomerId(1);

        inputCvm = new CustomerViewModel();
        inputCvm.setFirstName("Akshay");
        inputCvm.setLastName("Choudhary");
        inputCvm.setCity("Atlanta");
        inputCvm.setEmail("test@gmail.com");
        inputCvm.setPhone("404-999-9999");
        inputCvm.setStreet("testStreet");
        inputCvm.setZip("30393");

        outputCvm = new CustomerViewModel();
        outputCvm.setFirstName("Akshay");
        outputCvm.setLastName("Choudhary");
        outputCvm.setCity("Atlanta");
        outputCvm.setEmail("test@gmail.com");
        outputCvm.setPhone("404-999-9999");
        outputCvm.setStreet("testStreet");
        outputCvm.setZip("30393");
        outputCvm.setCustomerId(1);




    }

    @Test
    void test_addCustomer_validInput() {

        doReturn(outputCustomer).when(customerDao).addCustomer(inputCustomer);
        CustomerViewModel actual = service.addCustomer(inputCvm);

        assertEquals(outputCvm, actual);

    }

    @Test
    void getCustomer() {
        

    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void buildCVM() {
        Customer customer = new Customer();
        customer.setFirstName("Akshay");
        customer.setLastName("Choudhary");
        customer.setCity("Atlanta");
        customer.setEmail("test@gmail.com");
        customer.setPhone("404-999-9999");
        customer.setStreet("testStreet");
        customer.setZip("30393");
        customer.setCustomerId(1);

        CustomerViewModel expected = new CustomerViewModel();
        expected.setFirstName("Akshay");
        expected.setLastName("Choudhary");
        expected.setCity("Atlanta");
        expected.setEmail("test@gmail.com");
        expected.setPhone("404-999-9999");
        expected.setStreet("testStreet");
        expected.setZip("30393");
        expected.setCustomerId(1);

        CustomerViewModel actual = service.buildCVM(customer);
        assertEquals(expected, actual);

    }
}