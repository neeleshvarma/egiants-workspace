package com.javasampleapproach.dynamodb.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.dynamodb.model.Customer;
import com.javasampleapproach.dynamodb.repo.CustomerRepository;


@RestController
public class WebController {

	@Autowired
	CustomerRepository repository;
	
	@DeleteMapping("delete/{id}")
	public boolean deleteUser(@PathVariable String id) throws Exception {
		if(repository.exists(id))
		{
			repository.delete(id); 
			return true;
		}
		else
		{
			throw new Exception("userId doesnt exists");
		}
		
	}
	
	@PostMapping("/save")
	public void save(@RequestBody Customer users) throws Exception {
		if(!repository.exists(users.getId()))
			{
					repository.save(users);
			}
			else {			
				throw new Exception("userId already exists");
			}
	
    }
	
	@GetMapping("/findall")
	public List<Customer> getAll() throws Exception{
		List<Customer> customers = (List<Customer>) repository.findAll();
		return customers;
	}


	@GetMapping("/{id}")
	public Customer getUser(@PathVariable String id) throws Exception  {
		if(repository.exists(id))
		{
			return repository.findOne(id);
		}
		else
		{
			throw new Exception("userId doesnt exists");
		}
	}
	

	@PutMapping("/put/{id}")
	public void update(@RequestBody Customer customer, @PathVariable String id) throws Exception {
		if(repository.exists((customer.getId())))
		{
			repository.save(customer);
		}
		else {
			throw new Exception("userId doesnt Exist");
		}
		
	}
	
}
