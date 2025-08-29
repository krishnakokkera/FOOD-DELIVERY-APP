package com.tap.DAO;

import java.util.List;

import com.tap.MODELS.Restaurent;

public interface RestaurentDAO {
	void addRestaurent(Restaurent resstaurent);
	
	 void deletRestaurent(int id);
	
	
	 Restaurent getRestaurent(int id);
	 
	 
	  void update(Restaurent resstaurent);
	  
	  
	   List<Restaurent>getAllRestaurent();
	   
	   

}
