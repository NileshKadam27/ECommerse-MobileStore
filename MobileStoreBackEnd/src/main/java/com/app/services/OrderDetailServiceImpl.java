package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderDao;
import com.app.dao.IOrderDetailDao;
import com.app.dao.IOrderDetailsDaoFactory;
import com.app.dao.IProductDao;
import com.app.dao.OrderDetailsDaoFactory;
import com.app.dto.OrderDetail;
import com.app.exception.CustomerException;
import com.app.pojos.NewProduct;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;

@Service
@Transactional
public class OrderDetailServiceImpl implements IOrderDetailService {

	@Autowired
	private IOrderDetailDao orderDetailDao;
	@Autowired
	private IProductDao productDao;
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private IOrderDetailsDaoFactory oDao;
	@Override
	public String addOrderDetails(int pId, int oId,int quantity, double price, double amount) {
		String msg="error";
		try {
			
			NewProduct product=productDao.findById(pId).orElseThrow(()->new CustomerException("not found"));
			Orders order=orderDao.findById(oId).orElseThrow(()->new CustomerException("not found"));
			OrderDetails orderDetail=new OrderDetails(order,product,quantity,price,amount);
		
			orderDetailDao.save(orderDetail);
			msg="added";
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return msg;
		
	}
	@Override
	public List<OrderDetail> myOrderDetails(int oId) {
		List<OrderDetails>myOrderDetails=new ArrayList<>();
		List<OrderDetail>detail=new ArrayList<>();
		try {
			
			//myOrderDetails=orderDao.findBycId(oId);
			Orders order=orderDao.findById(oId).orElseThrow(()->new CustomerException("not found"));
			//myOrderDetails=order.getDetails();		
			//myOrderDetails=orderDetailDao.findAllByOrder(oId);
			System.out.println("check2");
			myOrderDetails=orderDetailDao.getByOrder(order);
			
			for(OrderDetails od:myOrderDetails) {
				OrderDetail odetail=new OrderDetail();
				//odetail.setProduct(od.getProduct());
				odetail.setpId(od.getProduct().getProductId());
				odetail.setQuantity(od.getQuantity());
				odetail.setProductName(od.getProduct().getProductName());
				odetail.setProductColor(od.getProduct().getProductColor());
				odetail.setPrice(od.getPrice());
				detail.add(odetail);
				System.out.println(odetail);
			}
			System.out.println("check2");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return detail;
	}
	@Override
	public String deleteOrder(int oId) {
		String msg="";
		try {
			//List<OrderDetails>myOrderDetails=new ArrayList<>();
			Orders order=orderDao.findById(oId).orElseThrow(()->new CustomerException("not found"));
			//List<OrderDetails>myOrderDetails=orderDetailDao.getByOrder(order);
			//orderDetailDao.deleteInBatch(myOrderDetails);
			orderDao.delete(order);
			msg="removed";
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return msg;
	}

	
}
