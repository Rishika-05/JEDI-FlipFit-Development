/**
 * 
 */
package com.flipkart.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.Slot;
import com.flipkart.service.GymCustomerFlipFitService;
import com.flipkart.service.GymFlipFitService;
import com.flipkart.service.SlotFlipFitService;
import com.flipkart.service.serviceImpl.BookingFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.GymCustomerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.GymFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.SlotFlipFitServiceImpl;
import com.flipkart.utils.FormatterUtils;

/**
 * 
 */
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymCustomerFlipfitController {
	GymCustomerFlipFitService customerService = GymCustomerFlipFitServiceImpl.getInstance();
	GymFlipFitService gymService = new GymFlipFitServiceImpl();
	SlotFlipFitService slotService = new SlotFlipFitServiceImpl();
	BookingFlipFitServiceImpl bookingService = new BookingFlipFitServiceImpl();

	FormatterUtils formatterUtils = new FormatterUtils();
	
	
    @Path("/profile/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response viewProfile(@PathParam("id") int id){
	    GymCustomer gymCustomer = customerService.viewProfile(id);
        return Response.ok(gymCustomer).build();
    }
    
    @Path("/profile/{id}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProfile(@PathParam("id") int id, GymCustomer newGymCustomer) {
    	
        GymCustomer customer = customerService.viewProfile(id);
        
        if (customer != null) {
        	if(newGymCustomer.getName() != null) {
                customer.setName(newGymCustomer.getName());
            }

            customer.setAge(newGymCustomer.getAge());
            
            if(newGymCustomer.getLocation() != null) {
            	customer.setLocation(newGymCustomer.getLocation());
            }
            
            if (customerService.updateProfile(id, customer)) {
                return Response.ok(customer).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Update failed").build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Customer not found").build();
        }
    }
    
    @Path("/{userId}/booking/gym/{gymId}/slot/{slotId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bookSlot(@PathParam("gymId") int gymId, @PathParam("userId") int userId, @PathParam("slotId") int slotId) {
		
        if(bookingService.insertBooking(userId, gymId, slotId)) {
        	return Response.ok("Booking Added Successfully.").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Update failed").build();
        }
    }
    
    @Path("/gym/{gymId}/slot/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response browseSlots(@PathParam("gymId") int gymId) {
		
        List<Slot> slots = slotService.getAllSlotsByGymId(gymId);
        return Response.ok(slots).build();
    }
    
    @Path("/gym/{location}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response browseGyms(@PathParam("location") String location){
        try {
            List<Gym> gyms = gymService.getAllGymsByLoc(location);
            return Response.ok(gyms).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to retrieve gyms").build();
        }
    }
    
    @Path("/booking/user/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response viewBookingHistory(@PathParam("userId") int userId){
		List<Booking> bookedSlots = bookingService.getBookingsByUserId(userId);
		return Response.ok(bookedSlots).build();
    }
    
    @Path("/booking/{bookingId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response viewBookinng(@PathParam("bookingId") int bookingId) {
		Booking booking = bookingService.getBooking(bookingId);
		return Response.ok(booking).build();
    }
    
    @Path("/booking/cancel/{bookingId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cancelBooking(@PathParam("bookingId") int bookingId) {
		if(bookingService.cancelBooking(bookingId))
			return Response.ok("Booking with ID " + bookingId + " is cancelled successfully").build();
		else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Cancel Booking failed.").build();
    }
}
