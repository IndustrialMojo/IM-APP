package com.industrialmojo.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerMongoRepository extends MongoRepository<CustomerMongoEntity, String> {

    public List<CustomerMongoEntity> findByFirstName(String firstName);

    public List<CustomerMongoEntity> findByLastName(String lastName);

}
