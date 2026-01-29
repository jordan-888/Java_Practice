package datastructures.linearandbinarysearch;
import java.io.*;

/**
 * FileReader Problem 1: Read a File Line by Line Using FileReader
 * 
 * Problem:
 * Write a program that uses FileReader to read a text file line by line
 * and print each line to the console.
 * 
 * Approach:
 * 1. Create a FileReader object to read from the file
 * 2. Wrap the FileReader in a BufferedReader to read lines efficiently
 * 3. Use a loop to read each line using the readLine() method and print it to
 * the console
 * 4. Close the file after reading all the lines
 */
public class ReadFileLineByLineUsingFileReader {

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

    // Create a sample file for testing
    private static void createSampleFile(String filename) {
        try (FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("Java is a powerful programming language.\n");
            bw.write("It is used for web development, mobile apps, and more.\n");
            bw.write("Learning Java opens many career opportunities.\n");
            bw.write("Java has a rich ecosystem of libraries and frameworks.\n");
            bw.write("Object-oriented programming is a key feature of Java.\n");

        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Read File Line by Line Using FileReader ===\n");

        String sampleFile = "sample_file.txt";

        // Create sample file
        createSampleFile(sampleFile);
        System.out.println("Created sample file: " + sampleFile + "\n");

        // Read file line by line
        readFileLineByLine(sampleFile);

        // Clean up
        new File(sampleFile).delete();
    }
}
