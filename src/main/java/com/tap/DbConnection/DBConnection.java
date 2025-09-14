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

public class DBConnection {
    public  static Connection connection;
   public static  String url = System.getenv("DB_URLS");
    public static String user = System.getenv("DB_USERS");
    public static String password = System.getenv("DB_PASSWORDS");

    public static Connection getConnection() {
        if (connection == null) {
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver"); // load MySQL driver
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("✅ Database connected successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("❌ Database connection failed. Check environment variables.");
            }
        }
        return connection;
    }
}
