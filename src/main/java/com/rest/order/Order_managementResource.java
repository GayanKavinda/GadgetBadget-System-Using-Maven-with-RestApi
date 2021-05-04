package com.rest.order;

import models.Order_management;
import controllers.Order_managementController;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Order_managementResources")
public class Order_managementResource {

	@GET
	@Path("Order_managements")
	@Produces({MediaType.APPLICATION_JSON })
	public List<Order_management> getAllOrder_managements() throws Exception {
		return Order_managementController.getInstance().SearchAll();
	}

	@GET
	@Path("Order_management/{order_id}")
	@Produces({MediaType.APPLICATION_JSON })
	public List<Order_management> getOrder_management(@PathParam("order_id") int order_id) throws Exception {
		Order_management obj = new Order_management();
		obj.setOrder_id(order_id);
		return Order_managementController.getInstance().Search(obj);
	}

	@POST
	@Path("Order_management")
	public String saveOrder_management(Order_management obj) throws Exception {
		Order_managementController.getInstance().Save(obj);
		return "Order_management Saved";
	}

	@PUT
	@Path("Order_management")
	public String updateOrder_management(Order_management obj) throws Exception {
		Order_managementController.getInstance().Update(obj);
		return "Order_management Updated";
	}

	@DELETE
	@Path("Order_management/{order_id}")
	public String deleteOrder_management(@PathParam("order_id") int order_id) throws Exception {
		Order_management obj = new Order_management();
		obj.setOrder_id(order_id);
		Order_managementController.getInstance().Delete(obj);
		return "Order_management Deleted";
	}
}