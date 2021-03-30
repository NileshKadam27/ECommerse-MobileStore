package com.app.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.dao.ICustomerDao;
import com.app.dto.AdminDTO;
import com.app.dto.CustomerDTO;

import com.app.exception.CustomerException;
import com.app.pojos.Address;
import com.app.pojos.Admin;
import com.app.pojos.Customer;

import antlr.collections.List;
@Service
@Transactional
public class AdminServiceImpl  implements IAdminService{

	@Autowired
	private IAdminDao dao;
	

	@Override
	public AdminDTO getAdminDetails(String email,String password) throws Exception {
		Admin a=dao.findByemail(email);
		AdminDTO aDto=null;
		System.out.println(a==null);
		if(a!=null)
		{
			if(a.getPassword().equals(password)) {
				aDto=new AdminDTO();
				BeanUtils.copyProperties(a, aDto, "password");
				
		
			
			}else {
				throw new CustomerException("invalid details");
			}
		
		}else {
			throw new CustomerException("invalid details");
		}
		return aDto;
	
		}

}

