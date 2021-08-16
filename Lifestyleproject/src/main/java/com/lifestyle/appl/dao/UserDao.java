package com.lifestyle.appl.dao;

import java.util.List;

import com.lifestyle.appl.beans.User;

public interface UserDao {
	
	public List<User> getAllUsers();
	public User getUserByUserId(int userId);
	public List<User> getAllCustomers();

}
