package com.lifestyle.appl.dao;

import java.util.List;

import com.lifestyle.appl.beans.Product;

public interface ProductDao {
	public List<Product> getProductByCategoryAndTargetUser(String category, String targetUser);

	public List<Product> getAllProducts();

	public Product getProductById(int productId);

	public int saveProduct(Product prd);

	public abstract List<Product> displayAll();

	public Product updateProduct(int productId, int price, int quantity);

	public Product delProduct(int productId);

	public List<Product> getPrdByRetId(int retailer);
}
