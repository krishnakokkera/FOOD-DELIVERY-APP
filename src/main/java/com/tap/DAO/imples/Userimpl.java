package com.tap.DAO.imples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.UserDAO;
import com.tap.DbConnection.DBConnection;
import com.tap.MODELS.User;

public class Userimpl implements UserDAO{

	//private Connection connection;
	public static String INSERT="insert into `user`(`name`,`userName`,`password`,`email`,`phoneNumber`,`address`,`role`,`createDate`,`lastLoginDate`) values(?,?,?,?,?,?,?,?,?)";
	public static String SELECT="select * from `user` where `userId`=?";
	public static String UPDATE="update `user` set `name`=?, `userName`=?,`password`=?,`email`=?,`phoneNumber`=?,`address`=? where `userId`=?";
	public static String SELECTALL="select * from `user`";
	//public static String select1="select `password` from `user` where `name`=? ";
	 // The SQL query is now fixed to get ALL user data
    String sql = "SELECT * FROM `user` WHERE `userName` = ?";
    
	@Override
	public int  addUser(User user) {
		int res=0;
		try(Connection connection =DBConnection.getConnections();
				PreparedStatement pstmt=connection.prepareStatement(INSERT);)
		{

			//pstmt.setInt(1,user.getUserId());
			pstmt.setString(1, user.getName());
			pstmt.setString(2,user.getUserName());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getEmail());
			pstmt.setString(5,user.getPhoneNumber());
			pstmt.setString(6,user.getAddress());
			pstmt.setString(7,user.getRole());
			pstmt.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(9,new Timestamp(System.currentTimeMillis()));


			res=pstmt.executeUpdate();
			//System.out.print(res);



		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return res;

	}

	@Override
	public int updateUser(User user) {
		int res=0;
		try(Connection connection =DBConnection.getConnections();
				PreparedStatement pstmt=connection.prepareStatement(UPDATE);)
		{


			pstmt.setString(1, user.getName());
			pstmt.setString(2,user.getUserName());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getEmail());
			pstmt.setString(5,user.getPhoneNumber());
			pstmt.setString(6,user.getAddress());
			pstmt.setInt(7,user.getUserId());


			res=pstmt.executeUpdate();


		}


		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteUser(int id) {
		return 0;
	}

	@Override
	public User getUser(int id) {

		User u=null;
		try(Connection connection =DBConnection.getConnections();
				PreparedStatement pstmt=connection.prepareStatement(SELECT);)
		{
			pstmt.setInt(1, id);
			ResultSet res=pstmt.executeQuery();

			while(res.next())
			{
				int id1 = res.getInt("userId");
				String name = res.getString("name");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String email = res.getString("email");
				String phonenumber = res.getString("phoneNumber");
				String address= res.getString("address");
				String role= res.getString("role");
				Timestamp date1=res.getTimestamp("createDate");
				Timestamp date2=res.getTimestamp("lastLoginDate");;


			
				u = new User(id1, name, userName, password, email, phonenumber, address, role);


			}

		}


		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<User> getAll() {
		User u=null;
		List<User> list=new ArrayList<User>();
		try(Connection connection =DBConnection.getConnections();
				PreparedStatement pstmt=connection.prepareStatement(SELECTALL);)
		{
			ResultSet res= pstmt.executeQuery();

			while(res.next())
			{
				int id1 = res.getInt("userId");
				String name = res.getString("name");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String email = res.getString("email");
				String phonenumber = res.getString("phoneNumber");
				String address= res.getString("address");
				String role= res.getString("role");
				Timestamp date1=res.getTimestamp("createDate");
				Timestamp date2=res.getTimestamp("lastLoginDate");;


				//u=new User(id1,name,userName,password,email,phonenumber,address,role,null,null);
				u = new User(id1, name, userName, password, email, phonenumber, address, role, null, null);
				list.add(u);


			}





		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}


		return list;
	}

	
//	public User getUserPassWordWithName(String name) {
//		User u=null;
//		try(Connection connection =DBConnection.getConnections();
//				PreparedStatement pstmt=connection.prepareStatement(select1);)
//		{
//
//			pstmt.setString(1,name);
//
//			ResultSet res = pstmt.executeQuery();
//
//			while(res.next())
//			{
//				//String name1=res.getString("name");
//				String passWord2=res.getString("password");
//
//
//				u=new User(passWord2);
//
//			}
//
//
//
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//
//
//		return u;
//
//	}
	// THIS IS THE NEW, CORRECT METHOD. USE THIS.

	
	public User getUserPassWordWithName(String name) {
	    User u = null;
	    
	   
	    try (Connection connection = DBConnection.getConnections();
	         PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        
	        pstmt.setString(1, name); // 'name' here is the username from the login form

	        ResultSet res = pstmt.executeQuery();

	        if (res.next()) { // Use 'if' because username is unique
	            
	            // We now create a COMPLETE User object with the all-important userId
	            
	            int userId = res.getInt("userId");
	            String userName = res.getString("userName");
	            String password = res.getString("password");
	            String email = res.getString("email");
	            String phoneNumber = res.getString("phoneNumber");
	            String address = res.getString("address");
	            String role = res.getString("role");
	            String realName = res.getString("name"); 
	            
	            // Create the full User object. Adjust constructor if yours is different.
	            u = new User(userId, realName, userName, password, email, phoneNumber, address, role);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return u; // Return the complete User object
	}
}



