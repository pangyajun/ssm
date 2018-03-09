package com.oaec.entity;

public class Product {
	
	private String product_id;
	private String wholesale_config;
	private Integer is_show;
	
	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getWholesale_config() {
		return wholesale_config;
	}

	public void setWholesale_config(String wholesale_config) {
		this.wholesale_config = wholesale_config;
	}

	public Integer getIs_show() {
		return is_show;
	}

	public void setIs_show(Integer is_show) {
		this.is_show = is_show;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", wholesale_config=" + wholesale_config + ", is_show=" + is_show
				+ "]";
	}
	

	
	
	
}
