import java.util.Scanner;

/**
 * Created by BHarris on 2/6/17.
 */
public class User {

    public User() {
        Main.passWords.put("admin", "password");
        Main.passWords.put("blake", "blake");
        Main.passWords.put("john", "john");

    }

    public boolean isValidUser(String username, String password) {
        return Main.passWords.containsKey(username) && Main.passWords.containsValue(password);

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
