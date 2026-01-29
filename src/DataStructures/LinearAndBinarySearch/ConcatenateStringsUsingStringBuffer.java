package datastructures.linearandbinarysearch;
import java.util.Arrays;

/**
 * StringBuffer Problem 1: Concatenate Strings Efficiently Using StringBuffer
 * 
 * Problem:
 * You are given an array of strings. Write a program that uses StringBuffer
 * to concatenate all the strings in the array efficiently.
 * 
 * Approach:
 * 1. Create a new StringBuffer object
 * 2. Iterate through each string in the array and append it to the StringBuffer
 * 3. Return the concatenated string after the loop finishes
 * 4. Using StringBuffer ensures efficient string concatenation due to its
 * mutable nature
 */
public class ConcatenateStringsUsingStringBuffer {

    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Concatenate Strings Efficiently Using StringBuffer ===\n");

        // Test case 1
        String[] words1 = { "Java", " ", "is", " ", "awesome", "!" };
        System.out.println("Test Case 1:");
        System.out.println("Input array: " + Arrays.toString(words1));
        System.out.println("Concatenated: \"" + concatenateStrings(words1) + "\"");
        System.out.println();

        // Test case 2
        String[] words2 = { "Hello", ", ", "World", "!" };
        System.out.println("Test Case 2:");
        System.out.println("Input array: " + Arrays.toString(words2));
        System.out.println("Concatenated: \"" + concatenateStrings(words2) + "\"");
        System.out.println();

        // Test case 3
        String[] words3 = { "One", "Two", "Three", "Four", "Five" };
        System.out.println("Test Case 3:");
        System.out.println("Input array: " + Arrays.toString(words3));
        System.out.println("Concatenated: \"" + concatenateStrings(words3) + "\"");
    }
}
