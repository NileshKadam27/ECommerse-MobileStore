package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ResponseDTO;
import com.app.pojos.Address;
import com.app.pojos.Customer;
import com.app.services.ICustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
	@Autowired
	private ICustomerService service;
	@PostMapping("/register")
	public void RegisterCustomer(@RequestParam String custName,@RequestParam String email,@RequestParam String password,@RequestParam String mobileNo) {
		Customer customer=new Customer(email,custName,password,null,mobileNo);
		System.out.println("name"+custName);
		service.addCustomer(customer);
	}

	@PutMapping("/address")
	public ResponseEntity<?> addAddress(@RequestParam int cId,@RequestParam String Address,@RequestParam String state,@RequestParam String dist,@RequestParam String tal,@RequestParam String pincode)
	{
		
		service.addAddress(cId,Address,state,dist,tal,pincode);
		try {
			return ResponseEntity.ok(new ResponseDTO<>(service.addAddress(cId,Address,state,dist,tal,pincode)));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> getUserDetails(@RequestParam String email,@RequestParam String password) {
//		System.out.println("in get user dtls " + email);
		try{
			return ResponseEntity.ok(new ResponseDTO<>(service.getCustomerDetails(email,password)));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("invalid email and password"),
					HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
