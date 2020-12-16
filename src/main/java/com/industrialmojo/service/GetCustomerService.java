package com.industrialmojo.service;

import com.industrialmojo.dto.Customer;

import java.util.Arrays;
import java.util.List;

public interface GetCustomerService {

    Customer CUSTOMER_1 = new Customer("John P.", 15);
    Customer CUSTOMER_2 = new Customer("Sarah M.", 200);
    Customer CUSTOMER_3 = new Customer("Charles B.", 150);
    Customer CUSTOMER_4 = new Customer("Mary T.", 1);

    List<Customer> CUSTOMERS = Arrays.asList(CUSTOMER_1, CUSTOMER_2, CUSTOMER_3, CUSTOMER_4);

    List<Customer> getCustomers();
}
