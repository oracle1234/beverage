package com.beverage.dto;

public class BeverageDTO {
	private int beverage_id;
	private int cafe_id;
	private int beverage_price;
	private String beverage_type;
	private String beverage_name;
	private String beverage_text;

	public int getBeverage_id() {
		return beverage_id;
	}

	public void setBeverage_id(int beverage_id) {
		this.beverage_id = beverage_id;
	}

	public int getCafe_id() {
		return cafe_id;
	}

	public void setCafe_id(int cafe_id) {
		this.cafe_id = cafe_id;
	}

	public int getBeverage_price() {
		return beverage_price;
	}

	public void setBeverage_price(int beverage_price) {
		this.beverage_price = beverage_price;
	}

	public String getBeverage_type() {
		return beverage_type;
	}

	public void setBeverage_type(String beverage_type) {
		this.beverage_type = beverage_type;
	}

	public String getBeverage_name() {
		return beverage_name;
	}

	public void setBeverage_name(String beverage_name) {
		this.beverage_name = beverage_name;
	}

	public String getBeverage_text() {
		return beverage_text;
	}

	public void setBeverage_text(String beverage_text) {
		this.beverage_text = beverage_text;
	}

}
