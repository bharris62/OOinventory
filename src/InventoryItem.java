import java.util.Scanner;

public class InventoryItem {
    String item;
    int quantity;

    public InventoryItem(String item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public InventoryItem(){}


    public String getItem(Scanner scanner){
        while(true) {
            System.out.print("What would you like to add: ");

            item = scanner.nextLine();
            if(item.isEmpty()){
                System.out.println("You must enter something.");
            }else{
                break;
            }
        }
        return item;
    }

    public int getQuantity(Scanner scanner) {
        while(true) {
            System.out.print("How many to add: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            if(quantity < 0) {
                System.out.println("Must be greater than 0.");
            }else {
                return quantity;
            }
        }
    }

    public void update(Scanner scanner){
        System.out.println("What number would you like to update? ");
        int idx = Integer.parseInt(scanner.nextLine());
        if(idx < Main.inventoryItems.size() + 1) {
            System.out.println("Your current inventory is: " + Main.inventoryItems.get(idx - 1).quantity);
        }else{
            System.out.println("Not enough items.");
        }
        System.out.println("What would you like to change to: ");
        while(true) {
            int toUpdate = Integer.parseInt(scanner.nextLine());
            if(toUpdate > 0 ) {
                InventoryItem item = Main.inventoryItems.get(idx - 1);
                item.quantity = toUpdate;
                break;
            }else {
                System.out.println("Must be greater than 0.");
            }
        }
    }

    public void print() {
        int i = 1;
        System.out.println(" #    Q   Description");
        if(Main.inventoryItems.isEmpty()) {
            System.out.println("Nothing in Inventory");
        }else {
            for (InventoryItem item : Main.inventoryItems) {
                System.out.printf("[%d] [%d] %s \n", i, item.quantity, item.item);
                i++;
            }
        }
        System.out.println("----------------------");
    }

    public void remove(Scanner scanner) {
        System.out.println("Enter item number to remove it. ([-1] to cancel)");
        int numToRemove = Integer.parseInt(scanner.nextLine());
        if(numToRemove > 0) {
            System.out.println("Your current inventory is: " + Main.inventoryItems.get(numToRemove - 1).quantity);
            System.out.println("Are you sure? [y/n]");
            String resp = scanner.nextLine().toLowerCase();
            if (numToRemove > 0 && resp.equals("y")) {
                Main.inventoryItems.remove(numToRemove - 1);
            }
        }
    }

    public void addItem(Scanner scanner){
        String item = getItem(scanner);
        int quantity = getQuantity(scanner);
        InventoryItem thing = new InventoryItem(item, quantity);
        Main.inventoryItems.add(thing);
    }

    public void warningAndDelete(Scanner scanner){
        System.out.println("Are you sure, you will lose all data? [y/n]");
        String userInput = scanner.nextLine();
        if(userInput.equals("y")) {
            System.exit(0);
        }
    }
}
