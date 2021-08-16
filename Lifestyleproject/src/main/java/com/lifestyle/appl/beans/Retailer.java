
package com.lifestyle.appl.beans;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name = "RETAILERS")
public class Retailer {
	
	@Id
	@Column(name = "RETAILER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_RETAILER_ID_SEQ") 
	@SequenceGenerator(name="HB_RETAILER_ID_SEQ" , sequenceName="RETAILER_ID_SEQ", allocationSize = 1)
	private int retailerId;
	@Column(name = "COMPANY_NAME")
	private String companyName;
	@Column(name = "SALE_DOMAIN")
	private String saleDomain;
	@OneToOne
	@JoinColumn(name = "USER_ID")
	
	private User user;
	@Column(name = "IS_APPROVED")
	private int isApproved;

	
	public Retailer() {
		super();
	}


	public Retailer(int retailerId, String companyName, String saleDomain, User user, int isApproved) {
		super();
		this.retailerId = retailerId;
		this.companyName = companyName;
		this.saleDomain = saleDomain;
		this.user = user;
		this.isApproved = isApproved;
	}


	public int getRetailerId() {
		return retailerId;
	}


	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getSaleDomain() {
		return saleDomain;
	}


	public void setSaleDomain(String saleDomain) {
		this.saleDomain = saleDomain;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getIsApproved() {
		return isApproved;
	}


	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}




	@Override
	public String toString() {
		return "Retailer [retailerId=" + retailerId + ", companyName=" + companyName + ", saleDomain=" + saleDomain
				+ ", user=" + user + ", isApproved=" + isApproved + "]";
	}
	
	
	
	
	
	

	

}
