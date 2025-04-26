import java.util.HashSet;
import java.util.Set;

class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class UserService {
    private Set<String> users = new HashSet<>();

    public void registerUser(String username) throws UserAlreadyExistsException {
        if (users.contains(username)) {
            throw new UserAlreadyExistsException("User '" + username + "' already exists!");
        }
        users.add(username);
        System.out.println("User '" + username + "' registered successfully!");
    }

    public void checkUserExistence(String username) throws UserNotFoundException {
        if (!users.contains(username)) {
            throw new UserNotFoundException("User '" + username + "' not found!");
        }
        System.out.println("User '" + username + "' exists.");
    }
}

public class UserRegistrationApp {
    public static void main(String[] args) {
        UserService userService = new UserService();

        try {
            userService.registerUser("Alice");
            userService.registerUser("Bob");
            userService.registerUser("Alice");
        } catch (UserAlreadyExistsException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            userService.checkUserExistence("Charlie");
        } catch (UserNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
