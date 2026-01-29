package datastructures.linearandbinarysearch;
import java.io.*;

/**
 * FileReader Problems
 * Problem 1: Read File Line by Line
 * Problem 2: Count Word Occurrence in File
 */
public class FileReaderProblems {

    // Problem 1: Read File Line by Line
    public static void readFileLineByLine(String filename) {
        System.out.println("Reading file: " + filename);
        System.out.println("=".repeat(50));

        try (FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr)) {

            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                System.out.printf("%3d: %s%n", lineNumber++, line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Problem 2: Count Word Occurrence in File
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

        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== FileReader Problems ===\n");

        String sampleFile = "sample_java.txt";

        // Create sample file
        createSampleFile(sampleFile);
        System.out.println("Created sample file: " + sampleFile + "\n");

        // Problem 1: Read File Line by Line
        System.out.println("Problem 1: Read File Line by Line\n");
        readFileLineByLine(sampleFile);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Problem 2: Count Word Occurrence
        System.out.println("Problem 2: Count Word Occurrence in File\n");
        String[] wordsToCount = { "Java", "is", "programming", "development" };

        for (String word : wordsToCount) {
            int count = countWordOccurrence(sampleFile, word);
            System.out.printf("Word '%s' appears %d time(s)%n", word, count);
        }

        // Clean up
        new File(sampleFile).delete();
    }
}
