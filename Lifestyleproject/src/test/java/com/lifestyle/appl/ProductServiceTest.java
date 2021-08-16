package com.lifestyle.appl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lifestyle.appl.beans.Product;
import com.lifestyle.appl.services.ProductService;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	ProductService productService;

	@Test
	void testProductById() {
     
		int ExpectedproductId=605;
		Product product=productService.getProductById(ExpectedproductId);
		assertEquals(ExpectedproductId, product.getProductId());
		
		
	}
}
