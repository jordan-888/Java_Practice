
package coreprogramming.strings.level1;
import java.util.Scanner;

public class SubstringCreator {
    public static String createSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

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
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        System.out.print("Enter start index: ");
        int start = input.nextInt();
        System.out.print("Enter end index: ");
        int end = input.nextInt();

        String manualSubstring = createSubstring(str, start, end);
        String builtInSubstring = str.substring(start, end);

        System.out.println("Manual substring: " + manualSubstring);
        System.out.println("Built-in substring: " + builtInSubstring);
        System.out.println("Both substrings are equal: " + compareStrings(manualSubstring, builtInSubstring));

        input.close();
    }
}
