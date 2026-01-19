
package coreprogramming.strings.level2;
import java.util.Scanner;

public class StringTrimmer {
    public static int[] findTrimIndexes(String str) {
        int start = 0;
        int end = str.length() - 1;

        // Find start index (first non-space)
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                start = i;
                break;
            }
        }

        // Find end index (last non-space)
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                end = i;
                break;
            }
        }

        return new int[] { start, end + 1 };
    }

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
        System.out.print("Enter a string with leading/trailing spaces: ");
        String str = input.nextLine();

        int[] indexes = findTrimIndexes(str);
        String userDefinedTrim = createSubstring(str, indexes[0], indexes[1]);
        String builtInTrim = str.trim();

        System.out.println("Original: '" + str + "'");
        System.out.println("User-defined trim: '" + userDefinedTrim + "'");
        System.out.println("Built-in trim: '" + builtInTrim + "'");
        System.out.println("Both results match: " + compareStrings(userDefinedTrim, builtInTrim));

        input.close();
    }
}
