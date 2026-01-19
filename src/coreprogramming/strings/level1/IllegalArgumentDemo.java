
package coreprogramming.strings.level1;
import java.util.Scanner;

public class IllegalArgumentDemo {
    public static void generateException(String str) {
        System.out.println("Attempting to call substring with start > end...");
        String sub = str.substring(5, 2); // This will throw IllegalArgumentException
        System.out.println("Substring: " + sub);
    }

    public static void handleException(String str) {
        try {
            System.out.println("Attempting to call substring with start > end inside try block...");
            String sub = str.substring(5, 2);
            System.out.println("Substring: " + sub);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught!");
            System.out.println("Error message: " + e.getMessage());
            System.out.println("Exception handled successfully.");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught!");
            System.out.println("Error message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string (at least 6 characters): ");
        String str = input.nextLine();

        System.out.println("\n=== Demonstrating IllegalArgumentException ===");
        try {
            generateException(str);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in main: " + e.getClass().getSimpleName());
        }

        System.out.println("\n=== Handling IllegalArgumentException ===");
        handleException(str);

        input.close();
    }
}
