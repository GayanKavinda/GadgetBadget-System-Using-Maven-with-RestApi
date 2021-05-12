/**
 * 
 */
package com.productManagement.service;

import com.productManagement.model.Product;

//restService
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.*;

import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

/**
 * @author HASINI
 *
 */

@Path("/Products")
public class ProductService {
	
	Product product = new Product();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readProducts() {
		return product.readProducts();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertProduct(@FormParam("productCode") String productCode,
			@FormParam("productName") String productName,
			@FormParam("productPrice") String productPrice,
			@FormParam("quanti") String quantit,
			@FormParam("des") String desc,
			@FormParam("researcherName") String res)
	{
		String output = product.insertProduct(productCode, productName, productPrice, quantit, desc, res);
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProduct(String productData)
	{
		JsonObject productObject = new JsonParser().parse(productData).getAsJsonObject();
		
		String productID = productObject.get("product_id").getAsString();
		String productCode = productObject.get("productCode").getAsString();
		String productName = productObject.get("productName").getAsString();
		String productPrice = productObject.get("productPrice").getAsString();
		String quantity = productObject.get("quantity").getAsString();
		String productDesc = productObject.get("productDes").getAsString();
		String rName = productObject.get("resName").getAsString();
		
		String output = product.updateProduct(productID, productCode, productName, productPrice, quantity, productDesc, rName);
		return output; 
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProduct(String productData)
	{
	
		Document doc = Jsoup.parse(productData, "", Parser.xmlParser());
		//Read the value from the element <itemID>
		String pID = doc.select("product_id").text();
		String output = product.deleteProduct(pID);
		return output;
	}
	
	
	
	
	
	
	
	
	
	
	

}
