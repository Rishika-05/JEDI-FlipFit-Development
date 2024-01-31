/**
 * 
 */
package com.flipkart.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.bean.User;
import com.flipkart.service.GymCustomerFlipFitService;
import com.flipkart.service.GymOwnerFlipFitService;
import com.flipkart.service.SlotFlipFitService;
import com.flipkart.service.GymFlipFitService;
import com.flipkart.service.serviceImpl.GymCustomerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.GymFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.GymOwnerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.SlotFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.UserFlipFitServiceImpl;

/**
 * 
 */
@Path("/owner")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymOwnerFlipfitController {
	
			
    GymFlipFitService gymService = new GymFlipFitServiceImpl();
    SlotFlipFitService slotService = new SlotFlipFitServiceImpl();
    GymOwnerFlipFitService ownerService = GymOwnerFlipFitServiceImpl.getInstance();
	 
	@POST
    @Path("/gym")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGym(Gym gym){
		try {
			gymService.addGym(gym);
		} catch(Exception ex) {
			//Todo: Change and add specific exceeptions
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(ex.getMessage()).build();
		}
        return Response.ok(gym).build();
    }
	
	@GET
    @Path("/{gymOwnerId}/gym")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGyms(@PathParam("gymOwnerId") int gymOwnerId){
		try {
			List<Gym> gyms = gymService.getAllGymsById(gymOwnerId);
			return Response.ok(gyms).build();
		} catch(Exception ex) {
			//Todo: Change and add specific exceeptions
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(ex.getMessage()).build();
		}
        
    }
	
	@DELETE
    @Path("/gym/{gymId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeGym(@PathParam("gymId") int gymId){
		try {
			gymService.removeGym(gymId);
			return Response.ok("Gym with Id: " + gymId + " deleted successfully").build();
		} catch(Exception ex) {
			//Todo: Change and add specific exceeptions
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(ex.getMessage()).build();
		}
        
    }
	
	
	//todo later
	@PUT
    @Path("/gym/{gymId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateGym(@PathParam("gymId") int gymId , Gym newGym){
		try {
			Gym gym = gymService.getGym(gymId);
			if(newGym.getGymDescription() != null) gym.setGymDescription(newGym.getGymDescription());
			if(newGym.getGymName() != null) gym.setGymName(newGym.getGymName());
			if(newGym.getLocation() != null) gym.setLocation(newGym.getLocation());
			if(newGym.getTotalSlots() != null) gym.setTotalSlots(newGym.getTotalSlots());
			if(newGym.getPricePerSlot() != null) gym.setPricePerSlot(newGym.getPricePerSlot());
			gymService.updateGym(gym);
			return Response.ok(gym).build();
		} catch(Exception ex) {
			//Todo: Change and add specific exceeptions
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(ex.getMessage()).build();
		}
        
    }
	
	@POST
    @Path("/slot")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSlot( Slot slot){
		try {
			slotService.addSlot(slot.getGymId(), slot.getStartTime(), slot.getSlotTime() , slot.getTotalSeats());
			return Response.ok(slot).build();
		} catch(Exception ex) {
			//Todo: Change and add specific exceeptions
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(ex.getMessage()).build();
		}
        
    }
	
	@GET
    @Path("/gym/{gymId}/slot")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewSlots(@PathParam("gymId") int gymId){
		try {
			List<Slot> slots = slotService.getAllSlotsByGymId(gymId);
			return Response.ok(slots).build();
		} catch(Exception ex) {
			//Todo: Change and add specific exceeptions
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(ex.getMessage()).build();
		}
        
    }
	
	@PUT
    @Path("/slot/{slotId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSlot(@PathParam("slotId") int slotId , Slot newSlot){
		try {
			Slot slot = slotService.getSlot(slotId);
			if(newSlot.getStartTime() != null) slot.setStartTime(newSlot.getStartTime());
			if(newSlot.getTotalSeats() != null) slot.setTotalSeats(newSlot.getTotalSeats());
			slotService.updateSlot(newSlot);
			return Response.ok(newSlot).build();
		} catch(Exception ex) {
			//Todo: Change and add specific exceeptions
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(ex.getMessage()).build();
		}
        
    }
	
	@DELETE
    @Path("/slot/{slotId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeSlot(@PathParam("slotId") int slotId){
		try {
			slotService.removeSlot(slotId);
			return Response.ok("Slot with Id: " + slotId + " deleted successfully").build();
		} catch(Exception ex) {
			//Todo: Change and add specific exceeptions
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(ex.getMessage()).build();
		}
        
    }
	
	@GET
    @Path("/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewProfile(@PathParam("ownerId") int ownerId){
		try {
			GymOwner owner = ownerService.getGymOwnerById(ownerId);
			return Response.ok(owner).build();
		} catch(Exception ex) {
			//Todo: Change and add specific exceeptions
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(ex.getMessage()).build();
		}
        
    }
	
	@PUT
    @Path("/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateGym(@PathParam("ownerId") int ownerId , GymOwner newGymOwner){
		try {
			GymOwner gymOwner = ownerService.getGymOwnerById(ownerId);
			if(newGymOwner.getAge() != null) gymOwner.setAge(newGymOwner.getAge());
			if(newGymOwner.getName() != null) gymOwner.setName(newGymOwner.getName());
			if(newGymOwner.getLocation() != null) gymOwner.setLocation(newGymOwner.getLocation());
			ownerService.updateProfile(gymOwner);
			return Response.ok(gymOwner).build();
		} catch(Exception ex) {
			//Todo: Change and add specific exceeptions
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(ex.getMessage()).build();
		}
        
    }
	
	
	
	
	
}
