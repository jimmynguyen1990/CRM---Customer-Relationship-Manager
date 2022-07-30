package com.training.web_customer_tracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.web_customer_tracker.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//Use SessionFactory object to create a current session 
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//Create a current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//Create a query
		Query<Customer>theQuery = session.createQuery("from Customer order by lastName", Customer.class);
		
		//Retrieve customer list
		List<Customer>customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer newCustomer) {
		
		//Create a current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//Save new customer to the database
		session.saveOrUpdate(newCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		//Set up a current hibernate transaction
		Session session = sessionFactory.getCurrentSession();
		
		//Retrieve customer from the database
		Customer theCustomer = session.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//Set up a current hibernate transaction
		Session session = sessionFactory.getCurrentSession();
		
		//Set up delete query
		Query theQuery = session.createQuery("delete from Customer where id = :customerId");
		theQuery.setParameter("customerId", theId);
		
		//Execute the query
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomers(String theName) {
		
		Query theQuery = null;
		
		Session session = sessionFactory.getCurrentSession();
		
		if(theName != null && theName.trim().length() > 0) {
			
			theQuery = session.createQuery("from Customer where lower(firstName) like :theName "
					+ "or lower(lastName) like :theName");
			
			theQuery.setParameter("theName", "%" + theName.toLowerCase() + "%");
			
		}
		else
			theQuery = session.createQuery("from Customer");
		
		List<Customer>customers = theQuery.getResultList();
		
		return customers;
	}

}
