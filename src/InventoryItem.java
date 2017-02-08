import java.util.Scanner;

public class InventoryItem {
    String name;
    int quantity;
    String category;

    public InventoryItem(String item, int quantity){
        this.name = item;
        this.quantity = quantity;
    }

    public InventoryItem(){}


    public String getItem(Scanner scanner){
        while(true) {
            System.out.print("What would you like to add: ");

            name = scanner.nextLine();
            if(name.isEmpty()){
                System.out.println("You must enter something.");
            }else{
                break;
            }
        }
        return name;
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
        }else{
            System.out.println("Not enough items.");
        }

    }

    //print methods used to print with the index.
    public void print() {

        if(Main.inventoryItems.isEmpty()) {
            System.out.println("[Nothing in Inventory]");
        }else {
            int i = 1;
            System.out.println(" #    Q    Descr    Category");
            for (InventoryItem item : Main.inventoryItems) {
                System.out.printf("[%d] [%d]  %s      %s\n", i, item.quantity, item.name, item.category);
                i++;
            }
        }
        System.out.println("----------------------");
    }

    public void printCategory(String cat){
        int i = 1;
        System.out.println(" #    Q    Descr    Category");
        for (InventoryItem item : Main.inventoryItems) {

            if(item.category.equals(cat)) {
                System.out.printf("[%d] [%d]  %s      %s\n", i, item.quantity, item.name, item.category);
                i++;
            }
            if(i ==1){
                System.out.printf("Nothing in %s.\n", cat);
            }

        }
        System.out.println("----------------------");
    }

    public void remove(Scanner scanner) {
        System.out.println("Enter name number to remove it. ([-1] to cancel)");
        int numToRemove = Integer.parseInt(scanner.nextLine());
        if(numToRemove <= 0) {
            System.out.println("Your current inventory is: " + Main.inventoryItems.get(numToRemove - 1).quantity);
            System.out.println("Are you sure? [y/n]");
            String resp = scanner.nextLine().toLowerCase();
            if (resp.equals("y")) {
                Main.inventoryItems.remove(numToRemove - 1);
            }
        }
    }

    public InventoryItem addItem(Scanner scanner){
        String name = getItem(scanner);
        int quantity = getQuantity(scanner);
        InventoryItem item = new InventoryItem(name, quantity);
        return item;
    }

    public boolean warnAndLeave(Scanner scanner){
        System.out.println("Are you sure, you will lose all data? [y/n]");
        String userInput = scanner.nextLine();
        if(userInput.equals("y")) {
            return false;
        }
        return true;
    }

    public void printSpecificItem(Scanner scanner) {
        System.out.println("What category would you like to see? [1] Toy [2] Vehicle [3] Junk [4] Tool [5] Paint");
        int category = Integer.parseInt(scanner.nextLine());
        while(true) {
            switch(category){
                case 1:
                    printCategory("Toy");
                    break;
                case 2:
                    printCategory("Vehicle");
                    break;
                case 3:
                    printCategory("Junk");
                    break;
                case 4:
                    printCategory("Tool");
                    break;
                case 5:
                    printCategory("Paint");
                    break;
                default:
                    System.out.println("enter a number 1-5");
                    break;
            }
            break;
        }
    }
}
