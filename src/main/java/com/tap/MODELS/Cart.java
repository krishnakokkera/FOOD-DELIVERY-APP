package com.tap.MODELS;

import java.util.HashMap;

public class Cart {
	private HashMap<Integer,CartItem>items;


	public Cart()
	{
		this.items=new HashMap<>();

	}
	public HashMap<Integer,CartItem> getItems()
	{
		return items;
	}

	public  void addItemtoCart(CartItem cartItem) 
	{
		//feteching from the cartItem.java

		int itemId=cartItem.getId();
		//check the itemid inside the map

		if(items.containsKey(itemId))
		{

			CartItem existItem=items.get(itemId);


			//if alredy is there increse the quantity of item 


			existItem.setQuantity(existItem.getQuantity()+cartItem.getQuantity());

		}
		else
		{
			items.put(itemId, cartItem);
		}
	}
	public void UpdateItemToCard(int id,int quantity)
	{
		if(items.containsKey(id))
		{
			if(quantity<=0)     //if quanitity less than 0 remove thst item 
			{
				items.remove(id);
			}
			else
			{
				CartItem exist=items.get(id);
				exist.setQuantity(quantity);
			}
		}


	}

	public void removeItemTOCart(int id)
	{
		if(items.containsKey(id))
		{
			items.remove(id);
		}
	}


	// clear the entire cart

	public void clear()
	{
		items.clear();
	}
	
	//get toata amount
	
	public double getSubtotal() {
	    double subtotal = 0.0;
	    for (CartItem item : items.values()) {
	        subtotal += item.getPrice() * item.getQuantity();
	    }
	    return subtotal;
	}



}