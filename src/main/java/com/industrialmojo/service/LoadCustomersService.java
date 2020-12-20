package com.industrialmojo.service;

import com.industrialmojo.mongodb.entity.CustomerEntity;
import com.industrialmojo.mongodb.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadCustomersService {

    private final CustomerRepository repository;

    public LoadCustomersService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void loadCustomers() {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new CustomerEntity("Alice", "Smith"));
        repository.save(new CustomerEntity("Bob", "Smith"));
    }

    public List<CustomerEntity> findAllCustomers() {

        List<CustomerEntity> customerList = repository.findAll();

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (CustomerEntity customer : customerList) {
            System.out.println(customer);
        }
        System.out.println();

        return customerList;
    }

    public List<CustomerEntity> findCustomerByFirstName(String firstName) {

        List<CustomerEntity> customerList = repository.findByFirstName(firstName);

        // fetch an individual customer
        System.out.println("Customers found with findByFirstName('" + firstName + "'):");
        System.out.println("--------------------------------");
        for (CustomerEntity entity : customerList) {
            System.out.println(entity);
        }
        return customerList;
    }

    public List<CustomerEntity> findCustomersByLastName(String lastName) {

        List<CustomerEntity> customerList = repository.findByLastName(lastName);

        System.out.println("Customers found with findByLastName('" + lastName + "'):");
        System.out.println("--------------------------------");
        for (CustomerEntity entity : customerList) {
            System.out.println(entity);
        }
        return customerList;
    }
}
