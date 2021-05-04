package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment_management {

	private int payment_id;
	private String name_on_card;
	private String card_number;
	private String cvv;
	private String exp_day;
	private double amout;

	public Payment_management() {
	}

	public Payment_management(int payment_id) {
		this.payment_id = payment_id;
	}

	public Payment_management(int payment_id, String name_on_card, String card_number, String cvv, String exp_day,
			double amout) {
		this.payment_id = payment_id;
		this.name_on_card = name_on_card;
		this.card_number = card_number;
		this.cvv = cvv;
		this.exp_day = exp_day;
		this.amout = amout;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getName_on_card() {
		return name_on_card;
	}

	public void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExp_day() {
		return exp_day;
	}

	public void setExp_day(String exp_day) {
		this.exp_day = exp_day;
	}

	public double getAmout() {
		return amout;
	}

	public void setAmout(double amout) {
		this.amout = amout;
	}

}