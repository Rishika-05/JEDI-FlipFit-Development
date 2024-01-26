package com.flipkart.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestApp {
    private static Map<String, User> userCredentials = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to User Management System");

        int choice;
        do {
            try {
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Update Password");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                // Validate that the input is an integer
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character left by nextInt()

                switch (choice) {
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
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine();  // Consume the invalid input
                choice = 0;  // Reset choice to trigger re-entry into the loop
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void login() {
        if (userCredentials.isEmpty()) {
            System.out.println("No users available. Register first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userCredentials.containsKey(username) && userCredentials.get(username).getPassword().equals(password)) {
            User user = userCredentials.get(username);
            System.out.println("Login successful! User Role: " + user.getRole());
            displayMenu(user.getRole());
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();

        // Check if the username is already taken
        if (userCredentials.containsKey(username)) {
            System.out.println("Username is already taken. Please choose a different username.");
            return;
        }

        System.out.print("Enter new password: ");
        String password = scanner.nextLine();

        System.out.println("Select Role:");
        System.out.println("1. Gym Customer");
        System.out.println("2. Gym Owner");
        System.out.println("3. Gym Admin");
        System.out.print("Enter your choice: ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character left by nextInt()

        UserRole role = null;
        switch (roleChoice) {
            case 1:
                role = UserRole.GYM_CUSTOMER;
                break;
            case 2:
                role = UserRole.GYM_OWNER;
                break;
            case 3:
                role = UserRole.GYM_ADMIN;
                break;
            default:
                System.out.println("Invalid role choice. Defaulting to Gym Customer.");
                role = UserRole.GYM_CUSTOMER;
        }

        userCredentials.put(username, new User(username, password, role));
        System.out.println("Registration successful! User Role: " + role);
    }

    private static void updatePassword() {
        if (userCredentials.isEmpty()) {
            System.out.println("No users available. Register first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (userCredentials.containsKey(username)) {
            System.out.print("Enter old password: ");
            String oldPassword = scanner.nextLine();

            if (userCredentials.get(username).getPassword().equals(oldPassword)) {
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                userCredentials.get(username).setPassword(newPassword);
                System.out.println("Password updated successfully!");
            } else {
                System.out.println("Incorrect old password. Password update failed.");
            }
        } else {
            System.out.println("Username not found. Please register first.");
        }
    }

    private static void displayMenu(UserRole role) {
        switch (role) {
            case GYM_CUSTOMER:
                displayCustomerMenu();
                break;
            case GYM_OWNER:
                displayOwnerMenu();
                break;
            case GYM_ADMIN:
                displayAdminMenu();
                break;
            default:
                System.out.println("Invalid role.");
        }
    }

    private static void displayCustomerMenu() {
        boolean customerLoggedIn = true;
        Scanner scanner = new Scanner(System.in);

        while (customerLoggedIn) {
            System.out.println("\n\033[1;34mPress 1. Browse Gyms" +
                    "\nPress 2. View Gym Details " +
                    "\nPress 3. Book a Slot " +
                    "\nPress 4. Cancel Booking " +
                    "\nPress 5. View Booking History " +
                    "\nPress 6. Modify Booking" +
                    "\nPress 7. View Profile" +
                    "\nPress 8. Update Profile" +
                    "\nPress 9. Browse Waitlist" +
                    "\nPress 10. Cancel Waitlist" +
                    "\nPress 11. Payment" +
                    "\nPress 12. Logout" +
                    "\nPress 13. Exit\033[0m");

            System.out.print("Enter your choice: ");
            int customerChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (customerChoice) {
                case 1:
                    browseGyms();
                    break;
                case 2:
                    viewGymDetails();
                    break;
                case 3:
                    bookSlot();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    viewBookingHistory();
                    break;
                case 6:
                    modifyBooking();
                    break;
                case 7:
                    viewProfile();
                    break;
                case 8:
                    updateProfile();
                    break;
                case 9:
                    browseWaitlist();
                    break;
                case 10:
                    cancelWaitlist();
                    break;
                case 11:
                    payment();
                    break;
                case 12:
                    System.out.println("Logging out...");
                    customerLoggedIn = false;
                    break;
                case 13:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 13.");
            }
        }
    }

    private static void browseGyms() {
        System.out.println("Selected option: Browse Gyms");
    }

    private static void viewGymDetails() {
        System.out.println("Selected option: View Gym Details");
    }

    private static void bookSlot() {
        System.out.println("Selected option: Book a Slot");
    }

    private static void cancelBooking() {
        System.out.println("Selected option: Cancel Booking");
    }

    private static void viewBookingHistory() {
        System.out.println("Selected option: View Booking History");
    }

    private static void modifyBooking() {
        System.out.println("Selected option: Modify Booking");
    }

    private static void viewProfile() {
        System.out.println("Selected option: View Profile");
    }

    private static void updateProfile() {
        System.out.println("Selected option: Update Profile");
    }

    private static void browseWaitlist() {
        System.out.println("Selected option: Browse Waitlist");
    }

    private static void cancelWaitlist() {
        System.out.println("Selected option: Cancel Waitlist");
    }

    private static void payment() {
        System.out.println("Selected option: Payment");
    }


    private static void displayOwnerMenu() {
        System.out.println("\nPress 1. Add a new gym Centre" +
                "\nPress 2. View Registered Gyms" +
                "\nPress 3. Remove Gym" +
                "\nPress 4. Modify Gym" +
                "\nPress 5. Register Slots " +
                "\nPress 6. Modify Slots " +
                "\nPress 7. View Slots " +
                "\nPress 8. Remove Slots " +
                "\nPress 9. View Profile" +
                "\nPress 10. Update Profile" +
                "\nPress 11. Quit \n");
    }

    private static void displayAdminMenu() {
        System.out.println("\n2.⁠ ⁠View Requests" +
                "\n3.⁠ ⁠Add Slots" +
                "\n4.⁠ ⁠Add Gym" +
                "\n5.⁠ ⁠Remove Slots" +
                "\n6.⁠ ⁠View Gyms" +
                "\n8.⁠ ⁠Approval Status" +
                "\n9.⁠ ⁠View Slots" +
                "\n10.⁠ ⁠Verify Payments" +
                "\n11.⁠ ⁠Browse Gym Registrations" +
                "\n12.⁠ ⁠Validate Credentials" +
                "\n13.⁠ ⁠Create Login Details" +
                "\n14.⁠ ⁠Exit");
    }
}

class User {
    private String username;
    private String password;
    private UserRole role;

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

enum UserRole {
    GYM_CUSTOMER,
    GYM_OWNER,
    GYM_ADMIN
}