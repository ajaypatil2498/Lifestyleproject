package com.lifestyle.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lifestyle.appl.beans.Product;

@Repository("productDao")
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public List<Product> getProductByCategoryAndTargetUser(String category, String targetUser) {

		TypedQuery<Product> q = em.createQuery(
				"SELECT p FROM Product p WHERE p.category= :category and p.targetUser= :targetUser", Product.class);
		q.setParameter("category", category);
		q.setParameter("targetUser", targetUser);
		List<Product> prdlist = q.getResultList();
		return prdlist;
	}

	@Override
	public List<Product> getAllProducts() {
		TypedQuery<Product> tqry = em.createQuery("SELECT p FROM Product p", Product.class);
		List<Product> productList = tqry.getResultList();
		return productList;
	}

	@Override
	public Product getProductById(int productId) {
		Product productObj = em.find(Product.class, productId);
		return productObj;
	}

	@Override
	@Transactional
	public int saveProduct(Product prd) {
		System.out.println("Dao Layer" + prd);
		em.persist(prd);
		return 0;
	}

	@Override
	public List<Product> displayAll() {
		System.out.println("Inside DaoImpl");
		TypedQuery<Product> qry = em.createQuery("SELECT p FROM Product p", Product.class);
		List<Product> prdList = qry.getResultList();
		return prdList;
	}

	@Override
	@Transactional
	public Product updateProduct(int productId, int price, int quantity) {
//		Product prd=em.find(Product.class,productId);
		Query tq = em.createQuery(
				"UPDATE  Product p SET p.price= :price , p.quantity= :quantity  WHERE p.productId= :productId");
		tq.setParameter("productId", productId);
		tq.setParameter("price", price);
		tq.setParameter("quantity", quantity);
		tq.executeUpdate();
		return em.find(Product.class, productId);
	}

	@Override
	@Transactional
	public Product delProduct(int productId) {
		Product p = em.find(Product.class, productId);
		em.remove(p);
		return null;
	}

	@Override
	public List<Product> getPrdByRetId(int retailer) {
		System.out.println("inside dao");
		TypedQuery<Product> qry = em.createQuery("SELECT p FROM Product p WHERE p.retailer.retailerId= :retailerId",
				Product.class);
		qry.setParameter("retailerId", retailer);
		List<Product> prdList = qry.getResultList();
		// System.out.println(prdList);
		return prdList;

	}
}
