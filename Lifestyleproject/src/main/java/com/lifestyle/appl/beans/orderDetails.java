package com.lifestyle.appl.beans;

import java.util.List;

public class orderDetails {

	private Order order;
	private List<OrderItem> orderitem;

	public orderDetails(Order order, List<OrderItem> orderitem) {
		super();
		this.order = order;
		this.orderitem = orderitem;
	}

	public orderDetails() {
		super();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderItem> getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(List<OrderItem> orderitem) {
		this.orderitem = orderitem;
	}

	@Override
	public String toString() {
		return "orderDetails [order=" + order + ", orderitem=" + orderitem + "]";
	}

}