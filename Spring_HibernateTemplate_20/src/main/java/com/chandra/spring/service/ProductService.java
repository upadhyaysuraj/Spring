package com.chandra.spring.service;

import java.util.List;

import com.chandra.spring.bean.Product;

public interface ProductService {
	void saveProduct(Product product);

	List<Product> findAllProducts();

	void updateProduct(Product product);

	void deleteProduct(int pid);

	Product findByProductId(int pid);
}
