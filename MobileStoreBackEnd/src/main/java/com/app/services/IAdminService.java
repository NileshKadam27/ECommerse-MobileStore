package com.app.services;

import com.app.dto.AdminDTO;

//import com.app.pojos.Address;
//import com.app.pojos.Customer;


public interface IAdminService {

	
	 AdminDTO getAdminDetails(String email,String password) throws Exception ;
}
