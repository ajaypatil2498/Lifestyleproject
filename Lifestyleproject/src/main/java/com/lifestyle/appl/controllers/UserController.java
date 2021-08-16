package com.lifestyle.appl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifestyle.appl.beans.Retailer;
import com.lifestyle.appl.beans.User;
import com.lifestyle.appl.beans.UserRetailer;
import com.lifestyle.appl.services.RetailerServiceImpl;
import com.lifestyle.appl.services.UserServiceImpl;

@CrossOrigin(origins = "*")
@RestController // (@controller +@responseBody
@RequestMapping("/lifestyle")
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@Autowired
	RetailerServiceImpl retailerService;

	@PostMapping("/registeruser")
	public void registerUser(@RequestBody UserRetailer userretailer) throws Exception {
		String tempEmailId = userretailer.getEmailId();
		if (tempEmailId != null && !tempEmailId.equals("")) {
			User userobj = userService.fetchUserByEmailId(tempEmailId);
			System.out.println("in if");
			if (userobj != null)
				throw new Exception("user with " + tempEmailId + " is already exist");
		}
		System.out.println("outside if");

		User user = new User();
		user.setFirstName(userretailer.getFirstName());
		user.setLastName(userretailer.getLastName());
		user.setEmailId(userretailer.getEmailId());
		user.setPhoneNumber(userretailer.getPhoneNumber());
		user.setPassword(userretailer.getPassword());
		user.setRole(userretailer.getRole());
		if (user.getRole().equals("Customer")) {
			System.out.println("in role customer");

			userService.addUser(user);
		}
		if (user.getRole().equals("Retailer")) {
			System.out.println("in role retailer");
			Retailer retailer = new Retailer();
			retailer.setCompanyName(userretailer.getCompanyName());
			retailer.setSaleDomain(userretailer.getSaleDomain());
			retailer.setUser(user);

			userService.addUser(user);
			retailerService.addRetailer(retailer);

		}

	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		User userObj = null;
		if (tempEmailId != null && tempPassword != null) {
			userObj = userService.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		if (userObj == null) {
			throw new Exception("bad credentitals");
		}
		return userObj;

	}

	// http://localhost:8090/lifestyle/admin/getAllUsers
	@GetMapping("/admin/getAllUsers")
	public List<User> getAllUsers() {
		List<User> userList = userService.getAllUsers();
		return userList;
	}

	// http://localhost:8090/lifestyle/admin/getUserByUserId/101
	@GetMapping("/admin/getUserByUserId/{id}")
	public User getUserByUserId(@PathVariable(value = "id") int userId) {
		User userObj = userService.getUserByUserId(userId);
		return userObj;
	}

	// http://localhost:8090/lifestyle/admin/getAllCustomers
	@GetMapping("/admin/getAllCustomers")
	public List<User> getAllCustomers() {
		List<User> customerList = userService.getAllCustomers();
		return customerList;
	}

}
