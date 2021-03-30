package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.NewProduct;

public interface IProductDao extends JpaRepository<NewProduct, Integer> {

}
