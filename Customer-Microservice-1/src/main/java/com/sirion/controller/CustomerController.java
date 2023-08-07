package com.sirion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirion.entity.Customer;
import com.sirion.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@DeleteMapping
	public Customer deleteCustomer(Customer customer) {
		return customerService.deleteCustomer(customer);
	}

	
	@GetMapping("/{customerId}")
	public Customer viewCustomerById(@PathVariable int customerId) {
		return customerService.viewCustomerById(customerId);
	}
	
	@GetMapping
	public List<Customer> viewAllCustomer() {
		return customerService.viewAllCustomer();
	}
	
	@PutMapping
	public Customer updateCustomer(Customer c) {
		return customerService.updateCustomer(c);
	}
	
	
	@GetMapping("/location/{location}")
	public List<Customer> viewAllCustomersByLocation(@PathVariable String location) {
		return customerService.viewAllCustomersByLocation(location);
	}
	
}
