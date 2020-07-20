package com.java.spring.service;

import java.util.List;
import java.util.Optional;

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
		return productDao.findById(id).orElse(null);
	}

	public boolean deleteProduct(int id)
	{
		if(productDao.findById(id).orElse(null) != null)
		{
			productDao.deleteById(id);
			return true;
		}
		return false;
	}

	public boolean updateProduct(Product p, int id)
	{
		Product _p = productDao.findById(id).orElse(null);
		if(_p != null)
		{
			_p.setPNAME(p.getPNAME());
			_p.setPRICE(p.getPRICE());
			_p.setQTY(p.getQTY());
			productDao.save(_p);
			return true;
		}
		return false;
	}

	public boolean addProduct(Product p)
	{
		if(p != null && productDao.findById(p.getPID()).orElse(null) == null)
		{
			productDao.save(p);
			return true;
		}
		return false;
	}

	public List<Product> getAllProducts()
	{
		return productDao.findAll();
	}

}
