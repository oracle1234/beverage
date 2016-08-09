package com.beverage.dto;

public class PreferenceDTO {
	// 음료 id
	private int beverage_id;
	// 음료 평가 점수
	private int preference_level;
	// 음료 평가글
	private String beverage_review;

	public int getBeverage_id() {
		return beverage_id;
	}

	public void setBeverage_id(int beverage_id) {
		this.beverage_id = beverage_id;
	}

	public int getPreference_level() {
		return preference_level;
	}

	public void setPreference_level(int preference_level) {
		this.preference_level = preference_level;
	}

	public String getBeverage_review() {
		return beverage_review;
	}

	public void setBeverage_review(String beverage_review) {
		this.beverage_review = beverage_review;
	}

}
