package com.lifestyle.appl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifestyle.appl.beans.Order;
import com.lifestyle.appl.dao.OrderDao;

@Service("orderservice")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderdao;
	
	@Override
	public void addOrder(Order order) {
		 orderdao.addOrder(order);
		
	}
	@Override
	public List<Order> viewOrder() {
		System.out.println("Inside ServiceImpl");
		return orderdao.viewOrder();
	}
	@Override
	public List<Order> getOrdersByUser(int userId) {
		return orderdao.getOrdersByUser(userId);
		
		
		
	}

  
}
