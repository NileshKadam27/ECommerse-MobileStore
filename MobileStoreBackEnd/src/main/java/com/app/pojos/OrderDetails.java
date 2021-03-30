package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class OrderDetails {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonManagedReference
	private Orders order;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pId")
	private NewProduct product;
	private int quantity;
	private double price;
	private double amount;
	
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}


	public OrderDetails(Orders order, NewProduct product, int quantity, double price, double amount) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}


	public OrderDetails(Integer id, Orders order, NewProduct product, int quantity, double price, double amount) {
		super();
		Id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public NewProduct getProduct() {
		return product;
	}

	public void setProduct(NewProduct product) {
		this.product = product;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderDetails [Id=" + Id + ", Order=" + order + ", product=" + product + ", quantity=" + quantity
				+ ", price=" + price + ", amount=" + amount + "]";
	}
	

}
