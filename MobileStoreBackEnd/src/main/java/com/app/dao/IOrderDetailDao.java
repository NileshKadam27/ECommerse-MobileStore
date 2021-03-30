package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;

public interface IOrderDetailDao extends JpaRepository<OrderDetails, Integer>{
/*
	@Modifying
	@Query("select od from Orders o inner join OrderDetails od on o.OrderId=od.OrderId where o.OrderId=:OrderId")
	List<OrderDetails>findAllByOrder(@Param("OrderId") int OrderId);
	//List<OrderDetails>findByOrderId(int oId);
	*/
	/*@Modifying
	@Query("select od from OrderDetails od where od.Order.OrderId= ?1")
	List<OrderDetails>findAllByOrder(int OrderId);
	*/
	
	public List<OrderDetails>getByOrder(Orders order);
	

}
