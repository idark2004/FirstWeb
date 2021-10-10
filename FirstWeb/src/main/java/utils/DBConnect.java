package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	//truoc tien import cai file .jar o thu muc lib vao project : Java Build Path ->Libraries-> Class path -> Add external JAR
	public static Connection makeConnection() {
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//1443 là port cua sqlserver		
			String url = "jdbc:sqlserver://localhost:1433;databaseName=FirstWeb";
			//LAPTOP-AVC12MQQ\\SQL la ten server
			// thich dung cach nao cung dc
			//String url = "jdbc:sqlserver://LAPTOP-AVC12MQQ\\SQL;databaseName=FirstWeb";
			//username va password tuy moi may moi khac 
			String username="sa";
			String password="1234";
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected!");
			return conn;
	} 
			catch (ClassNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		} 
			catch (SQLException e) {
			System.out.println("Oopps Cannot connect");
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
}
