package com.lifestyle.appl.dao;

import java.util.List;

import com.lifestyle.appl.beans.OrderItem;

public interface OrderItemDao {
public void addOrderItem(OrderItem orderitem);

public List<OrderItem> getOrderItemByOrderId(int orderId);




}
