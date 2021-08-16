package com.lifestyle.appl.services;

import java.util.List;

import com.lifestyle.appl.beans.Order;

public interface OrderService {
	public void addOrder(Order order);
	public abstract List<Order> viewOrder();
	public List<Order> getOrdersByUser(int userId);
}
