//package com.company.customerservice.controller;
//
//import com.company.customerservice.service.CustomerServiceLayer;
//import com.company.customerservice.viewmodel.CustomerViewModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/customer")
//public class CustomerController {
//
//    @Autowired
//    CustomerServiceLayer service;
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public CustomerViewModel addCustomer(@RequestBody @Valid CustomerViewModel custVm){
//        return null;
//    }
//
//    @GetMapping("/getById/{customerId}")
//    @ResponseStatus(HttpStatus.OK)
//    public CustomerViewModel getCustomer(@PathVariable @Valid int customerId){
//        return null;
//    }
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<CustomerViewModel> getAll(){
//        return null;
//    }
//
//    @PutMapping
//    @ResponseStatus(HttpStatus.OK)
//    public void updateCustomer(@RequestBody CustomerViewModel custVm){
//
//    }
//
//    @DeleteMapping("/{customerId}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteCustomer(@PathVariable int customerId){
//
//    }
//
//
//
//
//
//
//
//}
