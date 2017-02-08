/**
 * Created by BHarris on 2/7/17.
 */
public class Junk extends InventoryItem {

    public Junk(String name, int quantity) {
        this.category = "Junk";
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("You have %d of %s in %s category", this.quantity, this.name, this.quantity);
    }

}
