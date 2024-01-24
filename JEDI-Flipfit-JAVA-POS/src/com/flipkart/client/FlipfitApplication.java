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
		try {
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
					// registration
					register();
					break;
				case 3:
					updatePassword();
					break;
				case 4:
					System.out.println("\033[1mYou have exited the FlipFit Application\033[0m");
                    break;
				default:
					System.out.println("\\033[1mInvalid Option Please try again!!\\033[0m");
					break;
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
		System.out.println("\n\n\033[1m----------------------- Welcome to FlipFit Gym Slot Booking Application---------------------\033[0m");
		System.out.println("Menu Options: \nPress 1. Login \nPress 2. Register \nPress 3. Update Password \nPress 4. Exit\n");
		System.out.println("\033[1mEnter option: \033[0m");
	}
	
	static void login() {
		//multiple exceptions are possible
		//invalid credential exception
		//user not found exception
		//user not approved exception
		Scanner sc=new Scanner(System.in);

		String userId,password;
		
		System.out.println("\n\n---------------------------Login---------------------------");
		System.out.println("Email:");
		userId=sc.next();
		System.out.println("Password:");
		password=sc.next();
		System.out.println("Role: \n1. Admin   \n2. Gym Customer   \n3. Gym Owner");
		int userRole =sc.nextInt();
		switch(userRole) {
		case 1:
			 GymAdminFlipFitMenu gymAdminFlipFitMenu = new GymAdminFlipFitMenu();
			 gymAdminFlipFitMenu.displayAdminMenu();
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
		System.out.println("Press 1. Customer Registration \nPress 2. Gym Owner Registration");

		int userRole = in.nextInt();
		while (userRole < 1 || userRole > 2) {
			System.out.println("\033[1mInvalid type please try again!!\033[0m");
			userRole = in.nextInt();
		}
		System.out.println("Please Enter the username: ");
		String userName = in.next();
		in.nextLine();
		System.out.println("Please Enter the password: ");
		String password = in.next();
		in.nextLine();
		String role = userRole == 1 ? "CUSTOMER" : "OWNER";
		switch(role) {
			case "CUSTOMER":
				GymCustomer customer = new GymCustomer();
				customer.setUsername(userName);
				customer.setPassword(password);
				customer.setRole(role);
				System.out.println("Please Enter you full name: ");
				String name = in.next();
				in.nextLine();
				customer.setName(name);
				System.out.println("Please Enter your age: ");
				int age = in.nextInt();
				in.nextLine();
				customer.setAge(age);
				System.out.println("Please enter your location: ");
				String location = in.next();
				in.nextLine();
				customer.setLocation(location);
				System.out.println("\n\033[1mCustomer Registered Successfully\033[0m\n");
				break;
				
			case "OWNER":
				
				GymOwner newGymOwner = new GymOwner();
				newGymOwner.setUsername(userName);
				newGymOwner.setPassword(password);
				newGymOwner.setRole(role);
				System.out.println("Please enter your name");
				name = in.next();
				in.nextLine();
				newGymOwner.setName(name);
				System.out.println("Please enter your address");
				String address = in.next();
				in.nextLine();
				newGymOwner.setAddress(address);
				System.out.println("Please enter your PIN code");
				String pinCode = in.next();
				in.nextLine();
				newGymOwner.setPincode(pinCode);
				String panCard,aadharCard,GstIn;
				do {
					System.out.println("Please Enter your panCard number. For ex - ABCTY1234D");
					panCard = in.next();
					in.nextLine();
					newGymOwner.setPanCard(panCard);
				} while(false);
				
				do {
					System.out.println("Please Enter your aadharCard number. For ex - 1234-1234-1234");
					aadharCard = in.next();
					in.nextLine();
					newGymOwner.setAadharCard(aadharCard);
				} while(false);
				
				do {
					System.out.println("Please Enter your GstIn number. For ex - 22AAAAA0000A1Z5");
					GstIn = in.next();
					in.nextLine();
					newGymOwner.setGstin(GstIn);
					} while(false);
				
				System.out.println("\n\\033[0mOwner Registered Successfully!\\033[1m\n");
				break;
		}
		
		System.out.println("\033[1mExiting Register menu\033[0m");

	}
	
	static void updatePassword() {
		Scanner in=new Scanner(System.in);
		System.out.println("Please enter the username!!");
		String userName = in.next();
		System.out.println("Please enter your old password");
		String password = in.next();
		System.out.println("Please enter your new password");
		String newPassword = in.next();
		System.out.println("\n\033[0mPassword Updated Successfully!\n\033[1m\n");
	}


}
