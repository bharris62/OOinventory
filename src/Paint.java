/**
 * Created by BHarris on 2/7/17.
 */
public class Paint extends InventoryItem{

    public Paint(String name, int quantity) {
        this.category = "Paint";
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("You have %d of %s in %s category", this.quantity, this.name, this.quantity);
    }
}
