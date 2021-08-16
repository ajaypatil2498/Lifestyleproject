package com.lifestyle.appl.beans;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ORDERS")
public class Order {
	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_ORDER_ID_SEQ")
	@SequenceGenerator(name = "HB_ORDER_ID_SEQ", sequenceName = "ORDER_ID_SEQ", allocationSize = 1)
	private int orderId;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "GRAND_TOTAL")
	private long grandTotal;
	@Column(name = "PAYMENT_TYPE")
	private String paymentType;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;

	public Order() {
		super();
	}

	public Order(int orderId, String status, long grandTotal, String paymentType, Address address, User user) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.grandTotal = grandTotal;
		this.paymentType = paymentType;
		this.address = address;
		this.user = user;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(long grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", status=" + status + ", grandTotal=" + grandTotal + ", paymentType="
				+ paymentType + ", address=" + address + ", user=" + user + "]";
	}

}
