package com.lifestyle.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lifestyle.appl.beans.CartItem;

@Repository
@EnableTransactionManagement
public class CartItemDaoImpl implements CartItemDao {
	@PersistenceContext
	EntityManager em;

	@Transactional
	public List<CartItem> getAllCartItemsByUserId(int userId) {
		String getCart = "SELECT c From CartItem c where c.userId= :userId";
		TypedQuery<CartItem> tq = em.createQuery(getCart, CartItem.class);
		tq.setParameter("userId", userId);
		List<CartItem> cartList = tq.getResultList();
		System.out.println(cartList);
		return cartList;
	}

	@Transactional
	public void addCartItem(CartItem cartItem) {
		em.persist(cartItem);
	}

	@Override
	@Transactional
	public void deleteCartItem(CartItem cartItem) {
		//em.remove(cartItem);
		em.remove(em.contains(cartItem) ? cartItem : em.merge(cartItem));
		
	}
	@Transactional
	public void decrementQuantity(CartItem cartItem) {
		if(cartItem.getQuantity()>1)
		{
		cartItem.setQuantity(cartItem.getQuantity()-1);
		cartItem.setTotal(cartItem.getTotal()-cartItem.getUnitPrice());
		em.merge(cartItem);
		}
		
	}
	@Transactional
	public void incrementQuantity(CartItem cartItem) {
		cartItem.setQuantity(cartItem.getQuantity()+1);
		cartItem.setTotal(cartItem.getTotal()+cartItem.getUnitPrice());
		em.merge(cartItem);
		
	}

	@Override
	@Transactional
	public void delteCartItemByUserId(int userId) {
		Query qry = em.createQuery("DELETE FROM  CartItem c where c.userId= :userId");
		qry.setParameter("userId", userId);
		qry.executeUpdate();
		
		
	}
}
