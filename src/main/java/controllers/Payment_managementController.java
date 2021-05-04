package controllers;

import models.Payment_management;
import connector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Payment_managementController {

	Connector con = Connector.getInstance();

	private Payment_managementController() {
	}

	private static final Payment_managementController obj = new Payment_managementController();

	public static Payment_managementController getInstance() {
		return obj;
	}

	public void Save(Payment_management data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO payment_management(name_on_card,card_number,cvv,exp_day,amout) values ('"
				+ data.getName_on_card() + "','" + data.getCard_number() + "','" + data.getCvv() + "','"
				+ data.getExp_day() + "','" + data.getAmout() + "') ");
	}

	public void Update(Payment_management data) throws Exception {
		con.getConnection();
		con.aud("UPDATE payment_management SET name_on_card  = '" + data.getName_on_card() + "',card_number  = '"
				+ data.getCard_number() + "',cvv  = '" + data.getCvv() + "',exp_day  = '" + data.getExp_day()
				+ "',amout  = '" + data.getAmout() + "' WHERE payment_id = '" + data.getPayment_id() + "'");
	}

	public void Delete(Payment_management data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM payment_management WHERE payment_id = '" + data.getPayment_id() + "'");
	}

	public List<Payment_management> SearchAll() throws Exception {
		List<Payment_management> objList = new ArrayList<Payment_management>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM payment_management");
		while (rset.next()) {
			Payment_management obj = new Payment_management();
			obj.setPayment_id(rset.getInt(1));
			obj.setName_on_card(rset.getString(2));
			obj.setCard_number(rset.getString(3));
			obj.setCvv(rset.getString(4));
			obj.setExp_day(rset.getString(5));
			obj.setAmout(rset.getDouble(6));
			objList.add(obj);
		}

		return objList;
	}

	public List<Payment_management> Search(Payment_management data) throws Exception {
		List<Payment_management> objList = new ArrayList<Payment_management>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM payment_management WHERE payment_id = '" + data.getPayment_id() + "'");
		while (rset.next()) {
			Payment_management obj = new Payment_management();
			obj.setPayment_id(rset.getInt(1));
			obj.setName_on_card(rset.getString(2));
			obj.setCard_number(rset.getString(3));
			obj.setCvv(rset.getString(4));
			obj.setExp_day(rset.getString(5));
			obj.setAmout(rset.getDouble(6));
			objList.add(obj);
		}

		return objList;
	}

}