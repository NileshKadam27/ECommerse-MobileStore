package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Cart;
import com.app.pojos.Customer;

public interface ICartDao extends JpaRepository<Cart, Integer> {
	
	public List<Cart>getByCustomer(Customer customer);
	@Modifying
	@Query("delete from Cart c where c.cartId = ?1")
	void delete(int entityId);
	
	

}
