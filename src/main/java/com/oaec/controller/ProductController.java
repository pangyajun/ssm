
package com.oaec.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oaec.service.ProductService;

@Controller
public class ProductController {
	
	@Resource
	private ProductService ps;
	
	@SuppressWarnings("unused")
	@RequestMapping("update")
	@ResponseBody
	private void updateProduct(HttpServletResponse response,String key) {
		if("123*%DF45dc".equals(key))
		 ps.updateProduct(response);

	}
	@RequestMapping("show")
	private void show() {
		ps.show();

	}
}
