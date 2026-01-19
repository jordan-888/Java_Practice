
package objectorientedprogramming.classandobject.level1;
class Item {
    String itemCode;
    String itemName;
    double price;

    // Constructor to initialize attributes
    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details
    public void displayDetails() {
        System.out.println("Item Details:");
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("------------------------");
    }

    // Method to calculate total cost for a given quantity
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

public class InventoryTracker {
    public static void main(String[] args) {
        // Create item objects
        Item item1 = new Item("A001", "Laptop", 899.99);
        Item item2 = new Item("A002", "Mouse", 25.50);
        Item item3 = new Item("A003", "Keyboard", 75.00);

        // Display item details
        item1.displayDetails();
        item2.displayDetails();
        item3.displayDetails();

        // Calculate and display total cost for quantities
        System.out.println("\nTotal Cost Calculations:");
        System.out.println("5 Laptops: $" + item1.calculateTotalCost(5));
        System.out.println("10 Mice: $" + item2.calculateTotalCost(10));
        System.out.println("3 Keyboards: $" + item3.calculateTotalCost(3));
    }
}
