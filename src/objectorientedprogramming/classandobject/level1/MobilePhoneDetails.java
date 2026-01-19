
package objectorientedprogramming.classandobject.level1;
class MobilePhone {
    String brand;
    String model;
    double price;

    // Constructor to initialize attributes
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display all phone details
    public void displayDetails() {
        System.out.println("Mobile Phone Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
        System.out.println("------------------------");
    }
}

public class MobilePhoneDetails {
    public static void main(String[] args) {
        // Create mobile phone objects
        MobilePhone phone1 = new MobilePhone("Apple", "iPhone 15 Pro", 999.99);
        MobilePhone phone2 = new MobilePhone("Samsung", "Galaxy S24", 899.99);
        MobilePhone phone3 = new MobilePhone("Google", "Pixel 8", 699.99);

        // Display phone details
        phone1.displayDetails();
        phone2.displayDetails();
        phone3.displayDetails();
    }
}
