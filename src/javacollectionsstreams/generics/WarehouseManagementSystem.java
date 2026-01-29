package JavaCollectionsStreams.generics;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    int id;
    String name;
    double price;

    WarehouseItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    abstract void display();
}

class Electronics extends WarehouseItem {

    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    void display() {
        System.out.println("[Electronics] ID: " + id + ", Name: " + name + ", Price: $" + price);
    }
}

class Groceries extends WarehouseItem {

    Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    void display() {
        System.out.println("[Groceries] ID: " + id + ", Name: " + name + ", Price: $" + price);
    }
}

class Furniture extends WarehouseItem {

    Furniture(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    void display() {
        System.out.println("[Furniture] ID: " + id + ", Name: " + name + ", Price: $" + price);
    }
}

class Storage<T extends WarehouseItem> {
    ArrayList<T> items = new ArrayList<>();

    void addItem(T item) {
        items.add(item);
    }

    void displayItems() {
        for (T item : items) {
            item.display();
        }
    }

    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.display();
        }
    }
}

class SmartWarehouseSystem {
    public static void main(String[] args) {
        System.out.println("=== Smart Warehouse Management System ===\n");

        // Generic class with bounded type parameter
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics(1, "Laptop", 1000));
        electronicsStorage.addItem(new Electronics(2, "Smartphone", 500));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries(3, "Rice", 20));
        groceriesStorage.addItem(new Groceries(4, "Milk", 5));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture(5, "Chair", 150));
        furnitureStorage.addItem(new Furniture(6, "Table", 300));

        System.out.println("Electronics Storage:");
        electronicsStorage.displayItems();

        System.out.println("\nGroceries Storage:");
        groceriesStorage.displayItems();

        System.out.println("\nFurniture Storage:");
        furnitureStorage.displayItems();

        // Wildcard usage - displaying all items regardless of type
        System.out.println("\n--- Using Wildcard (? extends WarehouseItem) ---");
        System.out.println("All Electronics:");
        Storage.displayAllItems(electronicsStorage.items);

        System.out.println("\nAll Groceries:");
        Storage.displayAllItems(groceriesStorage.items);
    }
}
