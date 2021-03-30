package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "mycart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonManagedReference
	private Customer customer;
	@ManyToOne()
	@JoinColumn(name = "product_id")
	@JsonManagedReference
	private NewProduct product;
	private double price;
	private int quantity;
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public Cart(int cartId, Customer customer, NewProduct product, double price, int quantity) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Cart(Customer customer, NewProduct product, double price, int quantity) {
		super();
		this.customer = customer;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public NewProduct getProduct() {
		return product;
	}
	public void setProduct(NewProduct product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customer=" + customer + ", product=" + product + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
	

}
