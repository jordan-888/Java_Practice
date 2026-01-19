
package coreprogramming.strings.level2;
import java.util.Scanner;

public class ShortestLongestWord {
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

    public static int[] findShortestAndLongest(String[][] wordsWithLength) {
        int shortestIndex = 0;
        int longestIndex = 0;
        int shortestLength = Integer.parseInt(wordsWithLength[0][1]);
        int longestLength = Integer.parseInt(wordsWithLength[0][1]);

        for (int i = 1; i < wordsWithLength.length; i++) {
            int currentLength = Integer.parseInt(wordsWithLength[i][1]);

            if (currentLength < shortestLength) {
                shortestLength = currentLength;
                shortestIndex = i;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestIndex = i;
            }
        }

        return new int[] { shortestIndex, longestIndex };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        String[] words = splitText(text);
        String[][] wordsWithLength = getWordsWithLength(words);
        int[] indexes = findShortestAndLongest(wordsWithLength);

        System.out.println("\nShortest word: " + wordsWithLength[indexes[0]][0] +
                " (Length: " + wordsWithLength[indexes[0]][1] + ")");
        System.out.println("Longest word: " + wordsWithLength[indexes[1]][0] +
                " (Length: " + wordsWithLength[indexes[1]][1] + ")");

        input.close();
    }
}
