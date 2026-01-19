
package coreprogramming.strings.level2;
import java.util.Scanner;

public class WordLengthArray {
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

        // Count words
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

        // Extract words
        String[] words = new String[wordCount];
        int wordIndex = 0;
        String currentWord = "";

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                currentWord += ch;
            } else {
                if (findLength(currentWord) > 0) {
                    words[wordIndex++] = currentWord;
                    currentWord = "";
                }
            }
        }

        // Add last word
        if (findLength(currentWord) > 0) {
            words[wordIndex++] = currentWord;
        }

        return words;
    }

    public static String[][] getWordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        String[] words = splitText(text);
        String[][] wordsWithLength = getWordsWithLength(words);

        System.out.println("\nWord\t\tLength");
        System.out.println("------------------------");
        for (int i = 0; i < wordsWithLength.length; i++) {
            int length = Integer.parseInt(wordsWithLength[i][1]);
            System.out.println(wordsWithLength[i][0] + "\t\t" + length);
        }

        input.close();
    }
}
