package com.tap.MODELS;

public class Restaurent {
	private int  restaurentId;
	private  String name;
	private String address;
	private String phoneNumber;
	private String cuisineType;
	private String deliveryTime;
	private int adminUserId;
	private float rating;
	private String isActive;
	private String ImagePath;

	public int getRestaurentId() {
		return restaurentId;
	}
	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public int getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public String getImagePath() {
		return ImagePath;
	}
	public void setImagePath(String ImagePath) {
		this.ImagePath=ImagePath;
	}


	@Override
	public String toString() {
		return "Restaurent [restaurentId=" + restaurentId + ", name=" + name + ", adminUserId=" + adminUserId
				+ ", rating=" + rating + ", isActive=" + isActive + "]";
	}
	public Restaurent(int restaurentId, String name, String address, String phoneNumber, String cuisineType,
			String deliveryTime, int adminUserId,float rating, String isActive) {
		super();
		this.restaurentId = restaurentId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
	}
	public Restaurent(int restaurentId, String name, String address, String phoneNumber, String cuisineType,
			String deliveryTime, int adminUserId, float rating, String isActive, String imagePath) {
		super();
		this.restaurentId = restaurentId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		ImagePath = imagePath;
	}


}
