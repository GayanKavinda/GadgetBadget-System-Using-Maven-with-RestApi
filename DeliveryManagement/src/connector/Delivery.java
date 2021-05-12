package connector;

import java.sql.*;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delivery {

	private Connection connect()
	{
		Connection con = null; 
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/delivery-db",
					"root", ""); 
			
			//For testing 
			System.out.print("Successfully connected"); 
		}	
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		return con;
	}
	
	
	
	
	
	//////////////////////
	public String insertDelivery(String feede, String datede, String locationde, String timede) { 
		
		String output = ""; 
		
		try
		{
			Connection con = connect(); 
			
			if (con == null)
			{
				return "Error while connecting to the database for inserting.";
				
			}
			
			// create a prepared statement 
			String query = " insert into delivery ('deliveryId','deliveryFee`,`date`,`location`,`time`)"
					+ "  values (?, ?, ?, ?, ?)"; 
			
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			
			// binding values 
			
			preparedStmt.setInt(1, 0); 
			preparedStmt.setDouble(2,  Double.parseDouble(feede));
			preparedStmt.setString(3, datede); 
			preparedStmt.setString(4, locationde); 
			preparedStmt.setString(5, timede);
			
			//execute the statement 
			preparedStmt.execute(); 
			con.close(); 
			
			output = "Inserted successfully"; 
	
		}
		catch (Exception e)
		{
			output = "Error while inserting the delivery."; 
			System.err.println(e.getMessage()); 
		}
		return output; 
	}
	
	
	
	
	/////////////////////////////
	
	public String readDeliverys()
	{
		String output = ""; 
		
		try
		{
			Connection con = connect(); 
			
			if (con == null) 
			{
				return "Error while connecting to the database for reading."; 
			}
			
			// Prepare the html table to be displayed 
						output = "<table border='1' class=\table table-striped\"><tr>" 
								+"<th>Delivery Fee  </th><th>Date  </th><th>Location</th><th>Time</th>" 
								+ "<th>Update</th>"
								+ "<th>Remove</th> </tr>"; 
			
			String query = "select * from delivery";
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(query);
			
			
			// iterate through the rows in the result set 
			while(rs.next())
			{
				String deliveryId = Integer.toString(rs.getInt("deliveryId")); 
				String deliveryFee = Double.toString(rs.getDouble("deliveryFee"));
				String date = Integer.toString(rs.getInt("date"));
				String location = rs.getString("location");
				String time = rs.getString("time"); 
				
				// Add a row into the html table 
				output += "<tr><td>" + deliveryFee  + "</td>" ; 
				output += "<td>" + date + "</td>"; 
				output += "<td>" + location + "</td>"; 
				output += "<td>" + time + "</td>"; 
				
				
				// buttons 
				output += "<td><input name='btnUpdate' class=\"btn btn-success\" type='button' value='Update'></td>" 
						+ "<td><form method='post' action='delivery.jsp'>" 
						+ "<input name='btnRemove' class=\"btn btn-danger\" type='submit' value='Remove'>" 
						+ "<input name='deliveryId' type='hidden' value='" + deliveryId + "'>" + "</form></td></tr>"; 
			}
			
			con.close(); 
			
			// Complete the html table 
			output += "</table>"; 
			
		}
		
		catch (Exception e)
		{
			output = "Error while reading the delivery."; 
			System.err.println(e.getMessage());
		}
			
			return output;
		}
		
	

	
//////////////
public String updateDelivery(String id, String feede, String datede, String locationde, String timede)
{
	
	String output = "";
	
	try
	{
		Connection con = connect();
		
		if(con == null)
		{
			return "Error while connecting to the database for updating";
		}
		
		//create prepared statement
		String query = "UPDATE delivery SET deliveryFee=?, date=?, location=?, time=? WHERE deliveryId=?";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		//binding values
		preparedStmt.setDouble(1, Double.parseDouble(feede));
		preparedStmt.setInt(2, Integer.parseInt(datede));
		preparedStmt.setString(3, locationde);
		preparedStmt.setString(4, timede);
		preparedStmt.setInt(5, Integer.parseInt(id));
		
		// execute the statement 
		preparedStmt.execute(); 
		con.close(); 
		
		output = "Updated successfully";
		
	}
	catch (Exception e)
	{
		output = "Error while updating the delivery";
		System.err.println(e.getMessage());
	}
	
	return output;
	

}
	

	
	
	
	//////////////////////////////////
	public String deleteDelivery(String deliveryId)
	{
		String output = "";
		
		
		try
		{
			Connection con = connect();
			
			if(con == null)
			{
				return "Error while connecting to the database for deleting";
			}
			
			//create prepared statement
			String query = "delete from delivery where deliveryId=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			preparedStmt.setInt(1, Integer.parseInt(deliveryId));
			
			//execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Deleted successfully";
			
			}
			catch (Exception e)
			{
				output = "error while deleting the delivery";
				System.err.println(e.getMessage());
			}
		return output;
		
	}
		
}
	
