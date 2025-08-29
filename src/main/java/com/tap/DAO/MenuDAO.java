package com.tap.DAO;

import java.util.List;

import com.tap.MODELS.Menu;

public interface MenuDAO {
	
	
	public void AddMenu(Menu menu);
	
	
	public Menu GetMenu(int id);
	
	public int Update(Menu menu);
	
	public int Delete(int id);
	
	
	public List<Menu> GetAll();
	
	
	public List<Menu> getAllMenuwithRestaurentid(int restaurentId);

}
