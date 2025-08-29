package com.tap.DAO.imples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.MenuDAO;
import com.tap.DbConnection.DBConnection;
import com.tap.MODELS.Menu;

public class MenuImpl implements MenuDAO {
	
	String INSERT="insert into `menu`(`menuId`,`restaurentId`,`itemName`,`description`,`price`,`isAvilable`,`rating`)values(?,?,?,?,?,?,?)";
    String SELECT="select * from `menu` where `menuId`=?";
    String UPDATE="update `menu` set `itemName`=?,`price`=?,`description`=? where `menuId`=?";
    String SELECTALL="select * from `menu`";
    String DELETE="delete from `menu` where `menuId`=?";
    String getMenu="select `menuId`,`itemName`,`description`,`price`,`isAvilable`,`rating`,`imagePath` from menu where `restaurentId`=?";
	@Override
	public void AddMenu(Menu menu)  {
		
		
		try(Connection con=DBConnection.getConnections();
				 PreparedStatement pstmt=con.prepareStatement(INSERT);){
		
		
		
		pstmt.setInt(1, menu.getMenuId());
		pstmt.setInt(2, menu.getRestaurentId());
		pstmt.setString(3, menu.getItemName());
	    pstmt.setString(4, menu.getDescription());
		pstmt.setDouble(5, menu.getPrice());
		pstmt.setString(6, menu.getIsAvilable());
	    pstmt.setInt(7, menu.getRating());
	    
	    int res = pstmt.executeUpdate();
	    System.out.print(res);
				
				
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		

		
	}

	@Override
	public Menu GetMenu(int id) {
		Menu m=null;
		try(Connection con=DBConnection.getConnections();
				 PreparedStatement pstmt=con.prepareStatement(SELECT);){
			
			
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			while(res.next())
			{
				int menuid=res.getInt("menuId");
				int resId=res.getInt("restaurentId");
				String itemName=res.getString("itemName");
				String description=res.getString("description");
				double price=res.getDouble("price");
				String isavilble=res.getString("isAvilable");
				int rating =res.getInt("rating");
				String imagePath=res.getString("imagePath");
				
				
				 m=new Menu(menuid,resId,itemName,description,price,isavilble, rating,imagePath);
				
			}
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public int  Update(Menu menu) {
		int res=0;
		try(Connection con=DBConnection.getConnections();
				 PreparedStatement pstmt=con.prepareStatement(UPDATE);){
			
			
			 pstmt.setString(1,menu.getItemName());
			 pstmt.setDouble(2,menu.getPrice());
			 pstmt.setString(3, menu.getDescription());
			 pstmt.setInt(4, menu.getMenuId());
			 
			 res=pstmt.executeUpdate();
			 
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	return res;
		
	}

	@Override
	public int  Delete(int id) {
		int res=0;
		try(Connection con=DBConnection.getConnections();
				 PreparedStatement pstmt=con.prepareStatement(DELETE);){
			
			
			pstmt.setInt(1, id);
			 res=pstmt.executeUpdate();
			
			
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		return res;
	}

	@Override
	public List<Menu> GetAll() {
		Menu m=null;
		List<Menu> list=new ArrayList<Menu>();
		try(Connection con=DBConnection.getConnections();
				 PreparedStatement pstmt=con.prepareStatement(SELECTALL);){
			
		ResultSet res= pstmt.executeQuery();
			while(res.next())
			{
				int menuid=res.getInt("menuId");
				int resId=res.getInt("restaurentId");
				String itemName=res.getString("itemName");
				String description=res.getString("description");
				double price=res.getDouble("price");
				String isavilble=res.getString("isAvilable");
				int rating =res.getInt("rating");
				String imagePath=res.getString("imagePath");
				
				
				 m=new Menu(menuid,resId,itemName,description,price,isavilble, rating,imagePath);
			list.add(m);
			
		}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		
	
		return list;
	}

	@Override
	public List<Menu> getAllMenuwithRestaurentid(int restaurentId) {
		Menu m=null;
		List<Menu> list=new ArrayList<Menu>();
	
		try(Connection con=DBConnection.getConnections();
				 PreparedStatement pstmt=con.prepareStatement(getMenu);){
			pstmt.setInt(1,restaurentId);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next())
			{
				int menuid=res.getInt("menuId");
				String itemName=res.getString("itemName");
				String description=res.getString("description");
				double price=res.getDouble("price");
				String isavilble=res.getString("isAvilable");
				int rating =res.getInt("rating");
				String imagePath=res.getString("imagePath");
				
				m=new Menu(menuid,itemName,description,price,isavilble, rating,imagePath);
			
			
		
			list.add(m);
			}
			
			
			
	}
		catch(SQLException e)
		{
			e.printStackTrace();
			
			
		}

		return list;
	
}

	


}
