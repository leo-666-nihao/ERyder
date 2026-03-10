package ERyder;
public class ERyder {
    private String userId;
    private String phone;
    
    //Constants
    public static final String COMPANY_NAME = "ERyder";
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;
    
    // Variables
    private int bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
   
    
    public ERyder(int bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.userId = "default_account";
        this.phone = "default_phone";
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }

    //Constructor
    public ERyder(String linkedAccount, String linkedPhoneNumber, 
                  int bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.userId = linkedAccount;       
        this.userId = linkedAccount;
        this.phone = linkedPhoneNumber;
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }
    public void ride() {
        
        if (this.batteryLevel > 0 && this.isAvailable) {
            System.out.println("The bike is available.");
        } else {
            System.out.println("The bike is not available.");
        }
    }
    public void printBikeDetails(){
        System.out.println("Bike ID: " + this.bikeID);
        System.out.println("Battery Level: " + this.batteryLevel + "%");
        System.out.println("Is Available: " + this.isAvailable);
        System.out.println("Kilometers Driven: " + this.kmDriven);
    }


    public int getBikeID() {
        return bikeID;
    }

    public void setBikeID(int bikeID) {
        this.bikeID = bikeID;
    }
    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Invalid battery level! Must be 0-100. Set to 0 by default.");
            this.batteryLevel = 0;
        }
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(double kmDriven) {
        this.kmDriven = kmDriven;
    }

public void printRideDetails(int usageInMinutes) {
        double totalFare = calculateFare(usageInMinutes);
        System.out.println("Linked Account: " + this.userId);
        System.out.println("Linked Phone Number: " + this.phone);
        System.out.println("Bike ID: " + this.bikeID);
        System.out.println("Usage in Minutes: " + usageInMinutes);
        System.out.println("Total Fare: " + totalFare);
    }
     
    private double calculateFare(int usageInMinutes) {
        return BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
    }
}