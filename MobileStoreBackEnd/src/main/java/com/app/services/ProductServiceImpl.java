package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.IProductDao;
import com.app.exception.CustomerException;
import com.app.pojos.NewProduct;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao dao;

	@Override
	public String addProduct(NewProduct product) {
		String msg;
		try {
	
		dao.save(product);
		System.out.println("uploaded");
		msg="Product Added Successfully";
		}catch(Exception e) {
			System.out.println("not uploaded");
			msg="Failed To Add Product";
			
		}
		return msg;
		
	}

	@Override
	public NewProduct find(Integer id) {
		NewProduct p=null;
		try {
			 p=dao.findById(id).orElseThrow(()->new CustomerException("Not found"));
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<NewProduct> getProducts() {
		return dao.findAll();
	}
	
	

}
