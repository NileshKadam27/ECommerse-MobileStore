package com.app.dto;

import com.app.pojos.NewProduct;

public class OrderDetail {
	/*
	private NewProduct product;
	private int quantity;
	private double price;
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(NewProduct product, int quantity, double price) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.price = price;
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
	@Override
	public String toString() {
		return "OrderDetail [product=" + product + ", quantity=" + quantity + ", price=" + price + "]";
	}
	*/
	private int pId;
	private String productName;
	private String productColor;
	private int quantity;
	private double price;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(int pId, String productName, String productColor, int quantity, double price) {
		super();
		this.pId = pId;
		this.productName = productName;
		this.productColor = productColor;
		this.quantity = quantity;
		this.price = price;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
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
		return "OrderDetail [pId=" + pId + ", productName=" + productName + ", productColor=" + productColor
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}

	
	

}
