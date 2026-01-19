
package coreprogramming.strings.level2;
import java.util.Scanner;

public class VowelConsonantCounter {
    public static char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        return ch;
    }

    public static String identifyCharType(char ch) {
        ch = toLowerCase(ch);

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        } else if (ch >= 'a' && ch <= 'z') {
            return "Consonant";
        } else {
            return "Not a letter";
        }
    }

    public static int[] countVowelsAndConsonants(String str) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String type = identifyCharType(ch);

            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }

        return new int[] { vowels, consonants };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        int[] counts = countVowelsAndConsonants(str);

        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);

        input.close();
    }
}
