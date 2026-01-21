package DataStructures.LinkedList;

import java.util.Scanner;

class MovieNode {
    String title;
    String director;
    int releaseYear;
    float rating;
    MovieNode next, prev;

    public MovieNode(String title, String director, int releaseYear, float rating) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieLinkedList {
    private MovieNode head;

    public MovieLinkedList() {
        this.head = null;
    }

    public void addAtBeginning(String title, String director, int releaseYear, float rating) {
        MovieNode newNode = new MovieNode(title, director, releaseYear, rating);
        newNode.next = head;
        newNode.prev = null;
        head = newNode;

        System.out.println("✓ Movie added at the beginning successfully!");
    }

    public void addAtEnd(String title, String director, int releaseYear, float rating) {
        MovieNode newNode = new MovieNode(title, director, releaseYear, rating);
        if (head == null) {
            head = newNode;
            return;
        }

        MovieNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;

        System.out.println("✓ Movie added at the end successfully!");
    }

    public void addAtPosition(String title, String director, int releaseYear, float rating, int position) {
        if (position < 1) {
            System.out.printf("✗ Invalid position! Position must be >= 1\n");
            return;
        }

        MovieNode newNode = new MovieNode(title, director, releaseYear, rating);

        if (position == 1) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            System.out.println("✓ Movie added at position " + position + " successfully!");
            return;
        }

        MovieNode current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.printf("✗ Position out of bounds! List has fewer elements.\n");
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;

        System.out.println("✓ Movie added at position " + position + " successfully!");
    }

    public void removeTitle(String title) {
        if (head == null) {
            System.out.println("✗ List is empty! No movies to remove.");
            return;
        }

        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                if (current == head) {
                    head = current.next;
                }
                System.out.println("✓ Movie removed successfully!");
                return;
            }
            current = current.next;
        }

        System.out.println("✗ Movie not found!");
    }

    public void searchMovie(String director) {
        MovieNode current = head;
        int position = 1;

        while (current != null) {
            if (current.director.equals(director)) {
                System.out.println("\n========== Movie Found ==========");
                System.out.println("Position      : " + position);
                System.out.println("Title         : " + current.title);
                System.out.println("Director      : " + current.director);
                System.out.println("Release Year  : " + current.releaseYear);
                System.out.println("Rating        : " + current.rating);
                System.out.println("===============================\n");
                return;
            }
            current = current.next;
            position++;
        }

        System.out.println("✗ Movie not found!");
    }

    public void searchMovie(float rating) {
        MovieNode current = head;
        while (current != null) {
            if (current.rating == rating) {
                System.out.println("movie found!");
                return;
            }
            current = current.next;
        }

        System.out.println("✗ Movie not found!");
    }

    public void displayAll() {
        MovieNode current = head;
        MovieNode last = null;
        System.out.println("\nForward printing...");
        while (current != null) {
            System.out.println("Title         : " + current.title);
            System.out.println("Director      : " + current.director);
            System.out.println("Release Year  : " + current.releaseYear);
            System.out.println("Rating        : " + current.rating);
            System.out.println("-----------------------------\n");
            if (current.next == null)
                last = current;
            current = current.next;
        }

        System.out.println("\nBackward printing...");
        while (last != null) {
            System.out.println("Title         : " + last.title);
            System.out.println("Director      : " + last.director);
            System.out.println("Release Year  : " + last.releaseYear);
            System.out.println("Rating        : " + last.rating);
            System.out.println("-----------------------------\n");
            last = last.prev;
        }
    }

    public void updateRating(String title, float rating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = rating;
                System.out.println("✓ Rating updated successfully!");
                return;
            }
            current = current.next;
        }

        System.out.println("✗ Movie not found!");
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MovieLinkedList movieList = new MovieLinkedList();

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   Movie Management System                  ║");
        System.out.println("║   Using Doubly Linked List                 ║");
        System.out.println("╚════════════════════════════════════════════╝");

        while (true) {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie at the beginning");
            System.out.println("2. Add Movie at the end");
            System.out.println("3. Add Movie at a specific position");
            System.out.println("4. Remove Movie by title");
            System.out.println("5. Search Movie by director");
            System.out.println("6. Search Movie by rating");
            System.out.println("7. Display all movies");
            System.out.println("8. Update Movie rating");
            System.out.println("9. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Add Movie at the beginning ---");
                    System.out.print("Enter Movie Title: ");
                    String title = input.next();
                    System.out.print("Enter Director Name: ");
                    String director = input.next();
                    System.out.print("Enter Release Year: ");
                    int releaseYear = input.nextInt();
                    System.out.print("Enter Rating: ");
                    float rating = input.nextFloat();
                    movieList.addAtBeginning(title, director, releaseYear, rating);
                    break;

                case 2:
                    System.out.println("\n--- Add Movie at the end ---");
                    System.out.print("Enter Movie Title: ");
                    title = input.next();
                    System.out.print("Enter Director Name: ");
                    director = input.next();
                    System.out.print("Enter Release Year: ");
                    releaseYear = input.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = input.nextFloat();
                    movieList.addAtEnd(title, director, releaseYear, rating);
                    break;

                case 3:
                    System.out.println("\n--- Add Movie at a specific position ---");
                    System.out.print("Enter Movie Title: ");
                    title = input.next();
                    System.out.print("Enter Director Name: ");
                    director = input.next();
                    System.out.print("Enter Release Year: ");
                    releaseYear = input.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = input.nextFloat();
                    System.out.print("Enter Position: ");
                    int position = input.nextInt();
                    movieList.addAtPosition(title, director, releaseYear, rating, position);
                    break;

                case 4:
                    System.out.println("\n--- Remove Movie by title ---");
                    System.out.print("Enter Movie Title: ");
                    title = input.next();
                    movieList.removeTitle(title);
                    break;

                case 5:
                    System.out.println("\n--- Search Movie by director ---");
                    System.out.print("Enter Director Name: ");
                    director = input.next();
                    movieList.searchMovie(director);
                    break;

                case 6:
                    System.out.println("\n--- Search Movie by rating ---");
                    System.out.print("Enter Rating: ");
                    rating = input.nextFloat();
                    movieList.searchMovie(rating);
                    break;

                case 7:
                    movieList.displayAll();
                    break;

                case 8:
                    System.out.println("\n--- Update Movie rating ---");
                    System.out.print("Enter Movie Title: ");
                    title = input.next();
                    System.out.print("Enter New Rating: ");
                    rating = input.nextFloat();
                    movieList.updateRating(title, rating);
                    break;

                case 9:
                    System.out.println("\n✓ Thank you for using Movie Management System!");
                    System.out.println("✓ Exiting...");
                    input.close();
                    return;

                default:
                    System.out.println("✗ Invalid choice! Please enter a number between 1-9.");
            }

            System.out.println(); // Print blank line for readability
        }
    }
}
