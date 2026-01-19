
package coreprogramming.strings.level2;
import java.util.Scanner;

public class StringLength {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception caught, return the count
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.next();

        int userDefinedLength = findLength(str);
        int builtInLength = str.length();

        System.out.println("User-defined length: " + userDefinedLength);
        System.out.println("Built-in length: " + builtInLength);

        input.close();
    }
}
