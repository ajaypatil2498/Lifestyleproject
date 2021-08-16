package com.lifestyle.appl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lifestyle.appl.beans.CartItem;
import com.lifestyle.appl.services.CartItemServiceImpl;

@CrossOrigin(origins = "*")
@RestController // (@controller +@responseBody
public class CartItemController {
	
	@Autowired
	CartItemServiceImpl cartItemService;

	@GetMapping("/getcartItems/{userId}")
	public  List<CartItem> getAllCartItemsByUserId(@PathVariable("userId") int userId)
	{
		return cartItemService.getAllCartItemsByUserId(userId);
	}
	@PostMapping("/addcartItem")
	public void addCartItem(@RequestBody CartItem cartItem)
	{
		System.out.println(cartItem.getUnitPrice());
		cartItemService.addCartItem(cartItem);
	}
	@PostMapping("/deletecartItem")
	public void deleteCartItem(@RequestBody CartItem cartItem)
	{
		System.out.println("in delete cart");
		cartItemService.deleteCartItem(cartItem);
	}
	@PostMapping("/decrementquantity")
	public void decrementQuantity(@RequestBody CartItem cartItem)
	{
		System.out.println("in delete cart");
		cartItemService.decrementQuantity(cartItem);
	}
	
	@PostMapping("/incrementQuantity")
	public void incrementQuantity(@RequestBody CartItem cartItem)
	{
		System.out.println("in delete cart");
		cartItemService.incrementQuantity(cartItem);
	}
	
	
}