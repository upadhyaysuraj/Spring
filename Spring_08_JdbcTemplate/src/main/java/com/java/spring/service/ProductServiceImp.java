package com.java.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.java.spring.dao.ProductDAO;
import com.java.spring.model.Product;

@Service
@Qualifier("productService")
public class ProductServiceImp implements ProductService
{
	@Autowired
	private ProductDAO productDao;
	
	public Product getProductByID(int id)
	{
		return productDao.getProductByID(id);
	}

	public boolean deleteProduct(int id)
	{
		return productDao.deleteProduct(id);
	}

	public boolean updateProduct(Product p, int id)
	{
		return productDao.updateProduct(p, id);
	}

	public boolean addProduct(Product p)
	{
		return productDao.addProduct(p);
	}

	public List<Product> getAllProducts()
	{
		return productDao.getAllProducts();
	}

}
