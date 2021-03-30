package com.app.dto;

import com.app.pojos.Address;

public class CustomerDTO {
	
	private int customerId;
	private String email;
	private String gender;	
	private String mobileNo;
	private String address;
	private String state;
	private String dist;
	private String tal;
	private String pincode;
	

	
	

	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}





	public CustomerDTO(int customerId, String email, String gender, String mobileNo, String address, String state,
			String dist, String tal, String pincode) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.address = address;
		this.state = state;
		this.dist = dist;
		this.tal = tal;
		this.pincode = pincode;
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





	public String getGender() {
		return gender;
	}





	public void setGender(String gender) {
		this.gender = gender;
	}





	public String getMobileNo() {
		return mobileNo;
	}





	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
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





	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", email=" + email + ", gender=" + gender + ", mobileNo="
				+ mobileNo + ", address=" + address + ", state=" + state + ", dist=" + dist + ", tal=" + tal
				+ ", pincode=" + pincode + "]";
	}



	
}
