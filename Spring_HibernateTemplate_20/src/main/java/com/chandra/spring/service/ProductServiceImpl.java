package com.chandra.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandra.spring.bean.Product;
import com.chandra.spring.dao.ProductDAO;
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO dao;

	public void saveProduct(Product product) {
		dao.saveProduct(product);
		
	}

	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return dao.findAllProducts();
	}

	public void updateProduct(Product product) {
		dao.updateProduct(product);
		
	}

	public void deleteProduct(int pid) {
		dao.deleteProduct(pid);
		
	}

	public Product findByProductId(int pid) {
		// TODO Auto-generated method stub
		return dao.findByProductId(pid);
	}

}
