/**
 *
 */
package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;
import com.flipkart.service.UserFlipFitService;
import com.flipkart.service.serviceImpl.GymCustomerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.UserFlipFitServiceImpl;

/**
 *
 */
public class FlipfitApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int userInput;
		try {
			// until the user does not exit the application
			do {

				createMainMenu();
				userInput = sc.nextInt();

				switch (userInput) {
					case 1:
						// login
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
						System.out.println("\033[1;31mInvalid Option! Please try again.\033[0m");
						break;
				}

			} while (userInput != 4);

		} catch (Exception ex) {
			System.out.println("\033[1;31mError occurred: " + ex + "\033[0m");
		} finally {
			sc.close();
		}

	}

	public static void createMainMenu() {
		System.out.println("\n\n\033[1;34m----------------------- Welcome to FlipFit Gym Slot Booking Application---------------------\033[0m");
		System.out.println("\033[1;34mMenu Options: \n\033[0;34mPress 1. Login \n\033[1;32mPress 2. Register \n\033[0;32mPress 3. Update Password \n\033[1;31mPress 4. Exit\n");
		System.out.print("\033[1mEnter option: \033[0m");
	}

	static void login() {
		Scanner sc = new Scanner(System.in);

		String userName, password;

		System.out.println("\n\n\033[1m---------------------------Login---------------------------\033[0m");
		System.out.print("\033[0;34mEnter username: \033[0m");
		userName = sc.next();
		System.out.print("\033[0;34mEnter password: \033[0m");
		password = sc.next();

		int userId = UserFlipFitServiceImpl.getInstance().login(userName, password);
		User user = UserFlipFitServiceImpl.getInstance().getUser(userId);
		if (userId == -1)
			return;

		RoleType userRole = UserFlipFitServiceImpl.getInstance().getUserRole(userId);
		switch (userRole) {
			case ADMIN:
				GymAdminFlipFitMenu gymAdminFlipFitMenu = new GymAdminFlipFitMenu();
				gymAdminFlipFitMenu.displayAdminMenu();
				break;
			case GYM_CUSTOMER:
				GymCustomerFlipFitMenu gymCustomerFlipFitMenu = new GymCustomerFlipFitMenu();
				gymCustomerFlipFitMenu.displayCustomerMenu(userId);
				break;
			case GYM_OWNER:
				GymOwnerFlipFitMenu gymOwnerFlipFitMenu = new GymOwnerFlipFitMenu();
				gymOwnerFlipFitMenu.displayGymOwnerMenu();
				break;
		}
		System.out.println("\033[1mExiting Login \033[0m");
	}

	static void register() {
		boolean flag = false;
		RoleType role = null;
		String userName = "";
		String password = "";
		int userId = -1;
		Scanner in = new Scanner(System.in);
		while (!flag) {
			System.out.println("\n\n\033[1m------------------Register---------------- \n\n\033[0m");
			System.out.println("\033[0;34mPress 1. Customer Registration \n\033[0;32mPress 2. Gym Owner Registration");

			int userRole = in.nextInt();
			while (userRole < 1 || userRole > 2) {
				System.out.println("\033[1;31mInvalid type! Please try again.\033[0m");
				userRole = in.nextInt();
			}
			System.out.print("\033[0;34mEnter username: \033[0m");
			userName = in.next();
			in.nextLine();
			System.out.print("\033[0;34mEnter password: \033[0m");
			password = in.next();
			role = userRole == 1 ? RoleType.GYM_CUSTOMER : RoleType.GYM_OWNER;
			User newUser = new User();
			newUser.setPassword(password);
			newUser.setUsername(userName);
			newUser.setRole(role);
			userId = UserFlipFitServiceImpl.getInstance().registration(newUser);
			flag = userId != -1;
		}
		switch (role) {
			case GYM_CUSTOMER:
				GymCustomer customer = new GymCustomer();
				System.out.print("\033[0;34mEnter your full name: \033[0m");
				String name = in.next();
				in.nextLine();
				customer.setName(name);
				System.out.print("\033[0;34mEnter your age: \033[0m");
				int age = in.nextInt();
				in.nextLine();
				customer.setAge(age);
				System.out.print("\033[0;34mEnter your location: \033[0m");
				String location = in.next();
				in.nextLine();
				customer.setLocation(location);
				System.out.println("\n\033[1mCustomer Registered Successfully\033[0m\n");
				customer.setUserId(userId);
				if (UserFlipFitServiceImpl.getInstance().customerRegistration(customer)) {
					System.out.println("Gym Customer Registered");
				} else {
					System.out.println("Some Error occurred");
				}
				break;

			case GYM_OWNER:
				GymOwner newGymOwner = new GymOwner();
				newGymOwner.setUsername(userName);
				newGymOwner.setPassword(password);
				System.out.print("\033[0;34mEnter your name: \033[0m");
				name = in.next();
				in.nextLine();
				newGymOwner.setName(name);
				System.out.print("\033[0;34mEnter your address: \033[0m");
				String address = in.next();
				in.nextLine();
				newGymOwner.setAddress(address);
				System.out.print("\033[0;34mEnter your PIN code: \033[0m");
				String pinCode = in.next();
				in.nextLine();
				newGymOwner.setPincode(pinCode);
				String panCard, aadharCard, GstIn;
				do {
					System.out.print("\033[0;34mEnter your panCard number. For ex - ABCTY1234D: \033[0m");
					panCard = in.next();
					in.nextLine();
					newGymOwner.setPanCard(panCard);
				} while (false);

				do {
					System.out.print("\033[0;34mEnter your aadharCard number. For ex - 1234-1234-1234: \033[0m");
					aadharCard = in.next();
					in.nextLine();
					newGymOwner.setAadharCard(aadharCard);
				} while (false);

				do {
					System.out.print("\033[0;34mEnter your GSTIN number. For ex - 22AAAAA0000A1Z5: \033[0m");
					GstIn = in.next();
					in.nextLine();
					newGymOwner.setGstin(GstIn);
				} while (false);

				System.out.println("\n\033[0mGym Owner Registered!\033[1m\n");
				break;
			default:
				break;
		}

		System.out.println("\033[1mExiting Register menu\033[0m");

	}

	static void updatePassword() {
		System.out.println("\n\n\033[1m-------------------Update Password------------------ \n\n\033[0m");
		Scanner in = new Scanner(System.in);
		System.out.print("\033[0;34mEnter the username: \033[0m");
		String userName = in.next();
		System.out.print("\033[0;34mEnter old password: \033[0m");
		String password = in.next();
		System.out.print("\033[0;34mEnter your new password: \033[0m");
		String newPassword = in.next();
		System.out.println("\n\033[0mPassword Updated Successfully!\n\033[1m\n");
	}
}
