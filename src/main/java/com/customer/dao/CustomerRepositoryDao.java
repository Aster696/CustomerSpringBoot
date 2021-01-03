package com.customer.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.customer.model.Customers;

@Component
public interface CustomerRepositoryDao extends CrudRepository<Customers, Integer>{
	
}
