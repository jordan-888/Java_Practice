
package coreprogramming.strings.level2;
import java.util.Scanner;
import java.util.Arrays;

public class TextSplitter {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    public static String[] splitText(String text) {
        int length = findLength(text);

        // Count number of words
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                if (!inWord) {
                    wordCount++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }

        // Store space indexes
        int[] spaceIndexes = new int[length];
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[spaceCount++] = i;
            }
        }

        // Extract words
        String[] words = new String[wordCount];
        int wordIndex = 0;
        int start = 0;

        for (int i = 0; i < spaceCount; i++) {
            if (spaceIndexes[i] > start) {
                String word = "";
                for (int j = start; j < spaceIndexes[i]; j++) {
                    word += text.charAt(j);
                }
                if (findLength(word) > 0) {
                    words[wordIndex++] = word;
                }
            }
            start = spaceIndexes[i] + 1;
        }

        // Add last word
        if (start < length) {
            String word = "";
            for (int j = start; j < length; j++) {
                word += text.charAt(j);
            }
            if (findLength(word) > 0) {
                words[wordIndex++] = word;
            }
        }

        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (findLength(arr1[i]) != findLength(arr2[i])) {
                return false;
            }
            for (int j = 0; j < findLength(arr1[i]); j++) {
                if (arr1[i].charAt(j) != arr2[i].charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        String[] userDefinedSplit = splitText(text);
        String[] builtInSplit = text.split(" ");

        System.out.println("User-defined split: " + Arrays.toString(userDefinedSplit));
        System.out.println("Built-in split: " + Arrays.toString(builtInSplit));
        System.out.println("Both results match: " + compareArrays(userDefinedSplit, builtInSplit));

        input.close();
    }
}
