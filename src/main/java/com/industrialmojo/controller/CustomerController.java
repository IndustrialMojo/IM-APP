package com.industrialmojo.controller;

import com.industrialmojo.dto.Customer;
import com.industrialmojo.mongodb.entity.CustomerEntity;
import com.industrialmojo.service.GetCustomerAllService;
import com.industrialmojo.service.GetCustomerService;
import com.industrialmojo.service.LoadCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final GetCustomerService getCustomerService;
    private final LoadCustomersService loadCustomersService;

    @Autowired
    public CustomerController(
            GetCustomerAllService getCustomerService,
            LoadCustomersService loadCustomersService) {
        this.getCustomerService = getCustomerService;
        this.loadCustomersService = loadCustomersService;
    }

    @GetMapping("/getCustomer")
    public @ResponseBody
    ResponseEntity<String> getCustomer() {
        return new ResponseEntity<String>("GET Response", HttpStatus.OK);
    }

    @GetMapping("/getCustomer/{id}")
    public @ResponseBody
    Iterable<Customer>
    getCustomerById(@PathVariable String id) {
        return getCustomerService.getCustomers();
    }

    @PostMapping("/customer/")
    public @ResponseBody
    ResponseEntity<String>
    loadCustomers() {
        loadCustomersService.loadCustomers();
        return new ResponseEntity<String>("GET Response", HttpStatus.OK);
    }

    @GetMapping("/customer/findByFirst/{firstName}")
    public @ResponseBody
    ResponseEntity<List<CustomerEntity>>
    findByFirstName(@PathVariable String firstName) {
        List<CustomerEntity> customers = loadCustomersService.findCustomerByFirstName(firstName);
        return new ResponseEntity<List<CustomerEntity>>(customers, HttpStatus.OK);
    }

    @GetMapping("/customer/findByLast/{firstName}")
    public @ResponseBody
    ResponseEntity<List<CustomerEntity>>
    findByLastName(@PathVariable String firstName) {
        List<CustomerEntity> customers = loadCustomersService.findCustomersByLastName(firstName);
        return new ResponseEntity<List<CustomerEntity>>(customers, HttpStatus.OK);
    }
}
