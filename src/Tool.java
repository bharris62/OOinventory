/**
 * Created by BHarris on 2/7/17.
 */
public class Tool extends InventoryItem {

    public Tool(String item, int quantity) {
        this.category = "Tool";
        this.name = item;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("You have %d of %s in %s category", this.quantity, this.name, this.quantity);
    }
}
