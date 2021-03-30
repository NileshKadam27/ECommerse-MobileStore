package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.OrderDetails;


@Repository 
public class OrderDetailsDaoFactory implements IOrderDetailsDaoFactory {
	 @Autowired
	 private EntityManager mgr;
	 public List<OrderDetails> listOrderDetailInfos(int orderId) {
	        String sql = "select o from OrderDetails o where o.Order.OrderId=:orderId";
	        return mgr.createQuery(sql, OrderDetails.class).setParameter("orderId", orderId).getResultList();
	 
	       	 
	    }

}
