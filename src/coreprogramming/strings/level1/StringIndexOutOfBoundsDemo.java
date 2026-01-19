
package coreprogramming.strings.level1;
import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    public static void generateException(String str) {
        System.out.println("Attempting to access invalid index...");
        char ch = str.charAt(100); // This will throw StringIndexOutOfBoundsException
        System.out.println("Character: " + ch);
    }

    public static void handleException(String str) {
        try {
            System.out.println("Attempting to access invalid index inside try block...");
            char ch = str.charAt(100);
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught!");
            System.out.println("Error message: " + e.getMessage());
            System.out.println("Exception handled successfully.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        System.out.println("\n=== Demonstrating StringIndexOutOfBoundsException ===");
        try {
            generateException(str);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e.getClass().getSimpleName());
        }

        System.out.println("\n=== Handling StringIndexOutOfBoundsException ===");
        handleException(str);

        input.close();
    }
}
