package com.lifestyle.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lifestyle.appl.beans.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<User> getAllUsers() {
		
		TypedQuery<User> tqry = em.createQuery("SELECt u FROM User u", User.class);
		List<User> userList = tqry.getResultList();
		return userList;
	}

	@Override
	public User getUserByUserId(int userId) {
		User userObj = em.find(User.class, userId);
		return userObj;
	}

	@Override
	public List<User> getAllCustomers() {
		TypedQuery<User> tqry = em.createQuery("SELECt u FROM User u WHERE u.role='Customer'", User.class);
		List<User> customerList = tqry.getResultList();
		return customerList;
	}

}

