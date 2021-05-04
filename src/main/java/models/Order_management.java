package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order_management{

	private int order_id;
	private String product_name;
	private int quantity;
	private String customer_name;
	private String customer_address;
	private String contact_no;

public Order_management(){
}

public Order_management(int order_id){
	this.order_id = order_id;
}
public Order_management(int order_id,String product_name,int quantity,String customer_name,String customer_address,String contact_no){
	this.order_id = order_id;
	this.product_name = product_name;
	this.quantity = quantity;
	this.customer_name = customer_name;
	this.customer_address = customer_address;
	this.contact_no = contact_no;
}

public int getOrder_id(){
return order_id;
}

public void setOrder_id(int order_id){
	this.order_id = order_id;
}

public String getProduct_name(){
return product_name;
}

public void setProduct_name(String product_name){
	this.product_name = product_name;
}

public int getQuantity(){
return quantity;
}

public void setQuantity(int quantity){
	this.quantity = quantity;
}

public String getCustomer_name(){
return customer_name;
}

public void setCustomer_name(String customer_name){
	this.customer_name = customer_name;
}

public String getCustomer_address(){
return customer_address;
}

public void setCustomer_address(String customer_address){
	this.customer_address = customer_address;
}

public String getContact_no(){
return contact_no;
}

public void setContact_no(String contact_no){
	this.contact_no = contact_no;
}

}