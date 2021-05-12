/**
 * 
 */
package com.productManagement.util;

/**
 * @author HASINI
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;

public class DBConnection {
	
	private DBConnection() {
		
	}
	
	public static Connection connect() throws ClassNotFoundException, SQLException {
		
		Connection connection  = null;
		
		try 
		{
			Class.forName(ProductConstant.DBDriver);
			connection = DriverManager.getConnection(ProductConstant.DBLocation,"root","");
			
			System.out.println("Successfully connected");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	

}
