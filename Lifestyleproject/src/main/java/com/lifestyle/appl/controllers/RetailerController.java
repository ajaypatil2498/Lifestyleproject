package com.lifestyle.appl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifestyle.appl.beans.Retailer;
import com.lifestyle.appl.services.RetailerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lifestyle")
public class RetailerController {
	
	@Autowired
	private RetailerService retailerService;
	
//	//http://localhost:8090/lifestyle/register/addNewRetailer
//	@PostMapping("/register/addNewRetailer")
//	public int addRetailer(@RequestBody Retailer retailerObj)
//	{
//		int retailerId = retailerService.addRetailer(retailerObj);
//		System.out.println("New retailer added with Id: "+retailerId);
//		return retailerId;
//	}
	
	//http://localhost:8090/lifestyle/admin/viewAllRetailers
	@GetMapping("/admin/viewAllRetailers")
	public List<Retailer> getAllRetailers()
	{	System.out.println("entered controller");
		List<Retailer> retailerList = retailerService.getAllRetailers();
		//System.out.println(retailerList);
		return retailerList;
	}
	
	@GetMapping("/admin/removeRetailer/{id}")
	public Retailer removeRetailer(@PathVariable(value = "id") int retailerId)
	{
		Retailer retailerObj = retailerService.removeRetailer(retailerId);
		System.out.println("Retailer Removed:"+retailerObj);
		return retailerObj;
	}
	
	@GetMapping("/admin/approveRetailer/{id}")
	public String approveRetailer(@PathVariable(value = "id") int retailerId)
	{
		String msg = retailerService.approveRetailer(retailerId);
		System.out.println(msg);
		return msg;
	}
	
	
	//http://localhost:8090/lifestyle/admin/getRetailerById/4005
	@GetMapping("/admin/getRetailerById/{id}")
	public Retailer getRetailerById(@PathVariable(value = "id") int retailerId)
	{
		Retailer retailerObj = retailerService.getRetailerById(retailerId);
		System.out.println(retailerObj);
		return retailerObj;
	}
	
	@GetMapping("/getretailerid/{userid}")
	public int getRetailerIdByUserId(@PathVariable(value = "userid") int userid)
	{
	return retailerService.getRetailerIdFromUserId(userid);
	}
	

}
