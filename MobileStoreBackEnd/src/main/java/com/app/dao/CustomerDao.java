package com.app.dao;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
@Repository
public class CustomerDao implements ICustomerDao1 {

	@Autowired
	private EntityManager mgr;
	@Override
	public Customer findByEmail(String email,String password) {
		String jpql="select c from Customer c where c.email=:em and c.password=:pass";
		Customer c=mgr.createQuery(jpql, Customer.class).setParameter("em", email).setParameter("pass", password).getSingleResult();
		System.out.println("cust"+c);
		return new Customer();
	}

}
