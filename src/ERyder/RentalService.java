package ERyder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RentalService {
    private final List<String> activeRentals = new ArrayList<>();

    public String startRental(String bikeId, String userEmail) {
        LocalDateTime startTime = LocalDateTime.now();
        String record = "Bike ID: " + bikeId + ", User Email: " + userEmail + ", Trip Start Time=" + startTime;
        activeRentals.add(record);
        return record;
    }

    public boolean endRental(String bikeId, String userEmail) {
        Iterator<String> it = activeRentals.iterator();
        while (it.hasNext()) {
            String r = it.next();
            if (r.contains("Bike ID: " + bikeId) && r.contains("User Email: " + userEmail)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean cancelRental(String bikeId, String userEmail) {
        return endRental(bikeId, userEmail);
    }

    public List<String> getActiveRentals() {
        return activeRentals;
    }
}
