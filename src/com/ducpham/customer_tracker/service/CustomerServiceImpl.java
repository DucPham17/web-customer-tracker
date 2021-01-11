package com.ducpham.customer_tracker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducpham.customer_tracker.dao.CustomerDAO;
import com.ducpham.customer_tracker.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer getTheCustomer(int id) {
		// TODO Auto-generated method stub
		
		return customerDAO.getTheCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.delete(customer);
	}

}
