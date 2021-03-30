package com.app.pojos;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "newproduct")
public class NewProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String productName;
	private String productBrand;
	@Column(length = 20)
	private String productColor;
	private String cpu;
	private String camera;
	private String size;
	private String weight;
	private String display;
	private String battery;
	private String memory;
	private double price;
	private String image;
	private int stock;
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Cart> cart;
	public NewProduct() {
		// TODO Auto-generated constructor stub
	}
	
	
	public NewProduct(String productName, String productBrand, String productColor, String cpu, String camera,
			String weight, String display, String battery, String memory, double price, String image, int stock) {
		super();
		this.productName = productName;
		this.productBrand = productBrand;
		this.productColor = productColor;
		this.cpu = cpu;
		this.camera = camera;
		this.weight = weight;
		this.display = display;
		this.battery = battery;
		this.memory = memory;
		this.price = price;
		this.image = image;
		this.stock = stock;
	}


	public NewProduct(Integer productId, String productName, String productBrand, String productColor, String cpu,
			String camera, String size, String weight, String display, String battery, String memory, double price,
			String image, int stock, List<Cart> cart) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productColor = productColor;
		this.cpu = cpu;
		this.camera = camera;
		this.size = size;
		this.weight = weight;
		this.display = display;
		this.battery = battery;
		this.memory = memory;
		this.price = price;
		this.image = image;
		this.stock = stock;
		this.cart = cart;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "NewProduct [productId=" + productId + ", productName=" + productName + ", productBrand=" + productBrand
				+ ", productColor=" + productColor + ", cpu=" + cpu + ", camera=" + camera + ", size=" + size
				+ ", weight=" + weight + ", display=" + display + ", battery=" + battery + ", memory=" + memory
				+ ", price=" + price + ", image=" + image + ", stock=" + stock + ", cart=" + cart + "]";
	}
	
	
	
}
