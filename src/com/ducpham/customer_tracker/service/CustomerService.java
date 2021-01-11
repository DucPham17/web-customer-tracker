package com.ducpham.customer_tracker.service;

import java.util.List;

import com.ducpham.customer_tracker.entity.Customer;

public interface CustomerService{
	
	public List<Customer> getCustomer();

	public void saveCustomer(Customer customer);

	public Customer getTheCustomer(int id);
	
	public void deleteCustomer(Customer customer);

}
