//package com.tap.DbConnection;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
// 
//
//public   class DBConnection {
//	public static String url="jdbc:mysql://localhost:3306/food_app";
//	public static String uname="root";
//	public static String password="krishna";
//	public static Connection connection ;
//
//	public static Connection getConnections() {
//	try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		connection  = DriverManager.getConnection(url,uname,password);
//	}
//	catch(ClassNotFoundException e)
//	{
//		e.printStackTrace();
//	}catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return connection;
//}
//}
//

package com.tap.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static String url = "jdbc:mysql://mysql-31676370-kokkerakrishna10-06b3.k.aivencloud.com:14652/defaultdb?ssl-mode=REQUIRED";
	public static String username = "avnadmin";
	public static String password = System.getenv("DB_PASSWORD");


    public static Connection connection;

    public static Connection getConnections() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Connected to FreeSQLdatabase!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed.");
            e.printStackTrace();
        }
        return connection;
    }
}