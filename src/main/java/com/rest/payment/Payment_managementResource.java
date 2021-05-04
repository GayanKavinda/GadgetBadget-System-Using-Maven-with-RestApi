package com.rest.payment;

import models.Payment_management;
import controllers.Payment_managementController;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Payment_managementResources")
public class Payment_managementResource {

	@GET
	@Path("Payment_managements")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Payment_management> getAllPayment_managements() throws Exception {
		return Payment_managementController.getInstance().SearchAll();
	}

	@GET
	@Path("Payment_management/{payment_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Payment_management> getPayment_management(@PathParam("payment_id") int payment_id) throws Exception {
		Payment_management obj = new Payment_management();
		obj.setPayment_id(payment_id);
		return Payment_managementController.getInstance().Search(obj);
	}

	@POST
	@Path("Payment_management")
	public String savePayment_management(Payment_management obj) throws Exception {
		Payment_managementController.getInstance().Save(obj);
		return "Payment_management Saved";
	}

	@PUT
	@Path("Payment_management")
	public String updatePayment_management(Payment_management obj) throws Exception {
		Payment_managementController.getInstance().Update(obj);
		return "Payment_management Updated";
	}

	@DELETE
	@Path("Payment_management/{payment_id}")
	public String deletePayment_management(@PathParam("payment_id") int payment_id) throws Exception {
		Payment_management obj = new Payment_management();
		obj.setPayment_id(payment_id);
		Payment_managementController.getInstance().Delete(obj);
		return "Payment_management Deleted";
	}
}