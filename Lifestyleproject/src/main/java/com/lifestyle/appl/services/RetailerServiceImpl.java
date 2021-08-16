package com.lifestyle.appl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifestyle.appl.beans.Retailer;
import com.lifestyle.appl.dao.RetailerDao;

@Service("retailerService")
public class RetailerServiceImpl implements RetailerService{

	@Autowired
	RetailerDao retailerDao;
	@Override
	public void addRetailer(Retailer retailer) {
		retailerDao.addRetailer(retailer);
		
	}
	@Override
	public List<Retailer> getAllRetailers() {
		System.out.println("entered service");
		return retailerDao.getAllRetailers();
	}

	@Override
	public Retailer removeRetailer(int retailerId) {
		
		return retailerDao.removeRetailer(retailerId);
	}

	@Override
	public String approveRetailer(int retailerId) {
		
		return retailerDao.approveRetailer(retailerId);
	}

	@Override
	public Retailer getRetailerById(int retailerId) {
		
		return retailerDao.getRetailerById(retailerId);
	}
	@Override
	public int getRetailerIdFromUserId(int userId) {
		return retailerDao.getRetailerIdFromUserId(userId);
	}

}
