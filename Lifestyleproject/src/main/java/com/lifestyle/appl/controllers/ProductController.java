package com.lifestyle.appl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifestyle.appl.beans.Product;
import com.lifestyle.appl.services.ProductService;


@CrossOrigin(origins = "*")
@RestController // (@controller +@responseBody
@RequestMapping("/lifestyle")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/product")
	public List<Product> getProductByCategoryAndTargetUser(@RequestBody Product product)
	
	{
		 String category=product.getCategory();
		 String targetUser=product.getTargetUser();
		return productService.getProductByCategoryAndTargetUser(category,targetUser);
	}
	@GetMapping("/allproducts")
	public List<Product> getAllProducts()
	{
		List<Product> productList = productService.getAllProducts();
		return productList;
	}
	//http://localhost:8090/lifestyle/productdetails/602
		@GetMapping("/productdetails/{id}")
		public Product getProductById(@PathVariable(value = "id") int productId)
		{
			Product productObj = productService.getProductById(productId);
			return productObj;
		}
		
		//http://localhost:8090/api/lifestyle/addnewprod
		
		@PostMapping("/addnewprod") // approve=1 then add product
		public int saveProduct(@RequestBody Product prd)
		{
			productService.saveProduct(prd);
			return 0;
			
		}
		
		//http://localhost:8090/api/lifestyle/updateprd/601/3000/3
//		@GetMapping("/updateprd/{productId}/{price}/{quantity}")
//		private Product update(@PathVariable (value= "productId") int productId,@PathVariable (value= "price") int price,@PathVariable (value= "quantity") int quantity)   
//		{  
//			
//		Product ProductObj=ProductService.updateProduct(productId, price,quantity) ;
//		return ProductObj;  
//		}  
		
		@PostMapping("/updateprd")
		private Product update(@RequestBody Product product)   
		{  
		int productId=product.getProductId();
		int price=product.getPrice();
		int quantity=product.getQuantity();
		Product ProductObj=productService.updateProduct( productId, price,quantity) ;
		return ProductObj;  
		}  
		
		//http://localhost:8090/api/lifestyle/deleteprod
//		@PostMapping("/deleteprod/{productId}")
//		public int delProduct(@PathVariable int productId) {
//			ProductService.delProduct(productId);
//			return 0;
//		}
		
		@PostMapping("/deleteprd")
		private Product delProduct(@RequestBody Product product)   
		{  
		int productId=product.getProductId();
		
		Product ProductObj1=productService.delProduct(productId);
		return ProductObj1;  
		}  
		
		@GetMapping("/products/{id}")
		public List<Product> getPrdByRetId(@PathVariable(value="id")int retailer)
		{
			System.out.println("inside controller");
			return productService.getPrdByRetId(retailer);
		}	
	
}
