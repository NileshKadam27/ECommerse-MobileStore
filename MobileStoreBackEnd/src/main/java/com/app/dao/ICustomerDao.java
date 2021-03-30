package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Customer;



public interface ICustomerDao extends JpaRepository<Customer, Integer>  {
	public Customer findByemail(String email);
	
	

}
