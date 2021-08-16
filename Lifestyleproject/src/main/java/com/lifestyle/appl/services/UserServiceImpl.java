package com.lifestyle.appl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifestyle.appl.beans.User;
import com.lifestyle.appl.dao.RegistrationRepository;
import com.lifestyle.appl.dao.UserDao;


@Service("userService")

public class UserServiceImpl implements UserService{

	@Autowired
	RegistrationRepository repo;
	@Autowired
	private UserDao userDao;

	public User addUser(User user) {

		return repo.save(user);
	}

	public User fetchUserByEmailId(String emailId) {
		return repo.findByEmailId(emailId);
	}

	public User fetchUserByEmailIdAndPassword(String email, String password) {
		return repo.findByEmailIdAndPassword(email, password);
	}
	@Override
	public List<User> getAllUsers() {
		
		return userDao.getAllUsers();
	}

	@Override
	public User getUserByUserId(int userId) {
		
		return userDao.getUserByUserId(userId);
	}

	@Override
	public List<User> getAllCustomers() {
		
		return userDao.getAllCustomers();
	}

    
	
	 
}
