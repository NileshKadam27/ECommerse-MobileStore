package com.app.dao;

import java.util.Optional;

import com.app.pojos.Customer;

public interface ICustomerDao1 {
	public Customer findByEmail(String email,String password);

}
