package com.tap.MODELS;

public class Menu {
	private int menuId;
	private int restaurentId;
	private String itemName;
	private String description;
	private double price;
	private String isAvilable;
	private int rating;
	private String imagePath;

	public Menu(int menuId, String itemName, String description, double price, String isAvilable, int rating) {
		super();
		this.menuId = menuId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvilable = isAvilable;
		this.rating = rating;

	}
	public Menu()
	{

	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurentId=" + restaurentId + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", isAvilable=" + isAvilable + ", ImagePath=" + imagePath
				+ ", rating=" + rating + "]";
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurentId() {
		return restaurentId;
	}
	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIsAvilable() {
		return isAvilable;
	}
	public void setIsAvilable(String isAvilable) {
		this.isAvilable = isAvilable;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Menu(int menuId, String itemName, String description, double price, String isAvilable, int rating,
			String imagePath) {
		super();
		this.menuId = menuId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvilable = isAvilable;
		this.rating = rating;
		this.imagePath = imagePath;
	}
	public Menu(int menuId, int restaurentId, String itemName, String description, double price, String isAvilable,
			int rating, String imagePath) {
		super();
		this.menuId = menuId;
		this.restaurentId = restaurentId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvilable = isAvilable;
		this.rating = rating;
		this.imagePath = imagePath;
	}
	public Menu(int menuId, int restaurentId, String itemName, String description, double price, String isAvilable,
			int rating) {
		super();
		this.menuId = menuId;
		this.restaurentId = restaurentId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvilable = isAvilable;
		this.rating = rating;
	}

}
