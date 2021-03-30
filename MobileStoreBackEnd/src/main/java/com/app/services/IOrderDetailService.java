package com.app.services;

import java.util.List;

import com.app.dto.OrderDetail;
import com.app.pojos.OrderDetails;

public interface IOrderDetailService {
	
	String addOrderDetails(int pId,int oId,int quantity,double price,double amount);
	List<OrderDetail>myOrderDetails(int oId);
	String deleteOrder(int oId);

}
