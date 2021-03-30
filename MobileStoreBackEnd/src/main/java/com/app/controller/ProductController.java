package com.app.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.ResponseDTO;
import com.app.pojos.NewProduct;
import com.app.services.ProductServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl service;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addproduct(@RequestParam String productName,@RequestParam String productBrand,@RequestParam String battery,
			@RequestParam String camera,@RequestParam String weight,@RequestParam String cpu,@RequestParam String display,@RequestParam String image,@RequestParam String memory,
			@RequestParam double price,@RequestParam String productColor,@RequestParam int stock) {
		NewProduct newproduct=new NewProduct(productName, productBrand, productColor, cpu, camera,
				weight,  display, battery, memory, price, image, stock);
		System.out.println(newproduct.getProductName());
		try{
			return ResponseEntity.ok(new ResponseDTO<>(service.addProduct(newproduct)));
		}catch(Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("Failed to add New Product"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/*@GetMapping("/getProductList")
	public ResponseEntity<?>getProducts(){
		try {
			return ResponseEntity.ok(new ResponseDTO<>(service.getProducts()));
		}catch(Exception e) {
			return new ResponseEntity<>(new ResponseDTO<>("Failed"),
					HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
	
	@GetMapping("/getProductList")
	public List<NewProduct>getProducts(){
		return service.getProducts();
	}
	
	
	
	
	

}

