package datastructures.linearandbinarysearch;
import java.io.*;

/**
 * FileReader Problem 2: Count the Occurrence of a Word in a File Using
 * FileReader
 * 
 * Problem:
 * Write a program that uses FileReader and BufferedReader to read a file
 * and count how many times a specific word appears in the file.
 * 
 * Approach:
 * 1. Create a FileReader to read from the file and wrap it in a BufferedReader
 * 2. Initialize a counter variable to keep track of word occurrences
 * 3. For each line in the file, split it into words and check if the target
 * word exists
 * 4. Increment the counter each time the word is found
 * 5. Print the final count
 */
public class CountWordOccurrenceUsingFileReader {

    public static int countWordOccurrence(String filename, String targetWord) {
        int count = 0;

        try (FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr)) {

            String line;

            while ((line = br.readLine()) != null) {
                // Split line into words and count occurrences
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Remove punctuation and compare case-insensitively
                    String cleanWord = word.replaceAll("[^a-zA-Z]", "");
                    if (cleanWord.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return count;
    }

    // Create a sample file for testing
    private static void createSampleFile(String filename) {
        try (FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("Java is a powerful programming language.\n");
            bw.write("Java is used for web development, mobile apps, and more.\n");
            bw.write("Learning Java opens many career opportunities.\n");
            bw.write("Java has a rich ecosystem of libraries and frameworks.\n");
            bw.write("Many companies use Java for enterprise applications.\n");

        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Count Word Occurrence in File Using FileReader ===\n");

        String sampleFile = "word_count_sample.txt";

        // Create sample file
        createSampleFile(sampleFile);
        System.out.println("Created sample file: " + sampleFile + "\n");

        // Count word occurrences
        String[] wordsToCount = { "Java", "is", "programming", "development", "Python" };

        for (String word : wordsToCount) {
            int count = countWordOccurrence(sampleFile, word);
            System.out.printf("Word '%s' appears %d time(s)%n", word, count);
        }

        // Clean up
        new File(sampleFile).delete();
    }
}
