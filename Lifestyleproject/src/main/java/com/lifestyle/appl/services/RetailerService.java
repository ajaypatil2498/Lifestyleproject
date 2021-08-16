package com.lifestyle.appl.services;

import java.util.List;

import com.lifestyle.appl.beans.Retailer;

public interface RetailerService {

	void addRetailer(Retailer retailer);

	public List<Retailer> getAllRetailers();

	public Retailer removeRetailer(int retailerId);

	public String approveRetailer(int retailerId);

	public Retailer getRetailerById(int retailerId);

	public int getRetailerIdFromUserId(int userId);
}
