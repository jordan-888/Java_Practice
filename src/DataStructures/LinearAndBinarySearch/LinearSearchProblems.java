package datastructures.linearandbinarysearch;
import java.util.Arrays;

/**
 * Linear Search Problems
 * Problem 1: Search for First Negative Number
 * Problem 2: Search for Specific Word in Sentences
 */
public class LinearSearchProblems {

    // Problem 1: Search for First Negative Number
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // Return index of first negative number
            }
        }
        return -1; // No negative number found
    }

    // Problem 2: Search for Specific Word in Sentences
    public static String findSentenceWithWord(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(targetWord.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Linear Search Problems ===\n");

        // Problem 1: Search for First Negative Number
        System.out.println("Problem 1: Search for First Negative Number\n");

        int[][] testArrays = {
                { 5, 12, -3, 8, -1, 20 },
                { 10, 20, 30, 40, 50 },
                { -5, -10, -15 },
                { 0, 0, 0, -1 }
        };

        for (int[] arr : testArrays) {
            System.out.println("Array: " + Arrays.toString(arr));
            int index = findFirstNegative(arr);
            if (index != -1) {
                System.out.printf("First negative number: %d at index %d%n", arr[index], index);
            } else {
                System.out.println("No negative number found");
            }
            System.out.println();
        }

        System.out.println("=".repeat(50) + "\n");

        // Problem 2: Search for Specific Word in Sentences
        System.out.println("Problem 2: Search for Specific Word in Sentences\n");

        String[] sentences = {
                "Java is a powerful programming language",
                "Python is great for data science",
                "JavaScript runs in the browser",
                "C++ is used for system programming",
                "Ruby on Rails is a web framework"
        };

        String[] wordsToSearch = { "Java", "data", "mobile", "framework" };

        System.out.println("Sentences:");
        for (int i = 0; i < sentences.length; i++) {
            System.out.printf("%d. %s%n", i + 1, sentences[i]);
        }
        System.out.println();

        for (String word : wordsToSearch) {
            String result = findSentenceWithWord(sentences, word);
            System.out.printf("Searching for '%s': %s%n", word, result);
        }
    }
}
