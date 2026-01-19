
package coreprogramming.strings.level2;
import java.util.Scanner;

public class CharacterTypeDisplay {
    public static char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        return ch;
    }

    public static String identifyCharType(char ch) {
        char lower = toLowerCase(ch);

        if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
            return "Vowel";
        } else if (lower >= 'a' && lower <= 'z') {
            return "Consonant";
        } else {
            return "Not a letter";
        }
    }

    public static String[][] analyzeString(String str) {
        String[][] result = new String[str.length()][2];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = identifyCharType(ch);
        }

        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.println("\nCharacter\tType");
        System.out.println("------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        String[][] analysis = analyzeString(str);
        displayTable(analysis);

        input.close();
    }
}
