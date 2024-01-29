/**
 *
 */
package com.flipkart.client;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.Console;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;
import com.flipkart.exception.InvalidAadhaarException;
import com.flipkart.exception.InvalidPanCardException;
import com.flipkart.service.UserFlipFitService;
import com.flipkart.service.serviceImpl.GymCustomerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.UserFlipFitServiceImpl;
import com.flipkart.utils.Utils;
import com.flipkart.validators.Validator;

/**
 * Main class
 * @return void
 * 
 */
public class FlipfitApplication {

	static Utils utils = new Utils();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Utils.logo();
		displayLogo("Welcome");



        try (Scanner sc = new Scanner(System.in)) {
            int userInput;
            do {
                createMainMenu();
                userInput = sc.nextInt();
                switch (userInput) {
                    case 1:
                        login();
                        break;
                    case 2:
                        register();
                        break;
                    case 3:
                        updatePassword();
                        break;
                    case 0:
                        System.out.println("\033[1mYou have exited the FlipFit Application\033[0m");
                        break;
                    default:
                        System.out.println("\033[1;31mInvalid Option! Please try again.\033[0m");
                        break;
                }

            } while (userInput != 0);

        } catch (Exception ex) {
            System.out.println("\033[1;31mError occurred: " + ex + "\033[0m");
        }

	}
	
	/**
	 * Display logo
	 * @return void
	 * @throws Exception
	 * @param windowTitle
	 */
	
	public static void displayLogo(String windowTitle) {
		System.out.println("\033[1;34m      ▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▖\033[0m " + windowTitle + " \033[1;34m▝▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞\033[0m");
		System.out.println("");
	}

	/**
	 * Create main menu
	 * @return void
	 * @throws Exception
	 * @param
	 */

	public static void createMainMenu() {


		System.out.println("\033[1;33m Press 1: \033[0m" + "\033[1;34mLogin\033[0m");
		System.out.println("\033[1;33m Press 2: \033[0m" + "\033[1;34mRegister\033[0m");
		System.out.println("\033[1;33m Press 3: \033[0m" + "\033[1;34mUpdate Password\033[0m");
		System.out.println("\033[1;33m Press 0: \033[0m" + "\033[1;34mExit\033[0m");
		System.out.println("\033[0m"); // Reset text attributes


		System.out.print("\033[1mEnter Choice ► \033[0m");

	}

	/**
	 * Login
	 * @return void
	 * @throws Exception
	 * @param
	 */

	static void login() {
		System.out.println();
		displayLogo("Login");
		Scanner sc = new Scanner(System.in);

		String userName, password;

		System.out.print("\033[0;34mEnter username ► \033[0m");
		userName = sc.next();
		System.out.print("\033[0;34mEnter password ► \033[0m");
		password = sc.next();

		int userId = UserFlipFitServiceImpl.getInstance().login(userName, password);
		User user = UserFlipFitServiceImpl.getInstance().getUser(userId);
		if (userId == -1) {
//			System.out.println("\033[1;31mUser Not Found Please Try Again\033[0m");
			return;
		}
		System.out.print("\n");

		System.out.print("\033[0;35mミ★\033[0m \033[32m CONGRATULATIONS LOGIN SUCCUESSFUL!!!\033[0m \033[0;35m★彡 \033[0m");


		System.out.print("\n");
		System.out.print("\n");


		RoleType userRole = UserFlipFitServiceImpl.getInstance().getUserRole(userId);
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime loginTime = LocalDateTime.now();


		String formattedTime = loginTime.format(DateTimeFormatter.ofPattern("hh:mm a"));

		System.out.println("\033[1;34m───────────────────────────────\033[0m");
		System.out.println("   \033[1;36mUser:\033[0m " + userName);
		System.out.println("   \033[1;36mLogged In at:\033[0m " +  formattedTime + "\033[0m");
		System.out.println("   \033[1;36mRole:\033[0m " +  userRole.name() + "\033[0m");
		System.out.println("\033[1;34m───────────────────────────────\033[0m");



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
				gymOwnerFlipFitMenu.displayGymOwnerMenu(userId);
				break;
		}
		System.out.println("\033[1mExiting Login \033[0m");
	}

	/**
	 * Register
	 * @return void
	 * @throws Exception
	 * @param
	 */

	static void register() {
		boolean flag = false;
		RoleType role = null;
		int userId = -1;
		Scanner in = new Scanner(System.in);
		while (!flag) {
			displayLogo("Register");
			System.out.println("\033[0;32mPress 1. Customer Registration \n\033[0;32mPress 2. Gym Owner Registration");
			System.out.print("\033[1mEnter Choice ► \033[0m");

			int userRole;

			while (true) {
				if (in.hasNextInt()) {
					userRole = in.nextInt();

					if (userRole >= 1 && userRole <= 2) {
						break;
					} else {
						System.out.println("\033[1;31mInvalid type! Please try again.\033[0m");
					}
				} else {
					System.out.println("\033[1;31mInvalid input! Please enter a valid number.\033[0m");
					in.next();
				}
			}

			// Now 'userRole' contains a valid input
			System.out.println("User role selected: " + userRole);
			String username;
			String password;
			String password2;

			do {
			    System.out.print("\033[0;34mEnter username: \033[0m");
			    username = in.next();
			    in.nextLine();

			    System.out.print("\033[0;34mEnter password: \033[0m");
			    password = in.next();
			    in.nextLine();

			    System.out.print("\033[0;34mEnter password again: \033[0m");
			    password2 = in.next();
			    in.nextLine();

			    if (!password.equals(password2)) {
			        System.out.println("\033[0;31mPasswords do not match. Please try again.\033[0m");
			    }
			} while (!password.equals(password2));
			role = userRole == 1 ? RoleType.GYM_CUSTOMER : RoleType.GYM_OWNER;
			User newUser = new User();
			newUser.setPassword(password);
			newUser.setUsername(username);
			newUser.setRole(role);
			userId = UserFlipFitServiceImpl.getInstance().registration(newUser);
			flag = userId != -1;
		}
		switch (role) {
			case GYM_CUSTOMER:
				GymCustomer customer = new GymCustomer();

				System.out.print("\033[0;34mEnter your name: \033[0m");
				String name = in.nextLine();
				customer.setName(name);

				System.out.print("\033[0;34mEnter your age: \033[0m");
				int age = in.nextInt();
				in.nextLine(); // Consume newline character
				customer.setAge(age);

				System.out.print("\033[0;34mEnter your location: \033[0m");
				String location = in.nextLine();
				String formattedLocation = Utils.convertFirstLetterCapital(location);
				customer.setLocation(formattedLocation);
				String email = "", phoneNo = "";
				do {
				    System.out.print("\033[0;34mEnter your phone number: \033[0m");
				    phoneNo = in.nextLine();
				} while (!Validator.validatePhoneNo(phoneNo));

				customer.setPhoneNo(phoneNo);

				do {
				    System.out.print("\033[0;34mEnter your email: \033[0m");
				    email = in.nextLine();
				} while (!Validator.validateEmail(email));

				customer.setEmail(email);

				customer.setUserId(userId);
				if (UserFlipFitServiceImpl.getInstance().customerRegistration(customer)) {
				    System.out.println("\n\033[1mCustomer Registered Successfully\033[0m\n");

				    // Display customer details
				    System.out.println("Customer Details:");
				    String format = "︳ %-20s ︳ %-12s | %-5s | %-16s | %-12s | %-20s |";
				    Utils.printFormattedTableHeader(format, "User ID", "Name", "Age", "Location", "Phone Number", "Email");
				    Utils.printFormattedTableRow(format, String.valueOf(userId), name, String.valueOf(age), formattedLocation,
				            phoneNo, email);
				} else {
				    System.out.println("Some Error occurred");
				}
				break;
			case GYM_OWNER:
			    GymOwner newGymOwner = new GymOwner();

			    newGymOwner.setUserId(userId);
			    System.out.print("\033[0;34mEnter your name: \033[0m");
			    String fname = in.nextLine();
			    newGymOwner.setName(fname);

			    System.out.print("\033[0;34mEnter your age: \033[0m");
			    int age2 = in.nextInt();
			    in.nextLine();
			    newGymOwner.setAge(age2);

			    System.out.print("\033[0;34mEnter your location: \033[0m");
			    String address = in.nextLine();
			    String formattedAddress = Utils.convertFirstLetterCapital(address);
			    newGymOwner.setLocation(formattedAddress);

			    String panCard;
			    String aadharCard;
			    String gstin;

			    try {
			        do {
			            System.out.print("\033[0;34mEnter your PAN Card number: \033[0m");
			            panCard = in.next();
			            in.nextLine();
			        } while (!Validator.validatePanCard(panCard));

			        newGymOwner.setPanCard(panCard);

			        do {
			            System.out.print("\033[0;34mEnter your Aadhar Card number: \033[0m");
			            aadharCard = in.next();
			            in.nextLine();
			        } while (!Validator.validateAadharCard(aadharCard));

			        newGymOwner.setAadharCard(aadharCard);

			        do {
			            System.out.print("\033[0;34mEnter your GSTIN number: \033[0m");
			            gstin = in.next();
			            in.nextLine();
			        } while (!Validator.validateGstin(gstin));

			        newGymOwner.setGstin(gstin);

			        do {
			            System.out.print("\033[0;34mEnter your phone number: \033[0m");
			            phoneNo = in.nextLine();
			        } while (!Validator.validatePhoneNo(phoneNo));

			        newGymOwner.setPhoneNo(phoneNo);

			        do {
			            System.out.print("\033[0;34mEnter your email: \033[0m");
			            email = in.nextLine();
			        } while (!Validator.validateEmail(email));

			        newGymOwner.setEmail(email);

			        if (UserFlipFitServiceImpl.getInstance().gymOwnerRegistration(newGymOwner)) {
			            System.out.println("\n\033[0mGym Owner Registered!\033[1m\n");

			            // Display gym owner details
			            String format_2 = "| %-20s | %-12s | %-5s | %-16s | %-10s | %-10s | %-15s | %-15s |\n";
			            Utils.printFormattedTableHeader(format_2, "User ID", "Name", "Age", "Location", "PAN Card", "Aadhar Card", "GSTIN", "Phone Number", "Email");
			            Utils.printFormattedTableRow(format_2,
			                    String.valueOf(newGymOwner.getUserId()),
			                    newGymOwner.getName(),
			                    String.valueOf(newGymOwner.getAge()),
			                    newGymOwner.getLocation(),
			                    newGymOwner.getPanCard(),
			                    newGymOwner.getAadharCard(),
			                    newGymOwner.getGstin(),
			                    String.valueOf(newGymOwner.getPhoneNo()),
			                    newGymOwner.getEmail());
			        } else {
			            System.out.println("Some Error occurred");
			        }
			    } catch (InvalidPanCardException e) {
			        System.out.println("\033[1;31m" + e.getMessage() + "\033[0m");
			    } catch (InvalidAadhaarException e) {
			        System.out.println("\033[1;31m" + e.getMessage() + "\033[0m");
			    } catch (Exception e) {
			        System.out.println("An error occurred: " + e.getMessage());
			    }
			    break;
			default:
				break;
		}

		System.out.println("\033[1mExiting Register menu\033[0m");

	}
	

	/**
	 * Update password
	 * @return void
	 * @throws Exception
	 * @param
	 */

	static void updatePassword() {
		System.out.println("\n\n\033[1m-------------------Update Password------------------ \n\n\033[0m");
		Scanner in = new Scanner(System.in);
		System.out.print("\033[0;34mEnter the username: \033[0m");
		String username = in.next();
		System.out.print("\033[0;34mEnter old password: \033[0m");
		String oldPassword = in.next();

		String newPassword;
		String confirmPassword;

		do {
		    System.out.print("\033[0;34mEnter your new password: \033[0m");
		    newPassword = in.next();
		    System.out.print("\033[0;34mConfirm your new password: \033[0m");
		    confirmPassword = in.next();

		    if (!newPassword.equals(confirmPassword)) {
		        System.out.println("\033[0;31mPasswords do not match. Please try again.\033[0m");
		    }
		} while (!newPassword.equals(confirmPassword));

		// At this point, the new password is entered correctly

		if (UserFlipFitServiceImpl.getInstance().updatePassword(username, newPassword)) {
		    System.out.println("\n\033[0mPassword Updated Successfully!\n\033[1m\n");
		} else {
		    System.out.println("\n\033[0mUnable to update!\n\033[1m\n");
		}
	}
}
