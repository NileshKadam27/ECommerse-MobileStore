package com.app.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.dao.IOrderDao;
import com.app.dao.IOrderDetailDao;
import com.app.dto.CartProduct;
import com.app.exception.CustomerException;
import com.app.pojos.Address;
import com.app.pojos.Customer;
import com.app.pojos.OrderDetails;
import com.app.pojos.OrderStatus;
import com.app.pojos.Orders;
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private ICustomerDao customerDao;
	@Override
	public Orders addOrder(int cId, double price,String address) {
		Orders order=null;
		try {
			Customer customer=customerDao.findById(cId).orElseThrow(()->new CustomerException("not found"));
			//Address address=customer.getAddress();
			//String Address1=address.getAddress()+"State "+address.getState()+"dist "+address.getDist()+"tal "+address.getTal()+"PinCode "+address.getPincode();
			//order=new Orders(LocalDate.now(),customer.getCustomerId(),customer.getCustName(),Address1,customer.getEmail(),customer.getMobileNo(),price,OrderStatus.Order_Placed);
			order=new Orders(LocalDate.now(),customer.getCustomerId(),customer.getCustName(),address,customer.getEmail(),customer.getMobileNo(),price,OrderStatus.Order_Placed);
			orderDao.save(order);
			
			
		}catch(Exception e) {
			
		}
		
		return order;
		
	
		
	}
	@Override
	public List<Orders> myOrder(int cId) {
		List<Orders>myOrder=new ArrayList<>();
		try {
			myOrder=orderDao.findBycId(cId);
			
			
			
		}catch(Exception e) {
			
		}
		return myOrder;
	}
	@Override
	public List<Orders> allOrders() {
		List<Orders>orders=orderDao.findAll();
		List<Orders>od=new ArrayList<>();
		for(Orders od1:orders) {
			if(od1.getStatus()==OrderStatus.Order_Placed||od1.getStatus()==OrderStatus.Order_Despached) {
				od.add(od1);			}
		}
		return od;
	}
	@Override
	public String changeStatus(int oId, String status) {
		String msg="";
		try {
			OrderStatus st=OrderStatus.valueOf(status);
			System.out.println(st);
			System.out.println("hello");
			Orders od=orderDao.findById(oId).orElseThrow(()->new CustomerException("not found"));
			if(od.getStatus()!=OrderStatus.Order_Delivered) {
				od.setStatus(st);
				orderDao.save(od);
				
			}
			
			
		}catch(Exception e) {
			
		}
		return msg;
	}

}
