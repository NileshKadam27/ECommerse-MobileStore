package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICartDao;
import com.app.dao.ICartDaoMgr;
import com.app.dao.ICustomerDao;
import com.app.dao.IProductDao;
import com.app.dto.CartProduct;
import com.app.exception.CustomerException;
import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.NewProduct;

@Service
@Transactional
public class CartServiceImpl implements ICartService {

	@Autowired
	private ICartDao cartDao;
	
	@Autowired
	private ICustomerDao customerDao;
	
	@Autowired 
	private IProductDao productDao;
	@Autowired
	private ICartDaoMgr CartDaoMgr;
	@Override
	public String addProductToCart(int cId,int pId,double price,int quantity) {
		Customer customer=null;
		NewProduct product=null;
		try {
			customer = customerDao.findById(cId).orElseThrow(()->new CustomerException("not found"));
			product=productDao.findById(pId).orElseThrow(()->new CustomerException("not found"));
			Cart cart=new Cart(customer,product,price,quantity);
			cartDao.save(cart);
			return "added successfully";
			
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";		
		
	
	}
	@Override
	public String deleteFromCart(int cId, int pId, int quantity) {
			Customer customer=null;
		
		try{
			customer  = customerDao.findById(cId).orElseThrow(()->new CustomerException("not found"));
			 List<Cart> carts=cartDao.getByCustomer(customer);
			for(Cart c:carts) {
				if(c.getProduct().getProductId()==pId&&c.getQuantity()==quantity) {
					cartDao.delete(c.getCartId());
					System.out.println("deleted"+c.getCartId());
					return "deleted";
				}
			}
		}catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Not Deleted";
	}
	@Override
	public List<CartProduct> getCart(int cId) {
		Customer customer=null;
		NewProduct products=null;
		CartProduct cartProduct=null;
		List<CartProduct>cartList=new ArrayList<>();
		try{
			customer  = customerDao.findById(cId).orElseThrow(()->new CustomerException("not found"));
			List<Cart>cart= cartDao.getByCustomer(customer);
			for(Cart c:cart) {
				cartProduct=new CartProduct();
				cartProduct.setProducts(c.getProduct());
				cartProduct.setQuantity(c.getQuantity());
				cartProduct.setPrice(c.getPrice());
				cartList.add(cartProduct);
				
			}
			
			return cartList;
			
			
		}catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cartList;
	}

}
