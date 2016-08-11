package com.beverage.dto;

public class ReviewDTO {

	private String member_id;
	private String beverage_review;
	private int review_levle;

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getBeverage_review() {
		return beverage_review;
	}

	public void setBeverage_review(String beverage_review) {
		this.beverage_review = beverage_review;
	}

	public int getReview_levle() {
		return review_levle;
	}

	public void setReview_levle(int review_levle) {
		this.review_levle = review_levle;
	}

}
