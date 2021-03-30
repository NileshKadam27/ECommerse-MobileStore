package com.app.dao;

import java.util.List;

import com.app.pojos.OrderDetails;

public interface IOrderDetailsDaoFactory {
	List<OrderDetails> listOrderDetailInfos(int orderId);

}
