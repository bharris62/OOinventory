/**
 * Created by BHarris on 2/7/17.
 */
public class Vehicle extends InventoryItem {

    public Vehicle(String item, int quantity) {
        this.category = "Vehicle";
        this.name = item;
        this.quantity = quantity;
    }
}
