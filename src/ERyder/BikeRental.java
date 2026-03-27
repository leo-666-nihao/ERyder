package ERyder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BikeRental {
    private static final Scanner scanner = new Scanner(System.in);
    private final List<String> activeRentals = new ArrayList<>();

    public void simulateApplication() {
        System.out.println("This is a simulation of the bike rental process.");

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
        System.out.println("A bike is available at the location you requested.");

        System.out.println("\nSimulating bike reservation...");
        String bikeId = "B105";
        System.out.println("Reserving bike with ID: " + bikeId);
        System.out.println("Please follow the on-screen direction to locate your bike and start your trip.");

        LocalDateTime startTime = LocalDateTime.now();
        activeRentals.add("Bike ID: " + bikeId + ", User Email: " + email + ", Trip Start Time=" + startTime);

        System.out.println("\nDisplaying the active rentals...");
        System.out.println("Active Rentals:");
        if (activeRentals.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            System.out.println("Bike(s) Currently In Use:");
            for (String r : activeRentals) {
                System.out.println(r);
            }
        }

        System.out.print("\nPress Enter to end the trip...");
        scanner.nextLine();

        System.out.println("\nSimulating trip end...");
        System.out.println("Your trip has ended. Thank you for riding with us!");
        activeRentals.clear();

        System.out.println("\nDisplaying the active rentals after trip end...");
        System.out.println("No active rentals at the moment.");
    }
}
