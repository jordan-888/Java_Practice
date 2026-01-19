
package objectorientedprogramming.constructorsinstancevsclassaccessmodifiers.level3;
class Book {
    public String ISBN;
    protected String title;
    private String author;

    // Constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("------------------------");
    }
}

class EBook extends Book {
    double fileSize; // in MB
    String format;

    // Constructor
    public EBook(String ISBN, String title, String author, double fileSize, String format) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
        this.format = format;
    }

    // Method to display ebook details
    public void displayEBookDetails() {
        System.out.println("E-Book Details:");
        System.out.println("ISBN: " + ISBN); // public - accessible
        System.out.println("Title: " + title); // protected - accessible in subclass
        System.out.println("Author: " + getAuthor()); // private - accessed via getter
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("Format: " + format);
        System.out.println("------------------------");
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        System.out.println("=== Book Library System ===\n");

        // Create book object
        Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        book.displayDetails();

        // Access public member directly
        System.out.println("Accessing public member: ISBN = " + book.ISBN);

        // Access private member via getter
        System.out.println("Accessing private member via getter: Author = " + book.getAuthor());

        // Update author using setter
        System.out.println("\nUpdating author:");
        book.setAuthor("Joshua Bloch (Updated)");
        book.displayDetails();

        // Create ebook object
        System.out.println("\n=== E-Book ===");
        EBook ebook = new EBook("978-0135957059", "The Pragmatic Programmer", "David Thomas", 5.2, "PDF");
        ebook.displayEBookDetails();
    }
}
