package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Funding_management {

	private int fund_id;
	private String funding_provider_name;
	private String contact_no;
	private String email;
	private double amount;
	private String address;

	public Funding_management() {
	}

	public Funding_management(int fund_id) {
		this.fund_id = fund_id;
	}

	public Funding_management(int fund_id, String funding_provider_name, String contact_no, String email, double amount,
			String address) {
		this.fund_id = fund_id;
		this.funding_provider_name = funding_provider_name;
		this.contact_no = contact_no;
		this.email = email;
		this.amount = amount;
		this.address = address;
	}

	public int getFund_id() {
		return fund_id;
	}

	public void setFund_id(int fund_id) {
		this.fund_id = fund_id;
	}

	public String getFunding_provider_name() {
		return funding_provider_name;
	}

	public void setFunding_provider_name(String funding_provider_name) {
		this.funding_provider_name = funding_provider_name;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}