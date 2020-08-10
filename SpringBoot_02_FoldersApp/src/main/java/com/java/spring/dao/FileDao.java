package com.java.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.spring.model.MyFile;


public interface FileDao extends JpaRepository<MyFile, Integer>
{}
