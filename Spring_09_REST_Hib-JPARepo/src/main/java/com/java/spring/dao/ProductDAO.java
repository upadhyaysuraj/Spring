package com.java.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.spring.model.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>
{}
