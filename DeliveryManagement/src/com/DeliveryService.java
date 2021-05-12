package com;

import connector.Delivery;

//For REST Service 
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//import java.ws.rs.GET;
//import javax.ws.rs.Path; 
//import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 

//For JSON 
import com.google.gson.*; 

//For XML 
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Deliverys") 
public class DeliveryService 
{
	Delivery deliveryObj = new Delivery();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDeliverys()
	
	{
		return deliveryObj.readDeliverys();
	}
	


	
	@POST 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertDelivery(@FormParam("deliveryFee") String deliveryFee,
			@FormParam("date") String date,
			@FormParam("location") String location,
			@FormParam("time") String time)
	{
		String output = deliveryObj.insertDelivery(deliveryFee, date, location, time);
		return output;
	}
			
	
	@PUT 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDelivery(String deliveryData) 
	{
		
		//Convert the input string to a JSON object 
		JsonObject deliveryObject = new JsonParser().parse(deliveryData).getAsJsonObject();
		
		//Read the values from the JSON object
		String deliveryId = deliveryObject.get("deliveryId").getAsString(); 
		String deliveryFee = deliveryObject.get("deliveryFee").getAsString(); 
		String date = deliveryObject.get("date").getAsString(); 
		String location = deliveryObject.get("location").getAsString(); 
		String time = deliveryObject.get("time").getAsString(); 
		
		String output = deliveryObj.updateDelivery(deliveryId, deliveryFee, date, location, time);
		
		return output;
	}

	
	@DELETE
	@Path("")
	@Consumes(MediaType.APPLICATION_ATOM_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDelivery(String deliveryData)
	{
		//convert the input string to an xml document
		Document doc = Jsoup.parse(deliveryData, "", Parser.xmlParser());
		
		//read the value from the element <deliveryId>
		String deliveryId = doc.select("deliveryId").text();
		
		String output = deliveryObj.deleteDelivery(deliveryId);
		
		return output;
	}
}