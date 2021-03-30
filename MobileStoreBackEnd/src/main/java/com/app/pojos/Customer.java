package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@Column(nullable = false,unique = true)
	private String email;
	private String custName;
	@Column(length = 20,nullable = false)
	
    private String password;
	private String gender;
	private String Address;
	private String state;
	private String dist;
	private String tal;
	private String pincode;
	@Column(length = 10)
	private String mobileNo;
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Cart>cart;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String email, String custName, String password, String gender, String address,
			String state, String dist, String tal, String pincode, String mobileNo, List<Cart> cart) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.custName = custName;
		this.password = password;
		this.gender = gender;
		Address = address;
		this.state = state;
		this.dist = dist;
		this.tal = tal;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.cart = cart;
	}
	
	

	public Customer(String email, String custName, String password, String gender, String mobileNo) {
		super();
		this.email = email;
		this.custName = custName;
		this.password = password;
		this.gender = gender;
		this.mobileNo = mobileNo;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getTal() {
		return tal;
	}

	public void setTal(String tal) {
		this.tal = tal;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", email=" + email + ", custName=" + custName + ", password="
				+ password + ", gender=" + gender + ", Address=" + Address + ", state=" + state + ", dist=" + dist
				+ ", tal=" + tal + ", pincode=" + pincode + ", mobileNo=" + mobileNo + ", cart=" + cart + "]";
	}
	
	

		
	
	
}
