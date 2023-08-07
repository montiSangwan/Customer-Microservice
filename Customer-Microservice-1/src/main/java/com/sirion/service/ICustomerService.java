package com.sirion.service;

import java.util.List;
import java.util.Optional;

import com.sirion.entity.Customer;

public interface ICustomerService {


	public Customer addCustomer(Customer customer);
	public Customer deleteCustomer(Customer customer);
	public Customer viewCustomerById(int customerId);
	public List<Customer> viewAllCustomer();
	public Customer updateCustomer(Customer c);
	public List<Customer> viewAllCustomersByLocation(String location);
}

