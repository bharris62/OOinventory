import java.util.Scanner;

/**
 * Created by BHarris on 2/6/17.
 */
public class User {

    public User() {
        Main.userLogin.put("admin", "password");
        Main.userLogin.put("blake", "blake");
        Main.userLogin.put("john", "john");

    }

    public boolean isValidUser(String username, String password) {
        return Main.userLogin.containsKey(username) && Main.userLogin.containsValue(password);

    }

    public void checkUser(Scanner scanner) {
        while(true) {
            System.out.print("Enter your username: ");
            String userName = scanner.nextLine();
            System.out.print("Enter your password: ");
            String pass = scanner.nextLine();
            if (isValidUser(userName, pass)) {
                System.out.println("Wecome, " + userName);
                break;
            }
            System.out.println("Nope - Try again");
        }
    }


}
