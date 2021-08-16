package com.lifestyle.appl.dao;

import java.util.List;



import com.lifestyle.appl.beans.Order;

public interface OrderDao {

	public void addOrder(Order order);
	public  List<Order> viewOrder();
	public List<Order> getOrdersByUser(int userId);
	
	
}
