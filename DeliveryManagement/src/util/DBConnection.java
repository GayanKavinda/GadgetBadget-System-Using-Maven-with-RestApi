/*package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private DBConnection() {
		
	}
	
	public static Connection connect() {
		Connection connection = null;
		
		try
		{
			Class.forName(DeliveryConstant.DBDriver);
			connection = DriverManager.getConnection(DeliveryConstant.DBLocation,"root","");
			
			System.out.println("successfully connected");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
}
*/