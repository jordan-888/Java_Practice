package datastructures.linearandbinarysearch;
import java.io.*;

/**
 * Challenge Problem: Compare StringBuilder, StringBuffer, FileReader, and
 * InputStreamReader
 * 
 * Problem:
 * Write a program that:
 * 1. Uses StringBuilder and StringBuffer to concatenate a list of strings
 * 1,000,000 times
 * 2. Uses FileReader and InputStreamReader to read a large file and print the
 * number of words
 * 
 * Approach:
 * StringBuilder and StringBuffer:
 * - Create a list of strings (e.g., "hello")
 * - Concatenate the strings 1,000,000 times using both StringBuilder and
 * StringBuffer
 * - Measure and compare the time taken for each
 * 
 * FileReader and InputStreamReader:
 * - Read a large text file using FileReader and InputStreamReader
 * - Count the number of words by splitting the text on whitespace characters
 * - Print the word count and compare the time taken for reading the file
 */
public class CompareAllUtilities {

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
        System.out.println("=== Challenge: Compare All Utilities ===\n");

        // Part 1: StringBuilder vs StringBuffer
        compareStringBuilders(1_000_000);

        // Part 2: FileReader vs InputStreamReader
        String testFile = "comparison_test_file.txt";
        createLargeFile(testFile, 10_000);
        compareFileReaders(testFile);

        // Clean up
        new File(testFile).delete();
    }
}
