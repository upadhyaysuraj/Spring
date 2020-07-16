package com.java.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.java.spring.model.Product;
import com.java.spring.service.ProductService;

@RestController
public class ProductController
{
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getProduct/{id}")
	public Product getProduct(@PathVariable int id)
	{
		Product p = productService.getProductByID(id);
		return p;
	}
}
