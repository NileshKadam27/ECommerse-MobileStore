package com.app.dao;



import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Cart;

@Repository
public class CartDaoMgr implements ICartDaoMgr {
	
	@Autowired
	private EntityManager mgr;

	@Override
	public Cart deleteFromCart(int cId, int pId,int quantity) {
		//String jpql="select c from Cart c where c.customer_id:cid and c.product_id:pid and c.quantity:quantity";
		String jpql="select c from Cart c ";
		//return mgr.createQuery(jpql, Cart.class).setParameter("cid", cId).setParameter("pid", pId)
		//		.setParameter("quantity", quantity).getSingleResult();
		return mgr.createQuery(jpql, Cart.class)
					.getSingleResult();
		
	}

}
