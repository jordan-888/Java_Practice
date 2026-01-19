
package coreprogramming.strings.level1;
import java.util.Scanner;
import java.util.Arrays;

public class CharArrayConverter {
    public static char[] stringToCharArray(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        char[] manualArray = stringToCharArray(str);
        char[] builtInArray = str.toCharArray();

        System.out.println("Manual array: " + Arrays.toString(manualArray));
        System.out.println("Built-in array: " + Arrays.toString(builtInArray));
        System.out.println("Both arrays are equal: " + compareCharArrays(manualArray, builtInArray));

        input.close();
    }
}
