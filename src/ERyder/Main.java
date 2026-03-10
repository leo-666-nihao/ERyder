package ERyder;
import java.util.Scanner; 

public class Main {
        public static void main(String[] args) {
        ERyder bike1 = new ERyder(101, 85, true, 15.5);
        ERyder bike2 = new ERyder("user123", "555-1234", 102, 90, true, 20.0);    
        bike1.printRideDetails(30);
        bike2.printRideDetails(45);    
        try (Scanner scanner = new Scanner(System.in)) {
            ERyder bike = new ERyder("user123", "555-1234", 0, 0, true, 0.0);

        //System.out.println("===== ERyde information input system =====\n");

        /*//  record ID
        System.out.print("Input ID: ");
        bike.setBikeID(scanner.nextInt());
        
        // input the battery remaining capacity and make a judgement
        System.out.print("Input battery level (0-100): ");
        bike.setBatteryLevel(scanner.nextInt());
        
        // input available or not
        System.out.print("Input availability (true/false): ");
        bike.setAvailable(scanner.nextBoolean());
        
        // input the km
        System.out.print("Input km driven (km): ");
        bike.setKmDriven(scanner.nextDouble());
        
        //print the bike details
        System.out.println("\n===== confirm the Bike detail =====");
        bike.printBikeDetails();
        
        //running test
        System.out.println("\n===== runing test =====");
        bike.ride();
        
        scanner.close();
    }*/
        }
    }
}