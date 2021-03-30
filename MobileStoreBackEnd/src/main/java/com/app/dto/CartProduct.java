package com.app.dto;

import java.util.List;

import com.app.pojos.NewProduct;

public class CartProduct {

	private NewProduct products;
	private int quantity;
	private double price;
	
	public CartProduct() {
		// TODO Auto-generated constructor stub
	}

	public CartProduct(NewProduct products, int quantity, double price) {
		super();
		this.products = products;
		this.quantity = quantity;
		this.price = price;
	}

	public NewProduct getProducts() {
		return products;
	}

	public void setProducts(NewProduct products) {
		this.products = products;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartProduct [products=" + products + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
