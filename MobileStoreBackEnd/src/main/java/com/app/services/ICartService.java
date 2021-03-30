package com.app.services;

import java.util.List;

import com.app.dto.CartProduct;
import com.app.pojos.Cart;
import com.app.pojos.NewProduct;

public interface ICartService {
	
	public String addProductToCart(int cId,int pId,double price,int quantity);
	public List<CartProduct>getCart(int cId);
	public String deleteFromCart(int cId,int pId,int quantity);

}
