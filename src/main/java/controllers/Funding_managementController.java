package controllers;

import models.Funding_management;
import connector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Funding_managementController {

	Connector con = Connector.getInstance();

	private Funding_managementController() {
	}

	private static final Funding_managementController obj = new Funding_managementController();

	public static Funding_managementController getInstance() {
		return obj;
	}

	public void Save(Funding_management data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO funding_management(funding_provider_name,contact_no,email,amount,address) values ('"
				+ data.getFunding_provider_name() + "','" + data.getContact_no() + "','" + data.getEmail() + "','"
				+ data.getAmount() + "','" + data.getAddress() + "') ");
	}

	public void Update(Funding_management data) throws Exception {
		con.getConnection();
		con.aud("UPDATE funding_management SET funding_provider_name  = '" + data.getFunding_provider_name()
				+ "',contact_no  = '" + data.getContact_no() + "',email  = '" + data.getEmail() + "',amount  = '"
				+ data.getAmount() + "',address  = '" + data.getAddress() + "' WHERE fund_id = '" + data.getFund_id()
				+ "'");
	}

	public void Delete(Funding_management data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM funding_management WHERE fund_id = '" + data.getFund_id() + "'");
	}

	public List<Funding_management> SearchAll() throws Exception {
		List<Funding_management> objList = new ArrayList<Funding_management>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM funding_management");
		while (rset.next()) {
			Funding_management obj = new Funding_management();
			obj.setFund_id(rset.getInt(1));
			obj.setFunding_provider_name(rset.getString(2));
			obj.setContact_no(rset.getString(3));
			obj.setEmail(rset.getString(4));
			obj.setAmount(rset.getDouble(5));
			obj.setAddress(rset.getString(6));
			objList.add(obj);
		}

		return objList;
	}

	public List<Funding_management> Search(Funding_management data) throws Exception {
		List<Funding_management> objList = new ArrayList<Funding_management>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM funding_management WHERE fund_id = '" + data.getFund_id() + "'");
		while (rset.next()) {
			Funding_management obj = new Funding_management();
			obj.setFund_id(rset.getInt(1));
			obj.setFunding_provider_name(rset.getString(2));
			obj.setContact_no(rset.getString(3));
			obj.setEmail(rset.getString(4));
			obj.setAmount(rset.getDouble(5));
			obj.setAddress(rset.getString(6));
			objList.add(obj);
		}

		return objList;
	}

}