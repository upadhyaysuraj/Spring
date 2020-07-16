package com.java.spring.service;

import java.util.List;
import com.java.spring.model.Product;

public interface ProductService
{
	public Product getProductByID(int id);
	public boolean deleteProduct(int id);
	public boolean updateProduct(Product p, int id);
	public boolean addProduct(Product p);
	public List<Product> getAllProducts();
}
