package com.industrialmojo.service;

import com.industrialmojo.dto.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetCustomerOverService implements GetCustomerService {

    public List<Customer> getCustomers() {

        return CUSTOMERS.stream()
                .filter(Customer::hasOverHundredPoints)
                .collect(Collectors.toList());
    }
}
