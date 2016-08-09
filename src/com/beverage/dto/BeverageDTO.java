package com.beverage.dto;

import java.util.HashMap;

public class BeverageDTO {
	// 음료번호
	private int beverage_id;
	// 카페번호
	private int cafe_id;
	// 음료 가격
	private int beverage_price;
	// 음료 구분
	private String beverage_type;
	// 음료 이름
	private String beverage_name;
	// 음료 상세설명
	private String beverage_text;
	// 키값으로 카페명을 가지고오도록
	private HashMap<Integer, String> cafe_map;

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

	public HashMap<Integer, String> getCafe_map() {
		return cafe_map;
	}

	public void setCafe_map(HashMap<Integer, String> cafe_map) {
		this.cafe_map = cafe_map;
	}

}
