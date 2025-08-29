package com.tap.DAO;

import java.util.List;
import com.tap.MODELS.OrderItem;

public interface OrderItemDAO {
	
public void AddOrder(OrderItem orderitem);
	
	
	public OrderItem GetOrder(int id);
	
	public int Update(OrderItem orderitem);
	
	public int Delete(int id);
	
	
	public List<OrderItem> GetAll();


}
