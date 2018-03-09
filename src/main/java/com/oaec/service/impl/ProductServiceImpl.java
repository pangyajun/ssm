package com.oaec.service.impl;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oaec.dao.ProductDao;
import com.oaec.entity.Price;
import com.oaec.entity.Product;
import com.oaec.service.ProductService;
import com.utils.json.JesonUtils;

@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductDao productDao;
	
	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	@Transactional
	public int updateProduct(HttpServletResponse response)  {
		int rows=8586;
		int count=0;
		int a=0;
		for (int i = 0; i < 50; i++) {
			a++;
			Product product = productDao.getConfig(i);
			if ("".equals(product.getWholesale_config()))continue; 		
			String wholesale_config = product.getWholesale_config();
			//System.out.println(wholesale_config);
			Map<Object, Object> jsonToMap = JesonUtils.jsonToMap(wholesale_config);		
			Object priceJsonStr =  jsonToMap.get("price");				
			if (priceJsonStr==null)continue;			
			int moq =  (int) jsonToMap.get("moq");
			List<Price> jsonToList = (List<Price>) JesonUtils.jsonToList(priceJsonStr.toString(),Price.class);
			List<Price> priceList=new ArrayList<>();		
			for (Price price : jsonToList) {
				price.setBonus_percent(5);
				price.setSell_price(Double.valueOf(new DecimalFormat("0.00").format(price.getOrigin_price()*1.05)));
				priceList.add(price);				
			}
			if (moq>1) {
				product.setIs_show(0);
			}else {
				product.setIs_show(1);	
			}
			System.out.println(JesonUtils.ObjectToJson(priceList));
			HashMap<Object, Object> hashMap = new HashMap<>();
			hashMap.put("price", priceList);
			hashMap.put("moq",moq);
			String mapToJson = JesonUtils.ObjectToJson(hashMap);
			product.setWholesale_config(mapToJson);				
			//count+= productDao.setConfig(product);
			
			//System.out.println(product);
		}
		return count;
	}
	
	
	public void show() {
		int rows=8586;
		int count=0;
		for (int i = 0; i < rows-1; i++) {
			Product product = productDao.getConfig(i);
			if ("".equals(product.getWholesale_config()))continue;
			String wholesale_config = product.getWholesale_config();
			Map<Object, Object> jsonToMap = JesonUtils.jsonToMap(wholesale_config);		
			int moq = (int) jsonToMap.get("moq");
			if (moq>1) {
				product.setIs_show(0);				
			}else {
				product.setIs_show(1);
			}	
			System.out.println(product);
			//count+= productDao.setConfig(product);
		}
	}
}
