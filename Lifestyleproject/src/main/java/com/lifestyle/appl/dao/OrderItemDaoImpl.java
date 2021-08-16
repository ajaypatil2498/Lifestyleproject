package com.lifestyle.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.lifestyle.appl.beans.OrderItem;

@Repository
@EnableTransactionManagement
public class OrderItemDaoImpl implements OrderItemDao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void addOrderItem(OrderItem orderitem) {
		em.persist(orderitem);

	}

	@Override
	@Transactional
	public List<OrderItem> getOrderItemByOrderId(int orderId) {
		TypedQuery<OrderItem> qry = em.createQuery("select o from OrderItem o where o.order.orderId= :orderId",
				OrderItem.class);
		qry.setParameter("orderId", orderId);
		List<OrderItem> orderitems = qry.getResultList();
		return orderitems;
	}

}
