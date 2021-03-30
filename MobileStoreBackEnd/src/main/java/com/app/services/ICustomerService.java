package com.app.services;


import com.app.dto.CustomerDTO;
import com.app.exception.CustomerException;
import com.app.pojos.Address;
import com.app.pojos.Customer;

public interface ICustomerService {

	public void addCustomer(Customer c);
	
	public CustomerDTO getCustomerDetails(String email,String password) throws CustomerException;
	public CustomerDTO addAddress(int cId,String address,String state,String dist,String tal,String pincode);
}
