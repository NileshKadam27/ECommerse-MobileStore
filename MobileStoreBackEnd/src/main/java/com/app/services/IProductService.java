package com.app.services;



import java.util.List;

import com.app.pojos.NewProduct;

public interface IProductService {
	
	public String addProduct(NewProduct product);
	public NewProduct find(Integer id);
	public List<NewProduct>getProducts();

}
