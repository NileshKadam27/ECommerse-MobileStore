package com.app.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer OrderId;
	private LocalDate orderDate;
	private int cId;
	private String CustomerName;
	private String CustomerAddress;
	private String CustomerEmail;
	private String customerPhone;
	private double Amount;
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonBackReference
	private List<OrderDetails>details;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Orders(LocalDate orderDate, int cId, String customerName, String customerAddress, String customerEmail,
			String customerPhone, double amount, OrderStatus status) {
		super();
		this.orderDate = orderDate;
		this.cId = cId;
		CustomerName = customerName;
		CustomerAddress = customerAddress;
		CustomerEmail = customerEmail;
		this.customerPhone = customerPhone;
		Amount = amount;
		this.status = status;
	}



	public Orders(Integer orderId, LocalDate orderDate, int cId, String customerName, String customerAddress,
			String customerEmail, String customerPhone, double amount, OrderStatus status, List<OrderDetails> details) {
		super();
		OrderId = orderId;
		this.orderDate = orderDate;
		this.cId = cId;
		CustomerName = customerName;
		CustomerAddress = customerAddress;
		CustomerEmail = customerEmail;
		this.customerPhone = customerPhone;
		Amount = amount;
		this.status = status;
		this.details = details;
	}



	public Integer getOrderId() {
		return OrderId;
	}



	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}



	public LocalDate getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}



	public int getcId() {
		return cId;
	}



	public void setcId(int cId) {
		this.cId = cId;
	}



	public String getCustomerName() {
		return CustomerName;
	}



	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}



	public String getCustomerAddress() {
		return CustomerAddress;
	}



	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}



	public String getCustomerEmail() {
		return CustomerEmail;
	}



	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}



	public String getCustomerPhone() {
		return customerPhone;
	}



	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}



	public double getAmount() {
		return Amount;
	}



	public void setAmount(double amount) {
		Amount = amount;
	}



	public OrderStatus getStatus() {
		return status;
	}



	public void setStatus(OrderStatus status) {
		this.status = status;
	}



	public List<OrderDetails> getDetails() {
		return details;
	}



	public void setDetails(List<OrderDetails> details) {
		this.details = details;
	}



	@Override
	public String toString() {
		return "Orders [OrderId=" + OrderId + ", orderDate=" + orderDate + ", cId=" + cId + ", CustomerName="
				+ CustomerName + ", CustomerAddress=" + CustomerAddress + ", CustomerEmail=" + CustomerEmail
				+ ", customerPhone=" + customerPhone + ", Amount=" + Amount + ", status=" + status + ", details="
				+ details + "]";
	}



	
	
}
