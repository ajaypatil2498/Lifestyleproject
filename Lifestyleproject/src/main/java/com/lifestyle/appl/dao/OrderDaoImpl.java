package com.lifestyle.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lifestyle.appl.beans.Order;

@Repository("order")
@EnableTransactionManagement
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void addOrder(Order order) {

		em.persist(order);

	}

	@Override
	public List<Order> viewOrder() {
		System.out.println("Inside OrderDaoImpl");
		TypedQuery<Order> qry = em.createQuery("SELECT o FROM Order o", Order.class);
		List<Order> ordList = qry.getResultList();
		return ordList;

	}
	public List<Order> getOrdersByUser(int userId)
	{
		TypedQuery<Order> qry=em.createQuery("select o from Order o where o.user.userId= :userId",Order.class);
		qry.setParameter("userId", userId);
		List<Order> orders= qry.getResultList();
		return orders;
	}
}
