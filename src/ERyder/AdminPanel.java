package ERyder;

import java.util.List;
import java.util.Scanner;

public class AdminPanel {

    private final UserService userService = new UserService();
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
        BikeService bikeService = new BikeService();
        RentalService rentalService = new RentalService();

        System.out.print("State if the user is a registered user (true/false): ");
        String registeredInput = scanner.nextLine();
        boolean isRegistered = "true".equalsIgnoreCase(registeredInput);

        System.out.print("Enter the email address of the user: ");
        String email = scanner.nextLine();

        System.out.print("Enter the location of the bike: ");
        String location = scanner.nextLine();

        System.out.println("\nSimulating the analysis of the rental request...");
        if (isRegistered) {
            System.out.println("Welcome back, " + email + "!");
        } else {
            System.out.println("You are not a registered user. Proceeding as a guest.");
        }
        if (!bikeService.validateLocation(location) || !bikeService.findAvailableBikeAt(location)) {
            System.out.println("No bikes available at the given location.");
            return;
        }
        System.out.println("A bike is available at the location you requested.");

        System.out.println("\nSimulating bike reservation...");
        String bikeId = bikeService.reserveBike(location);
        System.out.println("Reserving bike with ID: " + bikeId);
        System.out.println("Please follow the on-screen direction to locate your bike and start your trip.");

        String record = rentalService.startRental(bikeId, email);

        System.out.println("\nDisplaying the active rentals...");
        System.out.println("Active Rentals:");
        if (rentalService.getActiveRentals().isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            System.out.println("Bike(s) Currently In Use:");
            for (String r : rentalService.getActiveRentals()) {
                System.out.println(r);
            }
        }

        System.out.print("\nPress Enter to end the trip...");
        scanner.nextLine();

        System.out.println("\nSimulating trip end...");
        rentalService.endRental(bikeId, email);
        bikeService.releaseBike(bikeId);
        System.out.println("Your trip has ended. Thank you for riding with us!");

        System.out.println("\nDisplaying the active rentals after trip end...");
        System.out.println("No active rentals at the moment.");
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
        
        userService.addUser(newUser);
        System.out.println("\nUser " + fullName + " added successfully!");
    }

    private void viewRegisteredUsers() {
        List<RegisteredUsers> list = userService.getAllUsers();
        if (list.isEmpty()) {
            System.out.println("No registered users to display");
            return;
        }
        
        System.out.println("\n=== Registered Users List ===");
        int userCount = 1;
        
        for (RegisteredUsers user : list) {
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
        if (userService.getAllUsers().isEmpty()) {
            System.out.println("No registered users to remove");
            return;
        }
        
        System.out.println("\n=== Remove User ===");
        System.out.print("Please enter the email address of the user to remove: ");
        String emailAddress = scanner.nextLine();
        
        boolean removed = userService.removeByEmail(emailAddress);
        if (removed) {
            System.out.println("User " + emailAddress + " removed successfully!");
        } else {
            System.out.println("No user found with this email address");
        }
    }

    private void updateRegisteredUsers() {
        if (userService.getAllUsers().isEmpty()) {
            System.out.println("No registered users to update");
            return;
        }
        
        System.out.println("\n=== Update User Information ===");
        System.out.print("Please enter the email address of the user to update: ");
        String emailAddress = scanner.nextLine();
        
        RegisteredUsers existing = userService.findByEmail(emailAddress);
        if (existing == null) {
            System.out.println("No user found with this email address");
            return;
        }
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
        
        String[] lastThreeTrips = existing.getLastThreeTrips();
        
        RegisteredUsers updatedUser = new RegisteredUsers(
            fullName, newEmailAddress, dateOfBirth, userType,
            cardNumber, cardExpiryDate, cardProvider, cvv,
            lastThreeTrips
        );
        
        boolean ok = userService.updateByEmail(emailAddress, updatedUser);
        if (ok) {
            System.out.println("User information updated successfully!");
        } else {
            System.out.println("Update failed.");
        }
    }
}
