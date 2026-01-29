package datastructures.linearandbinarysearch;
import java.util.HashSet;

/**
 * StringBuilder Problem 2: Remove Duplicates from a String Using StringBuilder
 * 
 * Problem:
 * Write a program that uses StringBuilder to remove all duplicate characters
 * from a given string while maintaining the original order.
 * 
 * Approach:
 * 1. Initialize an empty StringBuilder and a HashSet to keep track of
 * characters
 * 2. Iterate over each character in the string
 * 3. If the character is not in the HashSet, append it to the StringBuilder and
 * add it to the HashSet
 * 4. Return the StringBuilder as a string without duplicates
 */
public class RemoveDuplicatesUsingStringBuilder {

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
        System.out.println("=== Remove Duplicates from String Using StringBuilder ===\n");

        String[] testStrings = {
                "programming",
                "hello world",
                "aabbccdd",
                "Java is awesome",
                "Mississippi",
                "bookkeeper"
        };

        for (String str : testStrings) {
            String result = removeDuplicates(str);
            System.out.println("Original:  \"" + str + "\"");
            System.out.println("No Dupes:  \"" + result + "\"");
            System.out.println("Removed:   " + (str.length() - result.length()) + " duplicate characters");
            System.out.println();
        }
    }
}
