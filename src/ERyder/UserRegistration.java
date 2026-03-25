package ERyder;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class UserRegistration {
    private static final Scanner scanner = new Scanner(System.in);
    public static final double VIP_DISCOUNT_UNDER_18_BIRTHDAY = 25.0;
    public static final double VIP_DISCOUNT_UNDER_18 = 20.0;
    public static final double VIP_BASE_FEE = 100.0; 
    public String fullName;
    public String emailAddress;
    public String dateOfBirth;
    public long cardNumber;
    public String cardProvider;
    public String cardExpiryDate;
    public double feeToCharge;
    public int cvv;
    public String userType;
    public boolean emailValid;
    public boolean minorAndBirthday;
    public boolean minor;
    public boolean ageValid;
    public boolean cardNumberValid;
    public boolean cardStillValid;
    public boolean validCVV;
    public void registration() {
        System.out.println("Welcome to the ERyder Registration.");
        System.out.println("Here are your two options:");
        System.out.println("1. Register as a Regular User");
        System.out.println("2. Register as a VIP User");
        System.out.print("Please enter your choice (1 or 2): ");
        
        String choice = scanner.nextLine();
        
        if (choice.equals("1")) {
            userType = "Regular User";
        } else {
            userType = "VIP User";
        }
        
        System.out.print("Please enter your full name: ");
        fullName = scanner.nextLine();
        
        System.out.print("Please enter your email address: ");
        emailAddress = scanner.nextLine();
        emailValid = analyseEmail();
        
        System.out.print("Please enter your date of birth (YYYY-MM-DD): ");
        dateOfBirth = scanner.nextLine();
        ageValid = analyseAge(dateOfBirth);

        System.out.print("Please enter your card provider (VISA/MasterCard/American Express): ");
        cardProvider = scanner.nextLine();
        analyseCardProvider(cardProvider);

        System.out.print("Please enter your card expiry date (MM/YY): ");
        cardExpiryDate = scanner.nextLine();
        if (!analyseCardProvider(cardProvider)) {
            
        }
        
        System.out.print("Please enter your card CVV: ");
        if (scanner.hasNextInt()) {
            cvv = scanner.nextInt();
            scanner.nextLine(); 
            validCVV = analyseCVV(cvv);
        } else {
            System.out.println("Invalid CVV input.");
            validCVV = false;
            scanner.nextLine();
        }
         
    } 
private boolean analyseCardProvider(String cardProvider) {
    if (cardProvider.equalsIgnoreCase("VISA") || 
        cardProvider.equalsIgnoreCase("MasterCard") || 
        cardProvider.equalsIgnoreCase("American Express")) {
        return true;
    } else {
        System.out.println("Sorry, but we accept only VISA, MasterCard, or American Express cards.");
        return false; 
    }
}
    
    
    private boolean analyseCardExpiryDate(String expiryDate) {
        try {
            int month = Integer.parseInt(expiryDate.substring(0, 2));
            int year = Integer.parseInt(expiryDate.substring(3, 5)) + 2000;
            LocalDate currentDate = LocalDate.now();
            int currentMonth = currentDate.getMonthValue();
            int currentYear = currentDate.getYear();
           
            if (year < currentYear) {
                return false;
            } else if (year == currentYear && month < currentMonth) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use MM/YY.");
            return false;
        }
    }
    private boolean analyseCVV(int cvv) {
        String cvvStr = String.valueOf(cvv);
        boolean isValid = false;
        if ("American Express".equalsIgnoreCase(cardProvider) && cvvStr.length() == 4) {
        isValid = true;
        }
        else if (("VISA".equalsIgnoreCase(cardProvider) || "MasterCard".equalsIgnoreCase(cardProvider)) && cvvStr.length() == 3) {
        isValid = true;
        }
        return isValid;
        }
         private boolean analyseEmail() {
        if (emailAddress != null && emailAddress.contains("@") && emailAddress.contains(".")) {
            return true;
        } else {
        return false;
        }
    }
    private boolean analyseAge(String dob) {
        try {
            LocalDate birthDate = LocalDate.parse(dob);
            LocalDate currentDate = LocalDate.now();
            
            Period period = Period.between(birthDate, currentDate);
            int age = period.getYears();
            
            boolean isBirthday = (birthDate.getMonthValue() == currentDate.getMonthValue()) 
                              && (birthDate.getDayOfMonth() == currentDate.getDayOfMonth());
            
            boolean isUnder18 = age < 18;
            
            this.ageValid = age >= 0 && age <= 120;
            this.minor = isUnder18;
            this.minorAndBirthday = isUnder18 && isBirthday;
            
            return ageValid;
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return false;
        }
    }
    private void finalCheckpoint() {
    if (emailValid && ageValid && cardNumberValid && cardStillValid && validCVV) {
        chargeFees();
        System.out.println(this.toString());
    } else {
        System.out.println("Sorry, your registration was unsuccessful.");
        
    }
}
    private void chargeFees() {
    if (minorAndBirthday) {
        feeToCharge = VIP_BASE_FEE * 0.75;
    }
    else if (minor) {
        feeToCharge = VIP_BASE_FEE * 0.80;
    }
    else {
        feeToCharge = VIP_BASE_FEE;
    }
    
    String cardNumberStr = String.valueOf(cardNumber);
    String lastFourDigits = cardNumberStr.substring(cardNumberStr.length() - 4);
    
    System.out.println("Thank you for your payment.");
    System.out.println("A fee of " + feeToCharge + " has been charged to your card ending with " + lastFourDigits);
}
public String toString() {
    
    String cardNumberStr = String.valueOf(cardNumber);
    String censoredPart = "";
    
    if (cardNumberStr.length() > 4) {
        String maskPart = cardNumberStr.substring(0, cardNumberStr.length() - 4);
        censoredPart = maskPart.replaceAll(".", "*");
    }
    
    String lastFourDigits = cardNumberStr.substring(cardNumberStr.length() - 4);
    
    String censoredNumber = censoredPart + lastFourDigits;
    return "Registration successful! Here are your details:\n" +
           "User Type: " + userType + "\n" +
           "Full Name: " + fullName + "\n" +
           "Email Address: " + emailAddress + "\n" +
           "Date of Birth: " + dateOfBirth + "\n" +
           "Card Number: " + censoredNumber + "\n" +
           "Card Provider: " + cardProvider + "\n" +
           "Card Expiry Date: " + cardExpiryDate;
    }
}

        
