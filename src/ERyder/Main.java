package ERyder;
import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ERyder bike = new ERyder();
        
        System.out.println("===== ERyde information input system =====\n");
        
        //  record ID
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
    }
}
