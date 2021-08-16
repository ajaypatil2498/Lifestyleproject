package com.lifestyle.appl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifestyle.appl.beans.CartItem;
import com.lifestyle.appl.dao.CartItemDaoImpl;

@Service
public class CartItemServiceImpl implements CartItemService {
	@Autowired
	CartItemDaoImpl cartItemDao;
	public List<CartItem> getAllCartItemsByUserId(int userId)
	{
		return cartItemDao.getAllCartItemsByUserId(userId);
		
	}
	public void addCartItem(CartItem cartItem)
	{
		cartItemDao.addCartItem(cartItem);
	}
	@Override
	public void deleteCartItem(CartItem cartItem) {
		cartItemDao.deleteCartItem(cartItem);
		
	}
	public void decrementQuantity(CartItem cartItem) {
		cartItemDao.decrementQuantity(cartItem);
		
	}
	public void incrementQuantity(CartItem cartItem) {
	
		cartItemDao.incrementQuantity(cartItem);
	}
	@Override
	public void delteCartItemByUserId(int userId) {
		cartItemDao.delteCartItemByUserId(userId);
		System.out.println("in delete");
	}
	
}
