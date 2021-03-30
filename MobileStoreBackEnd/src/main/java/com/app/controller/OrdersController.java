package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CartProduct;
import com.app.dto.ResponseDTO;
import com.app.pojos.Address;
import com.app.pojos.Customer;
import com.app.services.IOrderService;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrdersController {
	
	@Autowired
	private IOrderService service;
	
	@GetMapping("/addOrder")
	public ResponseEntity<?>addOrder(@RequestParam int cId,@RequestParam double amount,@RequestParam String address){
		try {
			return ResponseEntity.ok(new ResponseDTO<>(service.addOrder(cId,amount,address)));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/myOrder")
	public ResponseEntity<?>myOrder(@RequestParam int cId){
		try {
			return ResponseEntity.ok(new ResponseDTO<>(service.myOrder(cId)));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/allOrder")
	public ResponseEntity<?>allOrder(){
		try {
			return ResponseEntity.ok(new ResponseDTO<>(service.allOrders()));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/changeStatus")
	public ResponseEntity<?>changeStatus(@RequestParam int oId,@RequestParam String status){
		try {
			return ResponseEntity.ok(new ResponseDTO<>(service.changeStatus(oId,status)));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

}
