package com.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dao.CustomerRepositoryDao;
import com.customer.model.Customers;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerRepositoryDao customerDAO;
	
	@GetMapping("/")
	public ResponseEntity<String> Index(){
		return new ResponseEntity<String>("Hello Spring", HttpStatus.OK);
	}
	
	@PostMapping("/add-cust")
	public ResponseEntity<HttpStatus> addCustomer(@RequestBody Customers cu){
		Customers cust = customerDAO.save(cu);
		if(cust != null) {
			System.out.println("customer added \n"+ cu);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/update-cust")
	public ResponseEntity<HttpStatus> updateCustomer(@RequestBody Customers cu){
		Customers cust = customerDAO.save(cu);
		if(cust != null) {
			System.out.println("customer updated \n"+ cu);
			return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
	}

	@DeleteMapping("/delete-cust/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable int id){
		Optional<Customers> cust = (Optional<Customers>)customerDAO.findById(id);
		if(cust.isPresent()) {
			customerDAO.deleteById(id);
			System.out.println("customer deleted \n"+ cust);
			return new ResponseEntity<HttpStatus>(HttpStatus.GONE);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
	}
	
	@GetMapping("/display-cust")
	public ResponseEntity<List<Customers>> displayCustomer(){
		List<Customers> custList = (List<Customers>)customerDAO.findAll();
		
		if(custList != null) {
			System.out.println(custList);
			return new ResponseEntity<List<Customers>>(custList, HttpStatus.OK);
		}
		return new ResponseEntity<List<Customers>>(HttpStatus.CONFLICT);
	}
	
	@GetMapping("/display-cust-by-id/{id}")
	public ResponseEntity<Optional<Customers>> displayCustById(@PathVariable int id){
		Optional<Customers> cust = (Optional<Customers>)customerDAO.findById(id);
		
		if(cust.isPresent()) {
			System.out.println("customer by ID"+ cust);
			return new ResponseEntity<Optional<Customers>>(cust,HttpStatus.OK);
		}
		return new ResponseEntity<Optional<Customers>>(HttpStatus.NOT_FOUND);
	}
	
}
