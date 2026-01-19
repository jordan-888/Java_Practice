
package coreprogramming.strings.level1;
import java.util.Scanner;
import java.util.Arrays;

public class CharacterOccurrences {
    public static int[] findOccurrences(String str, char ch) {
        // First count occurrences
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }

        // Create array to store indexes
        int[] indexes = new int[count];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                indexes[index++] = i;
            }
        }

        return indexes;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        System.out.print("Enter a character to find: ");
        char ch = input.next().charAt(0);

        int[] occurrences = findOccurrences(str, ch);
        System.out.println("Character '" + ch + "' found at indexes: " + Arrays.toString(occurrences));

        input.close();
    }
}
