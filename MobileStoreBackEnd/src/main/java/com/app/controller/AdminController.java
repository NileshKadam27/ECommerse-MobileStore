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

import com.app.services.IAdminService;


@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	@Autowired
	private IAdminService service;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> getUserDetails(@RequestParam String email,@RequestParam String password) {
		System.out.println("in get user dtls " + email);
		try{
			return ResponseEntity.ok(new ResponseDTO<>(service.getAdminDetails(email,password)));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("invalid email and password"),
					HttpStatus.NOT_FOUND);
		}
	}
	
}
