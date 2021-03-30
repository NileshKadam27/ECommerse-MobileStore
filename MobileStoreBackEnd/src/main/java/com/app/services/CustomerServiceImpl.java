package com.app.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAddresDao;
import com.app.dao.ICustomerDao;
import com.app.dao.ICustomerDao1;
import com.app.dto.CustomerDTO;
import com.app.exception.CustomerException;
import com.app.pojos.Address;
import com.app.pojos.Customer;

import antlr.collections.List;
@Service
@Transactional
public class CustomerServiceImpl  implements ICustomerService{

	@Autowired
	private ICustomerDao dao;
	@Autowired
	private ICustomerDao1 dao1;
	
	@Autowired
	private IAddresDao addressDao;
	@Override
	public void addCustomer(Customer c) {
		
		dao.save(c);
	}
	
	@Override
	public CustomerDTO getCustomerDetails(String email,String password) throws CustomerException {
		Customer c=dao.findByemail(email);
		CustomerDTO cDto=null;
		System.out.println(c==null);
		if(c!=null)
		{
			if(c.getPassword().equals(password)) {
			cDto=new CustomerDTO();
			BeanUtils.copyProperties(c, cDto, "password");
			}
			
		}else {
			throw new CustomerException("inavalid details");
		}
		return cDto;
		
	
	}
	@Override
	public CustomerDTO addAddress(int cId, String address1, String state, String dist, String tal, String pincode) {
		CustomerDTO cDto=null;
		Customer customer=null;
		
		try {
			customer=dao.findById(cId).orElseThrow(()->new CustomerException("not found"));
			
			customer.setAddress(address1);
			customer.setState(state);
			customer.setDist(dist);
			customer.setTal(tal);
			customer.setPincode(pincode);
			dao.save(customer);
			cDto=new CustomerDTO();
			BeanUtils.copyProperties(customer, cDto, "password");

			
			
			
			
			
		}catch(Exception e) {
			
		}
		
		return cDto;
	}
	
	

}
