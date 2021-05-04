package com.rest.funding;

import models.Funding_management;
import controllers.Funding_managementController;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Funding_managementResources")
public class Funding_managementResource {

	@GET
	@Path("Funding_managements")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Funding_management> getAllFunding_managements() throws Exception {
		return Funding_managementController.getInstance().SearchAll();
	}

	@GET
	@Path("Funding_management/{fund_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Funding_management> getFunding_management(@PathParam("fund_id") int fund_id) throws Exception {
		Funding_management obj = new Funding_management();
		obj.setFund_id(fund_id);
		return Funding_managementController.getInstance().Search(obj);
	}

	@POST
	@Path("Funding_management")
	public String saveFunding_management(Funding_management obj) throws Exception {
		Funding_managementController.getInstance().Save(obj);
		return "Funding_management Saved";
	}

	@PUT
	@Path("Funding_management")
	public String updateFunding_management(Funding_management obj) throws Exception {
		Funding_managementController.getInstance().Update(obj);
		return "Funding_management Updated";
	}

	@DELETE
	@Path("Funding_management/{fund_id}")
	public String deleteFunding_management(@PathParam("fund_id") int fund_id) throws Exception {
		Funding_management obj = new Funding_management();
		obj.setFund_id(fund_id);
		Funding_managementController.getInstance().Delete(obj);
		return "Funding_management Deleted";
	}
}