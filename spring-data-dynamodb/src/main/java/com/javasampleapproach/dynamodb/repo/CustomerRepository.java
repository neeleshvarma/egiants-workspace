package com.javasampleapproach.dynamodb.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;


import com.javasampleapproach.dynamodb.model.Customer;

@EnableScan
public interface CustomerRepository extends DynamoDBCrudRepository<Customer, String> {

	List<Customer> findByLastName(String lastName);
}
