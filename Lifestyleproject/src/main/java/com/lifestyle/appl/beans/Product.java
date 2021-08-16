package com.lifestyle.appl.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "PRODUCTS")
public class Product {
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="HB_PRODUCT_ID_SEQ" )
	@SequenceGenerator(name = "HB_PRODUCT_ID_SEQ",sequenceName = "PRODUCT_ID_SEQ",allocationSize = 1 )
	@Column(name = "PRODUCT_ID")
	@Id
	private int productId;
	@Column(name = "PRODUCT_NAME")
	private String ProductName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "BRAND_NAME")
	private String brandname;
	@Column(name = "PRICE")
	private int price;
	@Column(name = "QUANTITY")
	private int quantity;
	@Column(name ="CATEGORY")
	private String category;
    
	@Column(name = "TARGET_USER")
	private String targetUser;
	
	@Column(name = "IMAGE_URL")
	private String imageUrl;
	
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)  
	@JoinColumn(name = "RETAILER_ID")
	private Retailer retailer;
 
	public Product() {
		super();
	}

	public Product(int productId, String productName, String description, String brandname, int price, int quantity,
			String category, String targetUser, String imageUrl, Retailer retailer) {
		super();
		this.productId = productId;
		ProductName = productName;
		this.description = description;
		this.brandname = brandname;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.targetUser = targetUser;
		this.imageUrl = imageUrl;
		this.retailer = retailer;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", ProductName=" + ProductName + ", description=" + description
				+ ", brandname=" + brandname + ", price=" + price + ", quantity=" + quantity + ", category=" + category
				+ ", targetUser=" + targetUser + ", imageUrl=" + imageUrl + ", retailer=" + retailer + "]";
	}
	
	
}
