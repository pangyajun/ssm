package com.oaec.dao;

import org.springframework.stereotype.Repository;

import com.oaec.entity.Product;

@Repository
public interface ProductDao {

	Product getConfig(Integer rows);
	int setConfig(Product product);
}
