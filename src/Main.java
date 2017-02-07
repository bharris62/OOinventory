import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static ArrayList<InventoryItem> inventoryItems = new ArrayList<>();
    public static HashMap<String, String> passWords = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        user.checkUser(scanner);
        System.out.println("~Welcome to Inventory Emporium~");

        while (true) {
            InventoryItem inventory = new InventoryItem();
            System.out.println("[1] Add Some Inventory\n" +
                    "[2] Remove Some InventoryItem\n" +
                    "[3] Update some inventory Quantity. \n" +
                    "[4] View InventoryItem. \n" +
                    "[5] Shut Down System\n" +
                    "[6] Sign Out");
            String userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                inventory.addItem(scanner);

            } else if (userInput.equals("2")) {
                inventory.remove(scanner);

            } else if (userInput.equals("3")) {
                inventory.update(scanner);

            } else if( userInput.equals("4")){
                inventory.print();

            } else if(userInput.equals("5")) {
                inventory.warningAndDelete(scanner);

            }else if (userInput.equals("6")) {
                System.out.println("Thanks for coming...");
                user.checkUser(scanner);

            }else{
                System.out.println("Not a valid choice.");
            }
        }
    }
}
