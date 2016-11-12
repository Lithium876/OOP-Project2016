package services;

import java.sql.*;

public class DBConnection {
	Connection conn =null;
	public static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:H&AI.sqlite");
			System.out.println("Sucess");
			return conn;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
}
