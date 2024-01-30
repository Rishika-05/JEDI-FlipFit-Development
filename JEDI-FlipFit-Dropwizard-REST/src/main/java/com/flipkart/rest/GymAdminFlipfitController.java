/**
 * 
 */
package com.flipkart.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 */
@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymAdminFlipfitController {
	 @GET
	    public String getEmployees() {
	        return "my dropwizard service";
	    }
}
