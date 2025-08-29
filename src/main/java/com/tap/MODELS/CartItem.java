package com.tap.MODELS;

public class CartItem {
private int Id;
private String name;
private int restaurantId;
private int quantity;
private double Price;


public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getRestaurantId() {
	return restaurantId;
}
public void setRestaurantId(int restaurantId) {
	this.restaurantId = restaurantId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}
public CartItem(int id, String name, int restaurantId, int quantity, double price) {
	super();
	Id = id;
	this.name = name;
	this.restaurantId = restaurantId;
	this.quantity = quantity;
	Price = price;
}
public CartItem() {
	// TODO Auto-generated constructor stub
}






}
