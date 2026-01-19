
package coreprogramming.strings.level1;
public class NullPointerDemo {
    public static void generateNullPointerException() {
        String str = null;
        System.out.println("Attempting to call length() on null string...");
        int length = str.length(); // This will throw NullPointerException
        System.out.println("Length: " + length);
    }

    public static void handleNullPointerException() {
        try {
            String str = null;
            System.out.println("Attempting to call length() on null string inside try block...");
            int length = str.length();
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught!");
            System.out.println("Error message: " + e.getMessage());
            System.out.println("Exception handled successfully.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Demonstrating NullPointerException ===");
        try {
            generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main: " + e.getClass().getSimpleName());
        }

        System.out.println("\n=== Handling NullPointerException ===");
        handleNullPointerException();
    }
}
