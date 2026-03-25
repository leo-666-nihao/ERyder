package ERyder;


public class Main {
        public static void main(String[] args) {
    UserRegistration registration = new UserRegistration();
    //registration.registration(); 
    
    ERyder bike1 = new ERyder(101, 85, true, 15.5);
    ERyder bike2 = new ERyder("user123", "555-1234", 102, 90, true, 20.0);    
    
    bike1.printRideDetails(30);
    bike2.printRideDetails(45);    
    
    String s1 = "I was very satisfied with the service.";
    String s2 = "The e-Bike is quite comfortable to ride.";
    String s3 = "The battery life of the e-Bike is impressive.";
    String s4 = "The customer support was helpful and responsive.";
    String s5 = "I would recommend this e-Bike to my friends and family.";
    Feedback userFeedback = new Feedback("John", "Doe", "john.doe@example.com");
    userFeedback.analyseFeedback(true, s1, s2, s3, s4, s5);
    System.out.println(userFeedback.toString());
    
    System.out.println(registration); 
    boolean runAdmin = false;
    if (runAdmin) {
        AdminPanel admin = new AdminPanel();
        admin.userManagementOptions();
    }
}

}

