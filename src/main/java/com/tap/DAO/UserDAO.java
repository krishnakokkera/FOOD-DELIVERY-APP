package com.tap.DAO;

import java.util.List;

import com.tap.MODELS.User;

public interface UserDAO {
	
	int  addUser(User user);
	
	
	int updateUser(User user);
	
	
	int deleteUser(int id);
	
	
	User getUser(int id);
	
	
    List<User> getAll();
    
    User getUserPassWordWithName(String name);

}
