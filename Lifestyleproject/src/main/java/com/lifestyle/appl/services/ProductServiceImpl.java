package com.lifestyle.appl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifestyle.appl.beans.Product;
import com.lifestyle.appl.dao.ProductDaoImpl;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDaoImpl productDao;

	@Override
	public List<Product> getProductByCategoryAndTargetUser(String category, String targetUser) {
		return productDao.getProductByCategoryAndTargetUser(category, targetUser);

	}

	@Override
	public List<Product> getAllProducts() {

		return productDao.getAllProducts();
	}

	@Override
	public Product getProductById(int productId) {

		return productDao.getProductById(productId);
	}

	public List<Product> displayAll() {
		System.out.println("Inside ServiceImpl");
		return productDao.displayAll();
	}

	public int saveProduct(Product prd) {
		System.out.println("Service Layer");
		productDao.saveProduct(prd);
		return 0;
	}

	public Product delProduct(int productId) {
		productDao.delProduct(productId);
		return null;
	}

	@Override
	public Product updateProduct(int productId, int price, int quantity) {
		productDao.updateProduct(productId, price, quantity);
		return null;
	}

	@Override
	public List<Product> getPrdByRetId(int retailer) {
		System.out.println("inside service");
		return productDao.getPrdByRetId(retailer);
	}

}
