/**
 * 
 */
package com.flipkart.rest;


import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.service.serviceImpl.AdminFlipFitServiceImpl;
import com.flipkart.service.AdminFlipfitService;


/**
 * 
 */
@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymAdminFlipfitController {
	AdminFlipfitService adminService = AdminFlipFitServiceImpl.getInstance();

	  @POST
	    @Path("/approve/gym/{gym_id}")
	    public Response approveGym(@PathParam("gym_id") int gym_id) {
	        try {
	            adminService.approveGymRequest(gym_id);
	            return Response.ok("Gym with ID: " + gym_id + " approved successfully.").build();
	        } catch (Exception e) {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                    .entity("Failed to approve gym with ID: " + gym_id + ". Error: " + e.getMessage()).build();
	        }
	    }

	    @POST
	    @Path("/approve/owner/{gym_owner_id}")
	    public Response approveOwner(@PathParam("gym_owner_id") int gym_owner_id) {
	        try {
	            adminService.verifyGymOwnerRequest(gym_owner_id);
	            return Response.ok("Owner with ID: " + gym_owner_id + " approved successfully.").build();
	        } catch (Exception e) {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                    .entity("Failed to approve owner with ID: " + gym_owner_id + ". Error: " + e.getMessage()).build();
	        }
	    }

	    @POST
	    @Path("/approve/slot/{slot_id}")
	    public Response approveSlot(@PathParam("slot_id") int slot_id) {
	        try {
	            adminService.approveSlotRequest(slot_id);
	            return Response.ok("Slot ID: " + slot_id + " approved successfully.").build();
	        } catch (Exception e) {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                    .entity("Failed to approve slot with ID: " + slot_id + ". Error: " + e.getMessage()).build();
	        }
	    }

    @GET
    @Path("/registration/gym")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGymRegistrations() {
        try {
            return Response.ok(adminService.getGymRequests()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to fetch gym registrations. Error: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/registration/owner")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOwnerRegistrations() {
        try {
            return Response.ok(adminService.getGymOwnerRequests().stream()
                    .map(owner -> {
                        owner.setUsername(null);
                        owner.setPassword(null);
                        owner.setRole(null);
                        return owner;
                    })
                    .collect(Collectors.toList())).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to fetch owner registrations. Error: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/registration/slot")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSlotRegistrations() {
        try {
            return Response.ok(adminService.getSlotRequests()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to fetch slot registrations. Error: " + e.getMessage()).build();
        }
    }

}