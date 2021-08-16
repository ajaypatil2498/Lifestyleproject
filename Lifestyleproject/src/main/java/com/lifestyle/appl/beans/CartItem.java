package com.lifestyle.appl.beans;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "CART_ITEMS")
@Entity
public class CartItem {

	@Id
	@Column(name = "CART_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_CART_ITEM_ID_SEQ")
	@SequenceGenerator(name = "HB_CART_ITEM_ID_SEQ", sequenceName = "CARTITEM_ID_SEQ", allocationSize = 1)
	private int cartItemId;
	@Column(name = "UNIT_PRICE")
	private int unitPrice;
	@Column(name = "QUANTITY")
	private int quantity;
	@Column(name = "TOTAL")
	private int total;

	@OneToOne()
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	@Column(name = "USER_ID")
	private int userId;

	public CartItem() {
		super();
	}

	public CartItem(int cartItemId, int unitPrice, int quantity, int total, Product product, int userId) {
		super();
		this.cartItemId = cartItemId;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.total = total;
		this.product = product;
		this.userId = userId;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", total="
				+ total + ", product=" + product + ", userId=" + userId + "]";
	}

}