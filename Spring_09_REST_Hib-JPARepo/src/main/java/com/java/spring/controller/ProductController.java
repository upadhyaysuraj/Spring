package com.java.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping(value="/deleteProduct")
	public boolean deleteProduct(@RequestParam int id)
	{
		return productService.deleteProduct(id);
	}
	
	@PostMapping("/updateProduct")
	public boolean updateProduct(@ModelAttribute Product p)
	{
		return productService.updateProduct(p, p.getPID());
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@PostMapping("/addProduct")
	public boolean addProduct(@ModelAttribute Product p)
	{
		return productService.addProduct(p);
	}
}
