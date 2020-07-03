package com.chandra.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.chandra.spring.bean.Product;
@Repository("productDAO")
@Primary
public class ProductDAOImpl extends AbstractDao implements ProductDAO {

	public void saveProduct(Product product) {
		persist(product);
		
	}
	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {
		Criteria criteria = getSession().createCriteria(Product.class);
		return (List<Product>)criteria.list();
	}

	public void updateProduct(Product product) {
		getSession().update(product);
		
	}

	public void deleteProduct(int pid) {
		Query query = getSession().createQuery("delete from Product where pid=:pid");
		query.setInteger("pid", pid);
		query.executeUpdate();
		
	}

	public Product findByProductId(int pid) {
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("pid", pid));
		return (Product)criteria.uniqueResult();
	}

}
