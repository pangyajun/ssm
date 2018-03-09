package com.oaec.entity;

public class Price {
	
	private Integer min_number;
	private Integer max_number;
	private double sell_price;
	private int bonus_percent;
	private double origin_price;

	
	public Integer getMin_number() {
		return min_number;
	}

	public void setMin_number(Integer min_number) {
		this.min_number = min_number;
	}

	public Integer getMax_number() {
		return max_number;
	}

	public void setMax_number(Integer max_number) {
		this.max_number = max_number;
	}

	public double getSell_price() {
		return sell_price;
	}

	public void setSell_price(double sell_price) {
		this.sell_price = sell_price;
	}

	public int getBonus_percent() {
		return bonus_percent;
	}

	public void setBonus_percent(int bonus_percent) {
		this.bonus_percent = bonus_percent;
	}

	public  double getOrigin_price() {
		return origin_price;
	}

	public void setOrigin_price(double origin_price) {
		this.origin_price = origin_price;
	}

	public Price() {
		super();
	}

	public Price(Integer min_number, Integer max_number, double sell_price, int bonus_percent, double origin_price) {
		super();
		this.min_number = min_number;
		this.max_number = max_number;
		this.sell_price = sell_price;
		this.bonus_percent = bonus_percent;
		this.origin_price = origin_price;
	}

	@Override
	public String toString() {
		return "Price [min_number=" + min_number + ", max_number=" + max_number + ", sell_price=" + sell_price
				+ ", bonus_percent=" + bonus_percent + ", origin_price=" + origin_price + "]";
	}
	
}
