package com.oaec.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;

public interface ProductService {

	int updateProduct(HttpServletResponse Response);
	public void show();
}
