/**
 * 
 */
package com.flipkart.rest;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.service.GymCustomerFlipFitService;
import com.flipkart.service.GymOwnerFlipFitService;
import com.flipkart.service.UserFlipFitService;
import com.flipkart.service.serviceImpl.GymCustomerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.GymOwnerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.UserFlipFitServiceImpl;

/**
 * 
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class FlipfitController {
    UserFlipFitService userService = UserFlipFitServiceImpl.getInstance();
    GymCustomerFlipFitService customerService = GymCustomerFlipFitServiceImpl.getInstance();
    GymOwnerFlipFitService ownerService = GymOwnerFlipFitServiceImpl.getInstance();
	
    
    @POST
    @Path("/register-customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerCustomer(GymCustomer customer){
		User user = new User();
		user.setUsername(customer.getUsername());
		user.setPassword(customer.getPassword());
		user.setRole(customer.getRole());
		int userId = userService.registration(user);
		if(userId == -1) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("User not registered.").build();
		}
		customer.setUserId(userId);
		if(!userService.customerRegistration(customer)) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("User not registered.").build();
		}
        return Response.ok(customerService.viewProfile(customerService.getGymCustomerId(userId))).build();
    }
	
	@POST
    @Path("/register-owner")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerOwner(GymOwner owner){
		User user = new User();
		user.setUsername(owner.getUsername());
		user.setPassword(owner.getPassword());
		user.setRole(owner.getRole());
		int userId = userService.registration(user);
		if(userId == -1) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("User not registered.").build();
		}
		owner.setUserId(userId);
		if(!userService.gymOwnerRegistration(owner)) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("User not registered.").build();
		}
        return Response.ok(ownerService.getGymOwnerById(ownerService.getGymOwnerId(userId))).build();
    }
	
	@POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user){
		int userId = userService.login(user.getUsername(), user.getPassword());
		if(userId == -1){
			return Response.status(Response.Status.UNAUTHORIZED).entity("Login Unsuccessfully, Try again !!").build();
		}
        return Response.ok("Login Successful!!! User ID: " + userId).build();
    }
	
	@POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePassword(Map<String, String> map){
		if(userService.updatePassword(map.get("username"), map.get("newPassword")))
			return Response.ok("Password Updated successfully !!").build();
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Password could not be updated.").build();
    }
}
