package com.beverage.dto;

public class FavorDTO {
	// 회원 번호
	private int member_num;
	// 음료 id
	private int beverage_id;
	// 카페 이름
	private String cafe_name;
	// 음료 이름
	private String beverage_name;

	public int getMember_num() {
		return member_num;
	}

	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}

	public int getBeverage_id() {
		return beverage_id;
	}

	public void setBeverage_id(int beverage_id) {
		this.beverage_id = beverage_id;
	}

	public String getCafe_name() {
		return cafe_name;
	}

	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}

	public String getBeverage_name() {
		return beverage_name;
	}

	public void setBeverage_name(String beverage_name) {
		this.beverage_name = beverage_name;
	}

}
