package com.industrialmojo.mongodb;

import com.industrialmojo.mongodb.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

    public List<CustomerEntity> findByFirstName(String firstName);

    public List<CustomerEntity> findByLastName(String lastName);

}
