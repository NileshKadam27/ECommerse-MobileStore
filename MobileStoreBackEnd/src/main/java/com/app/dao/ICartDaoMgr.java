package com.app.dao;

import com.app.pojos.Cart;

public interface ICartDaoMgr {
	
	public Cart deleteFromCart(int cId,int pId,int quantity);

}
