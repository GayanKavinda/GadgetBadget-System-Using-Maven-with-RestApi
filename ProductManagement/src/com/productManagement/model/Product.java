/**
 * 
 */
package com.productManagement.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.productManagement.util.*;

/**
 * @author HASINI
 *
 */

public class Product {
	
	public String insertProduct(String code, String name, String price, String quantity, String des, String resName)
	{
		String output = "";
		
		try
		{
			Connection connection;
			connection = DBConnection.connect();
			
			if(connection == null) {
				return "error while connecting to the database";
			}
			
			String query = "INSERT INTO product("
					+"product_Id,"
					+"productCode,"
					+"productName,"
					+"productPrice,"
					+"quantity,"
					+"productDes,"
					+"resName)"
					+"VALUES(?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, code);
			preparedStmt.setString(3, name);
			preparedStmt.setDouble(4, Double.parseDouble(price));
			preparedStmt.setInt(5, Integer.parseInt(quantity));
			preparedStmt.setString(6, des);
			preparedStmt.setString(7, resName);
			
			preparedStmt.execute();
			connection.close();
			
			output = "Insert Successfully";
			
		}catch(Exception e){
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String readProducts() {
		
		String output = "";
		
		try {
			Connection connection = DBConnection.connect();
			if(connection == null) {
				return "Error while connecting to db";
			}
			
			output = "<div class='container'><table class = 'table' border='1'> <thead class='thead-dark'><tr><th scope='col'>Product Code</th>"
					+ "<th scope='col'>Product Name</th><th scope='col'>Product Price</th>"
					+ "<th scope='col'>Quantity</th><th scope='col'>Description</th>"
					+ "<th scope='col'>Research Name</th><th>Update</th><th>Delete</th></thead>";
			
			String query = "select * from product";
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next())
			{
				String productID = Integer.toString(rs.getInt("product_id"));
				String pCode = rs.getString("productCode");
				String pName = rs.getString("productName");
				String pPrice = rs.getString("productPrice");
				String quanti = rs.getString("quantity");
				String des = rs.getString("productDes");
				String res = rs.getString("resName");
				
				output += "<tbody><tr><th scope='row'>" + pCode + "</th>";
				output += "<td>" + pName + "</td>";
				output += "<td>" + pPrice + "</td>";
				output += "<td>" + quanti + "</td>";
				output += "<td>" + des + "</td>";
				output += "<td>" + res + "</td>";
				
				output += "<td><input name='btnUpdate' type = 'button' value = 'Update' class = 'btn btn-secondary'></td>"
						+ "<td><form method = 'post' action = 'product.jsp'>"
						+ "<input name = 'btnRemove' "
						+ "type = 'submit' value = 'Remove' class = 'btn btn-danger'>"
						+ "<input name = 'pID' type = 'hidden' "
						+ "value = '" + productID +"'>"+ "</form></td></tr>";
						
			}
			
			connection.close();
			
			output += "</table></div>";
			
		}
		catch(Exception e)
		{
			output = "Error while reading the products";
			System.err.println(e.getMessage());
		}
		
		return output;
		
	}
	
	public String deleteProduct(String productID) {
		
		String output = "";
		
		try {
			
			Connection connection = DBConnection.connect();
			
			if(connection == null) {
				return "Error while connecting to db";
			}
			
			String query = "delete from product where product_id=?";
			
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			
			preparedStmt.setInt(1, Integer.parseInt(productID));
			
			preparedStmt.execute();
			connection.close();
			
			output = "Delete Successfully";
	
		}catch(Exception e) {
			output = "Error while deleteing the product";
			System.out.println(e.getMessage());
		}
		
		return output;
	}
	
	public String updateProduct(String pid, String code, String name, String price, String quanti, String des, String resName ) {
		
		String output = "";
		
		try {
			Connection connection = DBConnection.connect();
			
			if(connection == null) {
				return "Error while connecting to db";
			}
			
			String query = "update product set productCode=?,productName=?,productPrice=?,quantity=?,productDes=?,resName=? where product_id=?";
			
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			
			preparedStmt.setString(1, code);
			preparedStmt.setString(2, name);
			preparedStmt.setDouble(3, Double.parseDouble(price));
			preparedStmt.setInt(4, Integer.parseInt(quanti));
			preparedStmt.setString(5, des);
			preparedStmt.setString(6, resName);
			preparedStmt.setInt(7, Integer.parseInt(pid));
			
			preparedStmt.execute();
			connection.close();
			
			output = "Updated successfully";
			
		}catch(Exception e){
			output = "Error while updating the product";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	

}
