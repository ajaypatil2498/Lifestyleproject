package com.lifestyle.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.lifestyle.appl.beans.Retailer;



@Repository("retailerDao")
@EnableTransactionManagement
public class RetailerDaoImpl implements RetailerDao
{
	@PersistenceContext
	EntityManager em;
	

	@Override
    @Transactional
	public void addRetailer(Retailer retailer) {
	em.persist(retailer);
		
	}
	@Override
	@Transactional
	
	public List<Retailer> getAllRetailers() {
		System.out.println("entered dao");
		TypedQuery<Retailer> tqry = em.createQuery("SELECT r FROM Retailer r", Retailer.class);
		List<Retailer> retailerList = tqry.getResultList();
		return retailerList;
	}

	@Override
	@Transactional
	public Retailer removeRetailer(int retailerId) {
		Retailer retailerObj = em.find(Retailer.class, retailerId);
		em.remove(retailerObj);
		return retailerObj;
	}
	
	
	
	@Override
	@Transactional
	public String approveRetailer(int retailerId)
	{
		String sql="UPDATE Retailer r SET r.isApproved=1 WHERE r.retailerId= :Id";
		Query qry = em.createQuery(sql);
		qry.setParameter("Id", retailerId);
		qry.executeUpdate();
		return "Retailer with Id: "+retailerId+" is approved";
	}

	@Override
	@Transactional
	public Retailer getRetailerById(int retailerId) {
		Retailer retailerObj = em.find(Retailer.class, retailerId);
		return retailerObj;
	}
	@Override
	@Transactional
	public int getRetailerIdFromUserId(int userId) {
	    
		Query qry=em.createQuery("select r.retailerId from Retailer r where r.user.userId= :userId");
		qry.setParameter("userId", userId);
		int retailterid=(int)qry.getSingleResult();
		return retailterid;
	}
	


}
