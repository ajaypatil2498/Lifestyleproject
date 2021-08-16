package com.lifestyle.appl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifestyle.appl.beans.OrderItem;
import com.lifestyle.appl.dao.OrderItemDao;

@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	OrderItemDao orderItemDao;
	
	@Override
	public void addOrderItem(OrderItem orderitem) {
       orderItemDao.addOrderItem(orderitem);	
	}

	@Override
	public List<OrderItem> getOrderItemByOrderId(int orderId) {
		return orderItemDao.getOrderItemByOrderId(orderId);
		
	}

	
}
