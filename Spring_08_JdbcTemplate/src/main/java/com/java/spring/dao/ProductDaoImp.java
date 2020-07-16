package com.java.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.spring.model.Product;

@Repository
public class ProductDaoImp implements ProductDAO
{
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	private String getProductById = "Select * From PRODUCT where PID=?";
	private String deleteProduct = "Delete From PRODUCT where PID=?";
	private String updateProduct = "Update PRODUCT Set PNAME=?, PRICE=?, QTY=? where PID=?";
	private String addProduct = "Insert into PRODUCT (PNAME, PRICE, QTY) values (?,?,?)";
	private String getAllProducts = "Select * From PRODUCT";

		
	public Product getProductByID(int id)
	{
		Product p = (Product) jdbcTemplate.query(getProductById, new Object[] {id}, new BeanPropertyRowMapper<Product>(Product.class));
		
		return p;
	}

	public boolean deleteProduct(int id)
	{
		return 0 < jdbcTemplate.update(deleteProduct, new Object[] {id});
	}

	public boolean updateProduct(Product p, int id)
	{
		return 0 < jdbcTemplate.update(updateProduct, new Object[] {p.getPNAME(), p.getPRICE(),p.getQTY(), id});

	}

	public boolean addProduct(Product p)
	{
		return 0 < jdbcTemplate.update(addProduct, new Object[] {p.getPNAME(), p.getPRICE(),p.getQTY()});

	}

	public List<Product> getAllProducts()
	{
		List<Product> allProducts = jdbcTemplate.query(getAllProducts, new BeanPropertyRowMapper<Product>(Product.class));
		return allProducts;
	}
	
}
