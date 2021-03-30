package com.app.services;

import java.util.List;

import com.app.dto.CartProduct;
import com.app.pojos.Customer;
import com.app.pojos.Orders;

public interface IOrderService {
	
	public Orders addOrder(int cId,double price,String address); 
	public List<Orders>myOrder(int cId);
	public List<Orders>allOrders();
	public String changeStatus(int oId,String status);

}
