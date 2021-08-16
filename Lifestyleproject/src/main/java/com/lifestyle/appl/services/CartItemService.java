package com.lifestyle.appl.services;

import java.util.List;

import com.lifestyle.appl.beans.CartItem;

public interface CartItemService {
	public List<CartItem> getAllCartItemsByUserId(int userId);
	public void addCartItem(CartItem cartItem);
	public void deleteCartItem(CartItem cartItem);
	public void delteCartItemByUserId(int userId);
}
