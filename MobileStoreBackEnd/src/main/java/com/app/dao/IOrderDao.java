package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Orders;

public interface IOrderDao extends JpaRepository<Orders, Integer> {
	List<Orders>findBycId(int cId);
	

}
