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
        
        // 3. 输入是否可用
        System.out.print("input whether can be used (true/false): ");
        boolean available = scanner.nextBoolean();
        bike.setAvailable(available);
        
        // 4. 输入行驶里程
        System.out.print("input the km of the bike (km): ");
        double kmDriven = scanner.nextDouble();
        bike.setKmDriven(kmDriven);
        
        // 5. 调用 printBikeDetails() 统一输出
        System.out.println("\n===== confirm the Bike detail =====");
        bike.printBikeDetails();
        
        // 6. 测试 ride() 方法
        System.out.println("\n===== runing test =====");
        bike.ride();
        
        scanner.close();
    }
}
