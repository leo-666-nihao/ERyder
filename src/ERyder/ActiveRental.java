package ERyder;
import java.time.LocalDateTime;
public class ActiveRental {
    private String bikeID;
    private String email;
    private LocalDateTime startTime;
    private String location;


    public ActiveRental(String bikeID, String email, LocalDateTime startTime, String location) {
        this.bikeID = bikeID;
        this.email = email;
        this.startTime = startTime;
        this.location = location;
    }

    public String getBikeID() {
        return bikeID;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    
    public String getLocation() {
        return location;
    }


    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public void setUserEmail(String userEmail) {
        this.email = userEmail;
    }

    public void setstartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    public String toString() {
        return "ActiveRental{" +
                "bikeID='" + bikeID + '\'' +
                ", Email='" + email + '\'' +
                ", tripStartTime=" + startTime +
                '}';
    }
}
