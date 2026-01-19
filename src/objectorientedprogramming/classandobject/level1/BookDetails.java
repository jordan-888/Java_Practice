
package objectorientedprogramming.classandobject.level1;
class Book {
    String title;
    String author;
    double price;

    // Constructor to initialize attributes
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("------------------------");
    }
}

public class BookDetails {
    public static void main(String[] args) {
        // Create book objects
        Book book1 = new Book("Java Programming", "James Gosling", 45.99);
        Book book2 = new Book("Clean Code", "Robert Martin", 39.99);
        Book book3 = new Book("Design Patterns", "Gang of Four", 54.99);

        // Display book details
        book1.displayDetails();
        book2.displayDetails();
        book3.displayDetails();
    }
}
