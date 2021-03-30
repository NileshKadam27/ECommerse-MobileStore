package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.OrderDetail;
import com.app.dto.ResponseDTO;
import com.app.services.IOrderDetailService;

@RestController
@CrossOrigin
@RequestMapping("orderDetails")
public class OrderDetailsController {
	
	@Autowired
	private IOrderDetailService service;
	 
	@GetMapping("addDetails")
	public ResponseEntity<?>addOrderDetails(@RequestParam int pId,@RequestParam int oId,@RequestParam int Quantity,@RequestParam double price,@RequestParam double amount){
		try {
			return ResponseEntity.ok(new ResponseDTO<>(service.addOrderDetails(pId,oId,Quantity,price,amount)));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("myOrderDetails")
	public List<OrderDetail>myOrderDetails(@RequestParam int oId){
		/*try {
			return ResponseEntity.ok(new ResponseDTO<>(service.myOrderDetails(oId)));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		 List<OrderDetail>od=service.myOrderDetails(oId);
		 return od;
	}
	
	@GetMapping("deleteOrder")
	public ResponseEntity<?>deleteOrder(@RequestParam int oId){
		try {
			return ResponseEntity.ok(new ResponseDTO<>(service.deleteOrder(oId)));
		}catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
