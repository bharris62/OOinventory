import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static ArrayList<InventoryItem> inventoryItems = new ArrayList<>();
    public static HashMap<String, String> userLogin = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        user.checkUser(scanner);
        System.out.println("~Welcome to Inventory Emporium~");

        boolean stayInProgram = true;

        while (stayInProgram) {
            InventoryItem inventory = new InventoryItem();
            System.out.println("[1] Add Some Inventory\n" +
                    "[2] Remove Some Inventory\n" +
                    "[3] Update some inventory Quantity. \n" +
                    "[4] View Inventory. \n" +
                    "[5] Print Specific Category\n" +
                    "[6] Shut Down System\n" +
                    "[7] Sign Out");
            String userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                InventoryItem item = inventory.addItem(scanner);
                System.out.println("What category is the name: [1] Toy [2] Vehicle [3] Junk [4] Tool [5] Paint");
                int type = Integer.parseInt(scanner.nextLine());
                InventoryItem addedItem = createItem(item, type);
                System.out.printf("You added %d %ss to category %s\n", addedItem.quantity, addedItem.name, addedItem.category);

            } else if (userInput.equals("2")) {
                inventory.remove(scanner);

            } else if (userInput.equals("3")) {
                inventory.update(scanner);

            } else if( userInput.equals("4")){
                inventory.print();

            } else if(userInput.equals("5")) {
                inventory.printSpecificItem(scanner);

            }else if (userInput.equals("6")) {
                stayInProgram = inventory.warnAndLeave(scanner);

            }else if(userInput.equals("6")){
                System.out.println("Thanks for coming...");
                user.checkUser(scanner);
            }else {
                System.out.println("Not a valid choice.");
            }
        }
    }

    public static InventoryItem createItem(InventoryItem item, int type ) throws Exception {
        InventoryItem returnableItem;
                switch (type) {
                    case 1:
                        Toy toy = new Toy(item.name, item.quantity);
                        inventoryItems.add(toy);
                        returnableItem = toy;
                        break;
                    case 2:
                        Vehicle vehicle = new Vehicle(item.name, item.quantity);
                        inventoryItems.add(vehicle);
                        returnableItem = vehicle;
                        break;
                    case 3:
                        Junk junk = new Junk(item.name, item.quantity);
                        inventoryItems.add(junk);
                        returnableItem = junk;
                        break;
                    case 4:
                        Tool tool = new Tool(item.name, item.quantity);
                        inventoryItems.add(tool);
                        returnableItem = tool;
                        break;
                    case 5:
                        Paint paint = new Paint(item.name, item.quantity);
                        inventoryItems.add(paint);
                        returnableItem = paint;
                        break;
                    default:
                           throw new Exception("That is not an applicable field.");
                }

            return returnableItem;
        }
}
