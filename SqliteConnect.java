package hai;

import java.sql.*;
import javax.swing.*;

public class SqliteConnect {
     
	Connection conn= null;
	public static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn= DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Darryl\\OneDrive\\Documents\\sqlite\\EmployeeDatabase.sqlite");
			return conn;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
	}

}
