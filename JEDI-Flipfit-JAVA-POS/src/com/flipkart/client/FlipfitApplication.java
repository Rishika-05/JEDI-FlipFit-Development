/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;
import com.flipkart.service.serviceImpl.UserFlipFitServiceImpl;
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

		String userName,password;
		
		System.out.println("\n\n\033[1m---------------------------Login---------------------------\033[0m");
		System.out.println("Enter username:");
		userName=sc.next();
		System.out.println("Enter password:");
		password=sc.next();
		
		int userId = UserFlipFitServiceImpl.getInstance().login(userName, password);
		User user = UserFlipFitServiceImpl.getInstance().getUser(userId);
		if(userId == -1) return;
		
	
		
//		System.out.println("Role: \n1. Admin   \n2. Gym Customer   \n3. Gym Owner");
		RoleType userRole = UserFlipFitServiceImpl.getInstance().getUserRole(userId);
		switch(userRole) {
		case ADMIN:
			 GymAdminFlipFitMenu gymAdminFlipFitMenu = new GymAdminFlipFitMenu();
			 gymAdminFlipFitMenu.displayAdminMenu();
			break;
		case GYM_CUSTOMER:
			
			GymCustomerFlipFitMenu gymCustomerFlipFitMenu = new GymCustomerFlipFitMenu();
			gymCustomerFlipFitMenu.displayCustomerMenu(user);
			
			break;
		case GYM_OWNER:
			
			GymOwnerFlipFitMenu gymOwnerFlipFitMenu = new GymOwnerFlipFitMenu();
			gymOwnerFlipFitMenu.displayGymOwnerMenu();
			break;
			
		}	
		System.out.println("\033[1mExiting Login \033[0m");
	}
	
	static void  register() {
		boolean flag = false;
		RoleType role = null;
		String userName = "";
		String password = "";
		Scanner in=new Scanner(System.in);
		while(!flag) {
			System.out.println("\n\n\033[1m------------------Register---------------- \n\n\033[0m");
			System.out.println("Press 1. Customer Registration \nPress 2. Gym Owner Registration");

			int userRole = in.nextInt();
			while (userRole < 1 || userRole > 2) {
				System.out.println("\033[1mInvalid type please try again!!\033[0m");
				userRole = in.nextInt();
			}
			System.out.println("Enter username: ");
			userName = in.next();
			in.nextLine();
			System.out.println("Enter password: ");
			password = in.next();
			role = userRole == 1 ? RoleType.GYM_CUSTOMER : RoleType.GYM_OWNER;
			User newUser = new User();
			newUser.setPassword(password);
			newUser.setUsername(userName);
			newUser.setRole(role);
			flag = UserFlipFitServiceImpl.getInstance().registration(newUser);
		}
		switch(role) {
			case GYM_CUSTOMER:
				GymCustomer customer = new GymCustomer();
				customer.setUsername(userName);
				customer.setPassword(password);
//				
				System.out.println("Enter your full name: ");
				String name = in.next();
				in.nextLine();
				customer.setName(name);
				System.out.println("Enter your age: ");
				int age = in.nextInt();
				in.nextLine();
				customer.setAge(age);
				System.out.println("Enter your location: ");
				String location = in.next();
				in.nextLine();
				customer.setLocation(location);
				System.out.println("\n\033[1mCustomer Registered Successfully\033[0m\n");
				break;
				
			case GYM_OWNER:
				GymOwner newGymOwner = new GymOwner();
				newGymOwner.setUsername(userName);
				newGymOwner.setPassword(password);
//			
				System.out.println("Enter your name");
				name = in.next();
				in.nextLine();
				newGymOwner.setName(name);
				System.out.println("Enter your address");
				String address = in.next();
				in.nextLine();
				newGymOwner.setAddress(address);
				System.out.println("Enter your PIN code");
				String pinCode = in.next();
				in.nextLine();
				newGymOwner.setPincode(pinCode);
				String panCard,aadharCard,GstIn;
				do {
					System.out.println("Enter your panCard number. For ex - ABCTY1234D");
					panCard = in.next();
					in.nextLine();
					newGymOwner.setPanCard(panCard);
				} while(false);
				
				do {
					System.out.println("Enter your aadharCard number. For ex - 1234-1234-1234");
					aadharCard = in.next();
					in.nextLine();
					newGymOwner.setAadharCard(aadharCard);
				} while(false);
				
				do {
					System.out.println("Enter your GSTIN number. For ex - 22AAAAA0000A1Z5");
					GstIn = in.next();
					in.nextLine();
					newGymOwner.setGstin(GstIn);
					} while(false);
				
				System.out.println("\n\\033[0mGym Owner Registered!\\033[1m\n");
				break;
		default:
			break;
		}
		
		System.out.println("\033[1mExiting Register menu\033[0m");

	}
	
	static void updatePassword() {
		System.out.println("\n\n\033[1m-------------------Update Password------------------ \n\n\033[0m");
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the username!!");
		String userName = in.next();
		System.out.println("Enter old password");
		String password = in.next();
		System.out.println("Enter your new password");
		String newPassword = in.next();
		System.out.println("\n\033[0mPassword Updated Successfully!\n\033[1m\n");
	}


}
