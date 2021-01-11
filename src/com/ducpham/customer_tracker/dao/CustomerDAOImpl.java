package com.ducpham.customer_tracker.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ducpham.customer_tracker.entity.Customer;



@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomer() {
			Session session = sessionFactory.getCurrentSession();
			Query<Customer> list = session.createQuery("from Customer",Customer.class);
			List<Customer> res = list.getResultList();
		return res;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(customer);
	}

	@Override
	public Customer getTheCustomer(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Customer.class,id);
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(customer);
		
	}

}
