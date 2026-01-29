package datastructures.linearandbinarysearch;
import java.util.HashSet;

/**
 * StringBuilder Problems
 * Problem 1: Reverse a String
 * Problem 2: Remove Duplicates from String
 */
public class StringBuilderProblems {

    // Problem 1: Reverse a String Using StringBuilder
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    // Problem 2: Remove Duplicates from String Using StringBuilder
    public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== StringBuilder Problems ===\n");

        // Problem 1: Reverse String
        System.out.println("Problem 1: Reverse a String");
        String[] testStrings = { "hello", "Java Programming", "12345", "A man a plan a canal Panama" };

        for (String str : testStrings) {
            System.out.println("Original: \"" + str + "\"");
            System.out.println("Reversed: \"" + reverseString(str) + "\"");
            System.out.println();
        }

        System.out.println("=".repeat(50) + "\n");

        // Problem 2: Remove Duplicates
        System.out.println("Problem 2: Remove Duplicates from String");
        String[] duplicateStrings = {
                "programming",
                "hello world",
                "aabbccdd",
                "Java is awesome"
        };

        for (String str : duplicateStrings) {
            System.out.println("Original:  \"" + str + "\"");
            System.out.println("No Dupes:  \"" + removeDuplicates(str) + "\"");
            System.out.println();
        }
    }
}
