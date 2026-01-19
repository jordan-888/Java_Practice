
package coreprogramming.strings.level1;
import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    public static void generateException(String[] names, int index) {
        System.out.println("Attempting to access invalid array index...");
        String name = names[index]; // This will throw ArrayIndexOutOfBoundsException
        System.out.println("Name: " + name);
    }

    public static void handleException(String[] names, int index) {
        try {
            System.out.println("Attempting to access invalid array index inside try block...");
            String name = names[index];
            System.out.println("Name: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught!");
            System.out.println("Error message: " + e.getMessage());
            System.out.println("Exception handled successfully.");
        }
    }

    public static void main(String[] args) {
        String[] names = { "Alice", "Bob", "Charlie", "David", "Eve" };

        Scanner input = new Scanner(System.in);
        System.out.println("Array of names: ");
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + ": " + names[i]);
        }

        System.out.print("\nEnter an index to access: ");
        int index = input.nextInt();

        System.out.println("\n=== Demonstrating ArrayIndexOutOfBoundsException ===");
        try {
            generateException(names, index);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e.getClass().getSimpleName());
        }

        System.out.println("\n=== Handling ArrayIndexOutOfBoundsException ===");
        handleException(names, index);

        input.close();
    }
}
