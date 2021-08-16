package com.lifestyle.appl.services;

import java.util.List;

import com.lifestyle.appl.beans.User;

public interface UserService {

	public User addUser(User user);
	public User fetchUserByEmailId(String emailId);
	public User fetchUserByEmailIdAndPassword(String email, String password);
	public List<User> getAllUsers();
	public User getUserByUserId(int userId);
	public List<User> getAllCustomers();

}
