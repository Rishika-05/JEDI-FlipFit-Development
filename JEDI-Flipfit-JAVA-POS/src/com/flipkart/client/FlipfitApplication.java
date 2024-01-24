/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

/**
 * 
 */
public class FlipfitApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int userInput;	
//		//create the main menu
//		createMainMenu();
//		userInput=sc.nextInt();
		try
		{
			
		//until user do not exit the application
		do{
			createMainMenu();
			userInput = sc.nextInt();
			switch(userInput)
			{	
				case 1:
					//login
					login();
					break;
				case 2:
					//student registration
					register();
					break;	
				case 3:
					updatePassword();
					break;
				case 4:
					System.out.println("\033[1mYou have exited the FlipFit Application\033[0m");
                    break;
				default:
					System.out.println("Invalid Input");
			}
			
		} while(userInput != 4);
		} catch(Exception ex) {
			System.out.println("Error occured "+ex);
		}
		finally {
			sc.close();
		}
		

	}
	
	public static void createMainMenu() {
		System.out.println("------------ Welcome to FlipFit Gym Slot Booking Application------------");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Update password");
		System.out.println("4. Exit");
		System.out.println("Enter user input: ");
	}
	
	static void login() {
		//multiple exceptions are possible
		//invalid credential exception
		//user not found exception
		//user not approved exception
		Scanner sc=new Scanner(System.in);

		String userId,password;
		
		System.out.println("\n\n---------------------------Login---------------------------\n\n");
		System.out.println("Email:");
		userId=sc.next();
		System.out.println("Password:");
		password=sc.next();
		System.out.println("Role: \n1. Admin   \n2. Gym Customer   \n3. Gym Owner\n");
		int userRole =sc.nextInt();
		switch(userRole) {
		case 1:
			 GymAdminFlipFitMenu gymAdminFlipFitMenu = new GymAdminFlipFitMenu();
//			 gymAdminFlipFitMenu.displayAdminMenu();
			break;
		case 2:
			
			GymCustomerFlipFitMenu gymCustomerFlipFitMenu = new GymCustomerFlipFitMenu();
			gymCustomerFlipFitMenu.displayCustomerMenu();
			
			break;
		case 3:
			
			GymOwnerFlipFitMenu gymOwnerFlipFitMenu = new GymOwnerFlipFitMenu();
			gymOwnerFlipFitMenu.displayGymOwnerMenu();
			
			break;	
			
		}	
	}
	
	static void  register() {
		
		Scanner in=new Scanner(System.in);
		System.out.println("\n\n ------------- Please enter the type of user ----------- \n\n");
		System.out.println("Press 1. Customer \nPress 2. GymOwner");

		int userRole = in.nextInt();
		while (userRole < 1 || userRole > 2) {
			System.out.println("\033[1mInvalid type please try again!!\033[0m");
			userRole = in.nextInt();
		}
		System.out.println("Please Enter the username");
		String userName = in.next();
		System.out.println("Please Enter the password");
		String password = in.next();
		String role = userRole == 1 ? "CUSTOMER" : "OWNER";
		switch(role) {
			case "CUSTOMER":
				GymCustomer customer = new GymCustomer();
				customer.setUsername(userName);
				customer.setPassword(password);
				customer.setRole(role);
				System.out.println("Please Enter you full name");
				String name = in.next();
				customer.setName(name);
				System.out.println("Please Enter your age");
				int age = in.nextInt();
				customer.setAge(age);
				System.out.println("Please enter your location");
				String location = in.next();
				customer.setLocation(location);
				System.out.println("Customer Registered Successfully");
				break;
				
			case "OWNER":
				
				GymOwner newGymOwner = new GymOwner();
				newGymOwner.setUsername(userName);
				newGymOwner.setPassword(password);
				newGymOwner.setRole(role);
				System.out.println("Please enter your name");
				name = in.next();
				newGymOwner.setName(name);
				System.out.println("Please enter your address");
				String address = in.next();
				newGymOwner.setAddress(address);
				System.out.println("Please enter your PIN code");
				String pinCode = in.next();
				newGymOwner.setPincode(pinCode);
				String panCard,aadharCard,GstIn;
				do {
					System.out.println("Please Enter your panCard number. For ex - ABCTY1234D");
					panCard = in.next();
					newGymOwner.setPanCard(panCard);
				} while(false);
				
				do {
					System.out.println("Please Enter your aadharCard number. For ex - 1234-1234-1234");
					aadharCard = in.next();
					newGymOwner.setAadharCard(aadharCard);
				} while(false);
				
				do {
					System.out.println("Please Enter your GstIn number. For ex - 22AAAAA0000A1Z5");
					GstIn = in.next();
					newGymOwner.setGstin(GstIn);
					} while(false);
				
				System.out.println("Owner Registered Successfully!");
				break;
		}
		
		System.out.println("\033[1mExiting register menu\033[0m");

	}
	
	static void updatePassword() {
		Scanner in=new Scanner(System.in);
		System.out.println("Please enter the username!!");
		String userName = in.next();
		System.out.println("Please enter your old password");
		String password = in.next();
		System.out.println("Password Updated Successfully!");
	}


}
