package com.tap.DAO.imples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.RestaurentDAO;
import com.tap.DbConnection.DBConnection;
import com.tap.MODELS.Restaurent;

public class RestaurentImpl implements RestaurentDAO{
	 
	String INSERT="insert into `restaurent`(`restaurentId`,`name`,`address`,`phoneNumber`,`cuisineType`,`deliveryTime`,`adminUserId`,`rating`,`isActive`) values(?,?,?,?,?,?,?,?,?)";
	String SELECT="select * from `restaurent` where `restaurentId`=? ";
	String UPDATE="update `restaurent` set `name`=?,`address`=?,`cuisineType`=? where `restaurentId`=?";
	String SELECTALL="select * from `restaurent`";

	@Override
	public void addRestaurent(Restaurent resstaurent) {
		try(Connection con=DBConnection.getConnections();
				PreparedStatement pstmt=con.prepareStatement(INSERT);)
		{
		       
		
		pstmt.setInt(1,resstaurent.getRestaurentId());
		pstmt.setString(2, resstaurent.getName());
		pstmt.setString(3, resstaurent.getAddress());
		pstmt.setString(4, resstaurent.getPhoneNumber());
		pstmt.setString(5, resstaurent.getCuisineType());
		pstmt.setString(6, resstaurent.getDeliveryTime());
		pstmt.setInt(7,resstaurent.getAdminUserId());
		pstmt.setFloat(8,resstaurent.getRating());
		pstmt.setString(9, resstaurent.getIsActive());
		
		
		int res= pstmt.executeUpdate();
		System.out.print(res);
		
		
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	
		
	}


	@Override
	public void deletRestaurent(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Restaurent getRestaurent(int id) {
		Restaurent r=null;
		try(Connection con=DBConnection.getConnections();
				PreparedStatement pstmt=con.prepareStatement(SELECT);)
		{
			
			pstmt.setInt(1,id);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next())
			{
				int resid=res.getInt("restaurentId");
				String name=res.getString("name");
				String address=res.getString("address");
				String phonenumber=res.getString("phoneNumber");
				String cuisinetype=res.getString("cuisineType");
				String deliveryTime=res.getString("deliveryTime");
				int adminUserId=res.getInt("adminUserId");
				float rating=res.getFloat("rating");
				String isactive=res.getString("isActive");
				String ImagePath=res.getString("ImagePath");
				
			r= new Restaurent(resid,name,address,phonenumber,cuisinetype,deliveryTime,adminUserId,rating,isactive,ImagePath);
						
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			
		return r;
	}
	

	@Override
	public void update(Restaurent resstaurent) {
		// TODO Auto-generated method stub
		try(Connection con=DBConnection.getConnections();
				PreparedStatement pstmt=con.prepareStatement(UPDATE);)
		{
		
		pstmt.setString(1, resstaurent.getName());
		pstmt.setString(2, resstaurent.getAddress());
		pstmt.setString(3, resstaurent.getCuisineType());
		pstmt.setInt(4,resstaurent.getRestaurentId());
		
		int res = pstmt.executeUpdate();
		System.out.print(res);
		
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurent> getAllRestaurent() {
		Restaurent r=null;
		List<Restaurent> list=new ArrayList<Restaurent>();
		try(Connection con=DBConnection.getConnections();
				PreparedStatement pstmt=con.prepareStatement(SELECTALL);){
		ResultSet res=pstmt.executeQuery();
				while(res.next())
				{
					int resid=res.getInt("restaurentId");
					String name=res.getString("name");
					String address=res.getString("address");
					String phonenumber=res.getString("phoneNumber");
					String cuisinetype=res.getString("cuisineType");
					String deliveryTime=res.getString("deliveryTime");
					int adminUserId=res.getInt("adminUserId");
					Float rating=res.getFloat("rating");
					String isactive=res.getString("isActive");
					String ImagePath=res.getString("ImagePath");
					
				r= new Restaurent(resid,name,address,phonenumber,cuisinetype,deliveryTime,adminUserId,rating,isactive,ImagePath);
						list.add(r);	
					
				}
				}
	
		
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}
}

