package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ResponseDTO;
import com.app.pojos.Cart;
import com.app.services.IAdminService;
import com.app.services.ICartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
	
	@Autowired
	private ICartService service;
	@PostMapping("/addToCart")
	public ResponseEntity<?>addProductToCart(@RequestParam int cId,@RequestParam int pId,@RequestParam double price,@RequestParam int quantity ){
		try {
			return ResponseEntity.ok(new ResponseDTO<>(service.addProductToCart(cId, pId, price, quantity)));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	@GetMapping("/getCart")
	public ResponseEntity<?>getCart(@RequestParam int cId){
		System.out.println("check");
		try {
			return ResponseEntity.ok(new ResponseDTO<>(service.getCart(cId)));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/deleteFromCart")
	public ResponseEntity<?>deleteFromCart(@RequestParam int cId,@RequestParam int pId,@RequestParam int quantity ){
		try {
			return ResponseEntity.ok(new ResponseDTO<>(service.deleteFromCart(cId, pId, quantity)));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	

}
