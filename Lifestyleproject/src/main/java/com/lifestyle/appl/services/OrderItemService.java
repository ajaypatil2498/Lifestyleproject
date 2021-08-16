package com.lifestyle.appl.services;

import java.util.List;

import com.lifestyle.appl.beans.OrderItem;

public interface OrderItemService {
	public void addOrderItem(OrderItem orderitem);
	public List<OrderItem> getOrderItemByOrderId(int orderId);
}
