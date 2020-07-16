package com.java.spring.dao;

import java.util.List;

import com.java.spring.model.Product;

public interface ProductDAO
{
	public Product getProductByID(int id);
	public boolean deleteProduct(int id);
	public boolean updateProduct(Product p, int id);
	public boolean addProduct(Product p);
	public List<Product> getAllProducts();
}
