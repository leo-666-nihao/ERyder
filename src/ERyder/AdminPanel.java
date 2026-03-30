package ERyder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {

    private List<RegisteredUsers> registeredUsersList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public void userManagementOptions() {
        boolean exit = false;
        
        while (!exit) {
            printMenu();
            System.out.print("Please enter your choice: ");
            
            String choice = scanner.nextLine().trim();
            if (choice.isEmpty()) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            
            switch (choice) {
                case "1":
                    addNewUsers();
                    break;
                case "2":
                    viewRegisteredUsers();
                    break;
                case "3":
                    removeRegisteredUsers();
                    break;
                case "4":
                    updateRegisteredUsers();
                    break;
                case "5":
                    demoBikeRentalSystem();
                    break;
                case "6":
                    System.out.println("Exiting the program. Goodbye!");
                    exit = true;
                    break;
                case "q":
                    System.out.println("Exiting the program. Goodbye!");
                    exit = true;
                    break;
                case "Q":
                    System.out.println("Exiting the program. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }
        }
    }
     private void printMenu() {
        System.out.println("\nWelcome to E-Ryder Administrator Panel.");
        System.out.println("What do you want to do?");
        System.out.println("1. Add New Users");
        System.out.println("2. View Registered Users");
        System.out.println("3. Remove Registered Users");
        System.out.println("4. Update Registered Users");
        System.out.println("5. Demo Bike Rental System");
        System.out.println("6. EXIT");
    }
     private void demoBikeRentalSystem() {
        System.out.println("\n=== Demo Bike Rental System ===");
        BikeRental rental = new BikeRental();
        rental.simulateApplication();
    }
    private void addNewUsers() {
        System.out.println("=== Add New User ===");
        
        System.out.print("Please enter user full name: ");
        String fullName = scanner.nextLine();
        
        System.out.print("Please enter email address: ");
        String emailAddress = scanner.nextLine();
        
        System.out.print("Please enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        
        System.out.print("Please enter user type (Regular User/VIP User): ");
        String userType = scanner.nextLine();
        
        System.out.print("Please enter card number: ");
        String cardNumber = scanner.nextLine();
        
        System.out.print("Please enter card expiry date (MM/YY): ");
        String cardExpiryDate = scanner.nextLine();
        
        System.out.print("Please enter card provider (VISA/MasterCard/American Express): ");
        String cardProvider = scanner.nextLine();
        
        System.out.print("Please enter CVV: ");
        String cvv = scanner.nextLine();

        String[] lastThreeTrips = new String[3];
        System.out.println("\nPlease enter last three trips information:");
        
        for (int j = 0; j < 3; j++) {
            System.out.println("\n--- Trip " + (j + 1) + " ---");
            
            System.out.print("Please enter trip date (YYYY-MM-DD): ");
            String tripDate = scanner.nextLine();
            
            System.out.print("Please enter source (e.g., NJIT Gate 5): ");
            String source = scanner.nextLine();
            
            System.out.print("Please enter destination (e.g., Wending Square): ");
            String destination = scanner.nextLine();
            
            System.out.print("Please enter fare (€): ");
            String fare = scanner.nextLine();
            
            System.out.print("Please enter user feedback (press Enter to skip): ");
            String feedback = scanner.nextLine();
            if (feedback.isEmpty()) {
                feedback = "NULL";
            }
            
            StringBuilder tripInfo = new StringBuilder();
            tripInfo.append("Date: ").append(tripDate)
                    .append(", Source: ").append(source)
                    .append(", Destination: ").append(destination)
                    .append(", Fare (€): ").append(fare)
                    .append(", Feedback: ").append(feedback);
            
            lastThreeTrips[j] = tripInfo.toString();
        }
        
        RegisteredUsers newUser = new RegisteredUsers(
            fullName, emailAddress, dateOfBirth, userType,
            cardNumber, cardExpiryDate, cardProvider, cvv,
            lastThreeTrips
        );
        
        registeredUsersList.add(newUser);
        System.out.println("\nUser " + fullName + " added successfully!");
    }

    private void viewRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to display");
            return;
        }
        
        System.out.println("\n=== Registered Users List ===");
        int userCount = 1;
        
        for (RegisteredUsers user : registeredUsersList) {
            System.out.println("\n--- User " + userCount + " ---");
            System.out.println("Full Name: " + user.getFullName());
            System.out.println("Email Address: " + user.getEmailAddress());
            System.out.println("Date of Birth: " + user.getDateOfBirth());
            System.out.println("User Type: " + user.getUserType());
            System.out.println("Card Number: " + user.getCardNumber());
            System.out.println("Card Expiry Date: " + user.getCardExpiryDate());
            System.out.println("Card Provider: " + user.getCardProvider());
            System.out.println("CVV: " + user.getCvv());
            
            System.out.println("Last Three Trips:");
            String[] trips = user.getLastThreeTrips();
            if (trips != null) {
                for (int i = 0; i < trips.length; i++) {
                    if (trips[i] != null && !trips[i].isEmpty()) {
                        System.out.println("  Trip " + (i + 1) + ": " + trips[i]);
                    } else {
                        System.out.println("  Trip " + (i + 1) + ": No record");
                    }
                }
            }
            
            userCount++;
        }
    }

    private void removeRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to remove");
            return;
        }
        
        System.out.println("\n=== Remove User ===");
        System.out.print("Please enter the email address of the user to remove: ");
        String emailAddress = scanner.nextLine();
        
        boolean found = false;
        
        Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();
        while (iterator.hasNext()) {
            RegisteredUsers user = iterator.next();
            if (user.getEmailAddress().equals(emailAddress)) {
                iterator.remove();
                System.out.println("User " + emailAddress + " removed successfully!");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("No user found with this email address");
        }
    }

    private void updateRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to update");
            return;
        }
        
        System.out.println("\n=== Update User Information ===");
        System.out.print("Please enter the email address of the user to update: ");
        String emailAddress = scanner.nextLine();
        
        boolean found = false;
        
        for (int i = 0; i < registeredUsersList.size(); i++) {
            if (registeredUsersList.get(i).getEmailAddress().equals(emailAddress)) {
                System.out.println("User found, please enter new information:");
                
                System.out.print("New full name: ");
                String fullName = scanner.nextLine();
                
                System.out.print("New email address: ");
                String newEmailAddress = scanner.nextLine();
                
                System.out.print("New date of birth (YYYY-MM-DD): ");
                String dateOfBirth = scanner.nextLine();
                
                System.out.print("New user type: ");
                String userType = scanner.nextLine();
                
                System.out.print("New card number: ");
                String cardNumber = scanner.nextLine();
                
                System.out.print("New card expiry date (MM/YY): ");
                String cardExpiryDate = scanner.nextLine();
                
                System.out.print("New card provider: ");
                String cardProvider = scanner.nextLine();
                
                System.out.print("New CVV: ");
                String cvv = scanner.nextLine();
                
                String[] lastThreeTrips = registeredUsersList.get(i).getLastThreeTrips();
                
                RegisteredUsers updatedUser = new RegisteredUsers(
                    fullName, newEmailAddress, dateOfBirth, userType,
                    cardNumber, cardExpiryDate, cardProvider, cvv,
                    lastThreeTrips
                );
                
                registeredUsersList.set(i, updatedUser);
                System.out.println("User information updated successfully!");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("No user found with this email address");
        }
    }

    public List<RegisteredUsers> getRegisteredUsersList() {
        return registeredUsersList;
    }
}
