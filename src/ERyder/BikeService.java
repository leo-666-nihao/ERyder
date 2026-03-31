package ERyder;

public class BikeService {
    public boolean validateLocation(String location) {
        return location != null && !location.trim().isEmpty();
    }

    public boolean findAvailableBikeAt(String location) {
        return validateLocation(location);
    }

    public String reserveBike(String location) {
        if (!findAvailableBikeAt(location)) {
            return null;
        }
        return "B105";
    }

    public void releaseBike(String bikeId) {
    }
}
