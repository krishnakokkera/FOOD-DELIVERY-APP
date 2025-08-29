package com.tap.DAO;

import java.util.List;

import com.tap.MODELS.Order;



public interface OrderDAO {
	
   public  int AddOrder(Order order);
	
	
	public Order GetOrder(int id);
	
	public int Update(Order order);
	
	public int Delete(int id);
	
	
	public List<Order> GetAll();
	public List<Order> getOrdersByUserId(int userId);




}
