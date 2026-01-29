package datastructures.linearandbinarysearch;
import java.io.*;
import java.util.Arrays;

/**
 * Challenge Problem: Comprehensive Comparison
 * - StringBuilder vs StringBuffer performance
 * - FileReader vs InputStreamReader for large files
 * - Linear Search for missing positive integer
 * - Binary Search for target index
 */
public class ChallengeProblems {

    // Part 1: Compare StringBuilder and StringBuffer
    public static void compareStringBuilders(int iterations) {
        System.out.println("=== Part 1: StringBuilder vs StringBuffer ===\n");
        System.out.printf("Concatenating %,d strings%n%n", iterations);

        // StringBuilder test
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("hello");
        }
        long sbTime = System.nanoTime() - startTime;

        // StringBuffer test
        startTime = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append("hello");
        }
        long sbufTime = System.nanoTime() - startTime;

        System.out.printf("StringBuilder: %,d ns (%.2f ms)%n", sbTime, sbTime / 1_000_000.0);
        System.out.printf("StringBuffer:  %,d ns (%.2f ms)%n", sbufTime, sbufTime / 1_000_000.0);
        System.out.printf("Performance ratio: %.2fx%n", (double) sbufTime / sbTime);
    }

    // Part 2: Compare FileReader and InputStreamReader
    public static void compareFileReaders(String filename) {
        System.out.println("\n=== Part 2: FileReader vs InputStreamReader ===\n");

        // FileReader test
        long startTime = System.nanoTime();
        int wordCountFR = 0;
        try (FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCountFR += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error with FileReader: " + e.getMessage());
        }
        long frTime = System.nanoTime() - startTime;

        // InputStreamReader test
        startTime = System.nanoTime();
        int wordCountISR = 0;
        try (FileInputStream fis = new FileInputStream(filename);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCountISR += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error with InputStreamReader: " + e.getMessage());
        }
        long isrTime = System.nanoTime() - startTime;

        System.out.printf("FileReader:        %,d words in %,d ns (%.2f ms)%n",
                wordCountFR, frTime, frTime / 1_000_000.0);
        System.out.printf("InputStreamReader: %,d words in %,d ns (%.2f ms)%n",
                wordCountISR, isrTime, isrTime / 1_000_000.0);
    }

    // Part 3: Linear Search for First Missing Positive
    public static int findFirstMissingPositive(int[] arr) {
        // Mark elements in range [1, n]
        int n = arr.length;

        // Replace negative numbers and zeros with n+1
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                arr[i] = n + 1;
            }
        }

        // Mark presence of numbers by making values negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num <= n) {
                arr[num - 1] = -Math.abs(arr[num - 1]);
            }
        }

        // Find first positive index
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Part 4: Binary Search for Target Index
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Create a large test file
    private static void createLargeFile(String filename, int lines) {
        try (FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < lines; i++) {
                bw.write("This is line " + i + " with some sample text for testing purposes.\n");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Challenge Problems ===\n");

        // Part 1: StringBuilder vs StringBuffer
        compareStringBuilders(1_000_000);

        // Part 2: FileReader vs InputStreamReader
        String testFile = "large_test_file.txt";
        createLargeFile(testFile, 10_000);
        compareFileReaders(testFile);

        // Part 3 & 4: Linear and Binary Search
        System.out.println("\n=== Part 3 & 4: Search Algorithms ===\n");

        int[] testArray = { 3, 4, -1, 1, 7, 2, 9 };
        System.out.println("Original array: " + Arrays.toString(testArray));

        // Linear Search for first missing positive
        int[] arrayCopy = Arrays.copyOf(testArray, testArray.length);
        int missingPositive = findFirstMissingPositive(arrayCopy);
        System.out.println("First missing positive integer: " + missingPositive);

        // Binary Search for target
        int[] sortedArray = Arrays.copyOf(testArray, testArray.length);
        Arrays.sort(sortedArray);
        System.out.println("\nSorted array: " + Arrays.toString(sortedArray));

        int[] targets = { 1, 7, 5, 10 };
        for (int target : targets) {
            int index = binarySearch(sortedArray, target);
            if (index != -1) {
                System.out.printf("Target %d found at index %d%n", target, index);
            } else {
                System.out.printf("Target %d not found%n", target);
            }
        }

        // Clean up
        new File(testFile).delete();
    }
}
