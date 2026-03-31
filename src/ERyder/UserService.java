package ERyder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserService {
    private final List<RegisteredUsers> registeredUsersList = new ArrayList<>();

    public void addUser(RegisteredUsers user) {
        registeredUsersList.add(user);
    }

    public List<RegisteredUsers> getAllUsers() {
        return registeredUsersList;
    }

    public boolean removeByEmail(String email) {
        Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();
        while (iterator.hasNext()) {
            RegisteredUsers user = iterator.next();
            if (user.getEmailAddress().equals(email)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean updateByEmail(String email, RegisteredUsers updated) {
        for (int i = 0; i < registeredUsersList.size(); i++) {
            if (registeredUsersList.get(i).getEmailAddress().equals(email)) {
                registeredUsersList.set(i, updated);
                return true;
            }
        }
        return false;
    }

    public RegisteredUsers findByEmail(String email) {
        for (RegisteredUsers user : registeredUsersList) {
            if (user.getEmailAddress().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
