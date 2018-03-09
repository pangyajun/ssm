package com.oaec.entity;

import java.util.List;

public class SaleConfig {
	private List<Price> listPrice;
	private String moq;
	private List<Spec> listSpec;
	
	public List<Price> getListPrice() {
		return listPrice;
	}
	public void setListPrice(List<Price> listPrice) {
		this.listPrice = listPrice;
	}
	public String getMoq() {
		return moq;
	}
	public void setMoq(String moq) {
		this.moq = moq;
	}
	
	public List<Spec> getListSpec() {
		return listSpec;
	}
	public void setListSpec(List<Spec> listSpec) {
		this.listSpec = listSpec;
	}
	@Override
	public String toString() {
		return "SaleConfig [listPrice=" + listPrice + ", moq=" + moq + ", listSpec=" + listSpec + "]";
	}
	
	
	
}
