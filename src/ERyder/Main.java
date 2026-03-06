package ERyder;
import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ERyder bike = new ERyder();
        
        System.out.println("===== ERyde information input system =====\n");
        
        // 1. record ID
        System.out.print("put in ID: ");
        int bikeID = scanner.nextInt();
        bike.setBikeID(bikeID);
        
        // 2. input the battery remaining capacity and make a judgement
        System.out.print("input the battery remaining capacity (0-100): ");
        int batteryLevel = scanner.nextInt();
        bike.setBatteryLevel(batteryLevel);
        
        // 3. input available or not
        System.out.print("input whether can be used (true/false): ");
        boolean available = scanner.nextBoolean();
        bike.setAvailable(available);
        
        // 4. input the km
        System.out.print("input the km of the bike (km): ");
        double kmDriven = scanner.nextDouble();
        bike.setKmDriven(kmDriven);
        
        
        System.out.println("\n===== confirm the Bike detail =====");
        bike.printBikeDetails();
        
        
        System.out.println("\n===== runing test =====");
        bike.ride();
        
        scanner.close();
    }
}
