package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adressId;
	private String address;
	private String tal;
	private String dist;
	private String state;
	private String pincode;
	@OneToOne
	@JoinColumn(name = "c_id")
	private Customer customer;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(int adressId, String address, String tal, String dist, String state, String pincode,
			Customer customer) {
		super();
		this.adressId = adressId;
		this.address = address;
		this.tal = tal;
		this.dist = dist;
		this.state = state;
		this.pincode = pincode;
		this.customer = customer;
	}
	
	
	
	public Address(String address, String tal, String dist, String state, String pincode, Customer customer) {
		super();
		this.address = address;
		this.tal = tal;
		this.dist = dist;
		this.state = state;
		this.pincode = pincode;
		this.customer = customer;
	}
	public int getAdressId() {
		return adressId;
	}
	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTal() {
		return tal;
	}
	public void setTal(String tal) {
		this.tal = tal;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Address [adressId=" + adressId + ", address=" + address + ", tal=" + tal + ", dist=" + dist + ", state="
				+ state + ", pincode=" + pincode + ", customer=" + customer + "]";
	}
	
	

}
