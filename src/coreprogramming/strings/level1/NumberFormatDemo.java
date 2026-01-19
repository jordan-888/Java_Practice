
package coreprogramming.strings.level1;
import java.util.Scanner;

public class NumberFormatDemo {
    public static void generateException(String str) {
        System.out.println("Attempting to parse non-numeric string...");
        int num = Integer.parseInt(str); // This will throw NumberFormatException
        System.out.println("Number: " + num);
    }

    public static void handleException(String str) {
        try {
            System.out.println("Attempting to parse non-numeric string inside try block...");
            int num = Integer.parseInt(str);
            System.out.println("Number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught!");
            System.out.println("Error message: " + e.getMessage());
            System.out.println("Exception handled successfully.");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught!");
            System.out.println("Error message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a non-numeric string: ");
        String str = input.nextLine();

        System.out.println("\n=== Demonstrating NumberFormatException ===");
        try {
            generateException(str);
        } catch (NumberFormatException e) {
            System.out.println("Exception caught in main: " + e.getClass().getSimpleName());
        }

        System.out.println("\n=== Handling NumberFormatException ===");
        handleException(str);

        input.close();
    }
}
