package com.lifestyle.appl.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {

	@Id
	@Column(name = "ORDER_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_ORDER_ITEM_ID_SEQ")
	@SequenceGenerator(name = "HB_ORDER_ITEM_ID_SEQ", sequenceName = "ORDER_ITEM_ID_SEQ", allocationSize = 1)
	private int orderItemId;

	@OneToOne()
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	@Column(name = "UNIT_PRICE")
	private long unitPrice;
	@Column(name = "QUANTITY")
	private int quantity;
	@Column(name = "TOTAL")
	private long total;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	public OrderItem() {
		super();
	}

	public OrderItem(int orderItemId, Product product, long unitPrice, int quantity, long total, Order order) {
		super();
		this.orderItemId = orderItemId;
		this.product = product;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.total = total;
		this.order = order;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", product=" + product + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", total=" + total + ", order=" + order + "]";
	}

}
