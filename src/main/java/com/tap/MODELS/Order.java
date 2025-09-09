package com.tap.MODELS;

import java.time.LocalDateTime;

public class Order {

	private int orderId;
	private int restaurantId;
	private int userId;
	private LocalDateTime orderDate;
	private double totalAmount;
	private String status;
	private String shippingAddress;
    private String phoneNumber;
	private String paymentMode;
	
	
	
	public Order()
	{
		
	}
	
	
	
	public Order(int orderId, int restaurantId, int userId, LocalDateTime orderDate, double totalAmount, String status,
			String shippingAddress, String phoneNumber, String paymentMode) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.shippingAddress = shippingAddress;
		this.phoneNumber = phoneNumber;
		this.paymentMode = paymentMode;
	}
	
	
	
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate ) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	
	public Order(int orderId, int restarantId, int userId, LocalDateTime orderDate, double totalAmount, String status,
			String paymentMode) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	
	

	public Order(int orderId, int restaurantId, int userId, double totalAmount, String status, String shippingAddress,
			String phoneNumber, String paymentMode) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.shippingAddress = shippingAddress;
		this.phoneNumber = phoneNumber;
		this.paymentMode = paymentMode;
	}



	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", restarantId=" + restaurantId + ", userId=" + userId + ", orderDate="
				+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", shippingAddress="
				+ shippingAddress + ", phoneNumber=" + phoneNumber + ", paymentMode=" + paymentMode + "]";
	}
	
	
	
	
	
	
	
	
}
