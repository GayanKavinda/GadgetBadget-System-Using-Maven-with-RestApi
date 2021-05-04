package controllers;


import models.Order_management;
import connector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Order_managementController{

	Connector con = Connector.getInstance();

	private Order_managementController(){
	}

	private static final Order_managementController obj = new Order_managementController();

	public static Order_managementController getInstance(){
		return obj;
	}

	public void Save(Order_management data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO order_management(product_name,quantity,customer_name,customer_address,contact_no) values ('" + data.getProduct_name()+ "','" + data.getQuantity()+ "','" + data.getCustomer_name()+ "','" + data.getCustomer_address()+ "','" + data.getContact_no()+ "') " );
	}

	public void Update(Order_management data) throws Exception {
		con.getConnection();
		con.aud("UPDATE order_management SET product_name  = '" + data.getProduct_name()+ "',quantity  = '" + data.getQuantity()+ "',customer_name  = '" + data.getCustomer_name()+ "',customer_address  = '" + data.getCustomer_address()+ "',contact_no  = '" + data.getContact_no()+ "' WHERE order_id = '" + data.getOrder_id()+ "'");
	}

	public void Delete(Order_management data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM order_management WHERE order_id = '" + data.getOrder_id()+ "'");
	}

	public List<Order_management> SearchAll() throws Exception {
		List<Order_management> objList = new ArrayList<Order_management>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM order_management");
		while(rset.next()){
			Order_management obj = new Order_management();
			obj.setOrder_id(rset.getInt(1));
			obj.setProduct_name(rset.getString(2));
			obj.setQuantity(rset.getInt(3));
			obj.setCustomer_name(rset.getString(4));
			obj.setCustomer_address(rset.getString(5));
			obj.setContact_no(rset.getString(6));
			objList.add(obj);
		}

	return objList;
	}

	public List<Order_management> Search(Order_management data) throws Exception {
		List<Order_management> objList = new ArrayList<Order_management>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM order_management WHERE order_id = '" + data.getOrder_id()+ "'");
		while(rset.next()){
			Order_management obj = new Order_management();
			obj.setOrder_id(rset.getInt(1));
			obj.setProduct_name(rset.getString(2));
			obj.setQuantity(rset.getInt(3));
			obj.setCustomer_name(rset.getString(4));
			obj.setCustomer_address(rset.getString(5));
			obj.setContact_no(rset.getString(6));
			objList.add(obj);
		}

	return objList;
	}

}