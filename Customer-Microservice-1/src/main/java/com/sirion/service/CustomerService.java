package com.sirion.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirion.entity.Customer;
import com.sirion.repository.CustomerRepository;


@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository repo;

	@Override
	public Customer addCustomer(Customer customer) {
		Optional<Customer> obj = repo.findById(customer.getCustomerId());
		if(obj.isPresent())
			return null;
		else {
			repo.saveAndFlush(customer);
			return obj.get();
		}
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		Optional<Customer> obj = repo.findById(customer.getCustomerId());
		if(obj.isPresent()) {
			repo.deleteById(customer.getCustomerId());
			return obj.get();
		}
		else
			return null;
	}

	@Override
	public Customer viewCustomerById(int customerId) {
		Optional<Customer> obj = repo.findById(customerId);
		if(obj.isPresent())
			return obj.get();
		else
			return null;
	}

	@Override
	public List<Customer> viewAllCustomer() {
		return repo.findAll();
	}
	
	@Override
	public Customer updateCustomer(Customer c) {
		Optional<Customer> obj = repo.findById(c.getCustomerId());
		
		if(obj.isPresent()) {
			repo.saveAndFlush(c);
			return obj.get();
		}
		
		return null;
	}
	
	@Override
	public List<Customer> viewAllCustomersByLocation(String location) {
		return repo.findByAddress(location);   // make findByAddress in CustomerRepository
	}
}
