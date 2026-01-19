
package coreprogramming.strings.level1;
import java.util.Scanner;

public class StringComparison {
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = input.next();
        System.out.print("Enter second string: ");
        String str2 = input.next();

        boolean manualResult = compareStrings(str1, str2);
        boolean builtInResult = str1.equals(str2);

        System.out.println("Manual comparison result: " + manualResult);
        System.out.println("Built-in equals() result: " + builtInResult);
        System.out.println("Both results match: " + (manualResult == builtInResult));

        input.close();
    }
}
