/**
 *
 */
package com.flipkart.client;

import java.io.Console;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constant.RoleType;
import com.flipkart.service.UserFlipFitService;
import com.flipkart.service.serviceImpl.GymCustomerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.UserFlipFitServiceImpl;
import com.flipkart.utils.Utils;

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
		System.out.println("\033[1;34m          ░▒▓▓▓▓▓▓▓▓▓▒░  \033[0m");
		System.out.println("\033[1;34m       ▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒   \033[0m");
		System.out.println("\033[1;34m     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒   \033[0m");
		System.out.println("\033[1;34m   ░▓▓▓▓▒\033[0m" + "\033[1;33m░░░░░░░░░░░░░░░\033[0m" + "\033[1;34m▒▓▓▓▓         \033[0m");
		System.out.println("\033[1;34m  ░▓▓▓▓\033[0m" + "\033[1;33m░░░░░░░░░░░░░░░░░░░\033[0m" + "\033[1;34m▓▓▓▓░          \033[0m");
		System.out.println("\033[1;34m  ▓▓▓▓▒\033[0m" + "\033[1;33m░░░░░░░░░░░░░░░░░░░\033[0m" + "\033[1;34m▒▓▓▓▓          \033[0m");
		System.out.println("\033[1;34m ░▓▓▓▓▒\033[0m" + "\033[1;33m░░░░░░░░░░░░░░░░░░░\033[0m" + "\033[1;34m▒▓▓▓▓░         \033[0m" + "\033[1;33m███████╗██╗     ██╗██████╗ \033[0m" + "\033[1;34m███████╗██╗████████╗\033[0m");
		System.out.println("\033[1;34m ▒▓▓▓▓▒\033[0m" + "\033[1;33m░░░░░░░░░░░░\033[0m" + "\033[1;34m▒▓▓▓▓▒\033[0m" + "\033[1;33m░\033[0m" + "\033[1;34m▒▓▓▓▓▒         \033[0m" + "\033[1;33m██╔════╝██║     ██║██╔══██╗\033[0m" + "\033[1;34m██╔════╝██║╚══██╔══╝\033[0m");
		System.out.println("\033[1;34m ▒▓▓▓▓▒\033[0m" + "\033[1;33m░░░░░░░░░░░\033[0m" + "\033[1;34m▓▓▓▒\033[0m" + "\033[1;33m░░░░\033[0m" + "\033[1;34m▒▓▓▓▓▒         \033[0m" + "\033[1;33m█████╗  ██║     ██║██████╔╝\033[0m" + "\033[1;34m█████╗  ██║   ██║\033[0m");
		System.out.println("\033[1;34m ░▓▓▓▓▒\033[0m" + "\033[1;33m░░░░░░░░░░\033[0m" + "\033[1;34m▒▓▓▒\033[0m" + "\033[1;33m░░░░░\033[0m" + "\033[1;34m▒▓▓▓▓░         \033[0m" + "\033[1;33m██╔══╝  ██║     ██║██╔═══╝ \033[0m" + "\033[1;34m██╔══╝  ██║   ██║\033[0m");
		System.out.println("\033[1;34m  ▓▓▓▓▒\033[0m" + "\033[1;33m░░░░░░\033[0m" + "\033[1;34m▒▓▓▓▓▓▓▓▓▒\033[0m" + "\033[1;33m░░░\033[0m" + "\033[1;34m▒▓▓▓▓          \033[0m" + "\033[1;33m██║     ███████╗██║██║     \033[0m" + "\033[1;34m██║     ██║   ██║\033[0m");
		System.out.println("\033[1;34m  ░▓▓▓▒\033[0m" + "\033[1;33m░░░░░░░░░\033[0m" + "\033[1;34m▒▓▓▓▒\033[0m" + "\033[1;33m░░░░░\033[0m" + "\033[1;34m▒▓▓▓░          \033[0m" + "\033[1;33m╚═╝     ╚══════╝╚═╝╚═╝     \033[0m" + "\033[1;34m╚═╝     ╚═╝   ╚═╝\033[0m");
		System.out.println("\033[1;34m   ░▓▓▓\033[0m" + "\033[1;33m░░░░░░░░░\033[0m" + "\033[1;34m▓▓▓▒\033[0m" + "\033[1;33m░░░░░░\033[0m" + "\033[1;34m▓▓▓            \033[0m");
		System.out.println("\033[1;34m     ▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒             \033[0m");
		System.out.println("\033[1;34m       ▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒               \033[0m");
		System.out.println("\033[1;34m          ░▒▓▓▓▓▓▓▓▓▓▒░\033[0m");


		System.out.println("");
		System.out.println("");
		System.out.println("");
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
		System.out.println("\033[1;33m Press 4: \033[0m" + "\033[1;34mExit\033[0m");
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
			System.out.println("\033[1;31mUser Not Found Please Try Again\033[0m");
			return;
		}
		System.out.print("\n");

		System.out.print("\033[0;35mミ★\033[0m \033[32m CONGRATULATIONS LOGIN SUCCUESSFUL!!!\033[0m \033[0;35m★彡 \033[0m");


		System.out.print("\n");
		System.out.print("\n");


		RoleType userRole = UserFlipFitServiceImpl.getInstance().getUserRole(userId);
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		System.out.println("Welcome " + userName +" As " + userRole.name() + " LoggedIn time: " + localTime.format(DateTimeFormatter.ofPattern("HH : mm a")) + " on " + localDate.getMonth() + " " + localDate.getDayOfMonth() );
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
		String userName = "";
		String password = "";
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
				System.out.print("\033[0;34mEnter your name: \033[0m");
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
				String formattedLocation = Utils.convertFirstLetterCapital(location);
				customer.setLocation(formattedLocation);



				customer.setUserId(userId);
				if (UserFlipFitServiceImpl.getInstance().customerRegistration(customer)) {
					System.out.println("Gym Customer Registered Successfully");
				} else {
					System.out.println("Some Error occurred");
				}

				System.out.println("Customer Details:");
				String format = "︳ %-20s ︳ %-12s | %-5s | %-16s |";
				Utils.printFormattedTableHeader(format, "User ID", "Name", "Age", "Location");
				Utils.printFormattedTableRow(format, String.valueOf(userId), name, String.valueOf(age), formattedLocation);

				break;

			case GYM_OWNER:
				GymOwner newGymOwner = new GymOwner();
				newGymOwner.setUserId(userId);
				System.out.print("\033[0;34mEnter your name: \033[0m");
				name = in.next();
				in.nextLine();
				newGymOwner.setName(name);
				System.out.print("\033[0;34mEnter your age: \033[0m");
				int age1 = in.nextInt();
				in.nextLine();
				newGymOwner.setAge(age1);
				System.out.print("\033[0;34mEnter your location: \033[0m");
				String address = in.next();
				in.nextLine();
				String formattedAddress = Utils.convertFirstLetterCapital(address);
				newGymOwner.setLocation(formattedAddress);
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
				if (UserFlipFitServiceImpl.getInstance().gymOwnerRegistration(newGymOwner)) {
					System.out.println("\n\033[0mGym Customer Registered Successfully!\033[1m\n");
				} else {
					System.out.println("Some Error occurred");
				}


				String format_2 = "| %-20s | %-12s | %-5s | %-16s | %-10s | %-10s | %-15s |";
				Utils.printFormattedTableHeader(format_2, "User ID", "Name", "Age", "Location", "PAN Card", "Aadhar Card", "GSTIN");
				Utils.printFormattedTableRow(format_2,
						String.valueOf(newGymOwner.getUserId()),
						newGymOwner.getName(),
						String.valueOf(newGymOwner.getAge()),
						newGymOwner.getLocation(),
						newGymOwner.getPanCard(),
						newGymOwner.getAadharCard(),
						newGymOwner.getGstin());
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
		String userName = in.next();
		System.out.print("\033[0;34mEnter old password: \033[0m");
		String password = in.next();
		System.out.print("\033[0;34mEnter your new password: \033[0m");
		String newPassword = in.next();
		if(UserFlipFitServiceImpl.getInstance().updatePassword(userName, newPassword))
			System.out.println("\n\033[0mPassword Updated Successfully!\n\033[1m\n");
		else
			System.out.println("\n\033[0mUnable to update!\n\033[1m\n");
	}
}
