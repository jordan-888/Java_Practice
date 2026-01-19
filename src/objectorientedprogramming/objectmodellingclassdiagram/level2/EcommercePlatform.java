
package objectorientedprogramming.objectmodellingclassdiagram.level2;
import java.util.ArrayList;

class Product {
    String productName;
    String productId;
    double price;

    public Product(String productName, String productId, double price) {
        this.productName = productName;
        this.productId = productId;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("  - " + productName + " ($" + price + ")");
    }
}

class Order {
    String orderId;
    ArrayList<Product> products;
    double totalAmount;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.price;
    }

    public void displayOrderDetails() {
        System.out.println("\nOrder ID: " + orderId);
        System.out.println("Products:");
        for (Product product : products) {
            product.displayDetails();
        }
        System.out.println("Total Amount: $" + totalAmount);
    }
}

class Customer {
    String name;
    String customerId;
    ArrayList<Order> orders;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        this.orders = new ArrayList<>();
    }

    public Order placeOrder(String orderId) {
        Order order = new Order(orderId);
        orders.add(order);
        System.out.println(name + " placed order: " + orderId);
        return order;
    }

    public void viewOrders() {
        System.out.println("\n=== Customer: " + name + " (" + customerId + ") ===");
        System.out.println("Total Orders: " + orders.size());
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }
}

public class EcommercePlatform {
    public static void main(String[] args) {
        System.out.println("=== E-commerce Platform ===\n");

        // Create Products (can exist independently)
        Product product1 = new Product("Laptop", "P001", 899.99);
        Product product2 = new Product("Mouse", "P002", 25.50);
        Product product3 = new Product("Keyboard", "P003", 75.00);
        Product product4 = new Product("Monitor", "P004", 299.99);

        // Create Customer
        Customer customer = new Customer("John Doe", "C001");

        // Customer places orders (Communication)
        Order order1 = customer.placeOrder("ORD001");
        order1.addProduct(product1);
        order1.addProduct(product2);
        order1.addProduct(product3);

        Order order2 = customer.placeOrder("ORD002");
        order2.addProduct(product4);
        order2.addProduct(product2);

        // View customer orders
        customer.viewOrders();
    }
}
