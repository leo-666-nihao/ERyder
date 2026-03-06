package ERyder;
public class ERyder {
    // Variables
    private int bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    
    //Constructor
    public ERyder(){
        this.bikeID = 0;
        this.batteryLevel = 0;
        this.isAvailable = true;
        this.kmDriven = 0.0;
    }
    public void ride() {
        /*This method checks the current battery level and if the bike is 
available. If both are fine, then it prints that the bike is available. Otherwise, it 
prints that the bike is not available. */
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
}

