package datastructures.linearandbinarysearch;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * InputStreamReader Problem 1: Convert Byte Stream to Character Stream Using
 * InputStreamReader
 * 
 * Problem:
 * Write a program that uses InputStreamReader to read binary data from a file
 * and print it as characters. The file contains data encoded in a specific
 * charset (e.g., UTF-8).
 * 
 * Approach:
 * 1. Create a FileInputStream object to read the binary data from the file
 * 2. Wrap the FileInputStream in an InputStreamReader to convert the byte
 * stream into a character stream
 * 3. Use a BufferedReader to read characters efficiently from the
 * InputStreamReader
 * 4. Read the file line by line and print the characters to the console
 * 5. Handle any encoding exceptions as needed
 */
public class ConvertByteStreamToCharacterStream {

    public static void readFileWithEncoding(String filename) {
        System.out.println("Reading file with UTF-8 encoding: " + filename);
        System.out.println("=".repeat(50));

        try (FileInputStream fis = new FileInputStream(filename);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr)) {

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

    // Create a sample file with special characters
    private static void createSampleFileWithEncoding(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw)) {

            bw.write("Hello World! 你好世界!\n");
            bw.write("Java supports Unicode: ñ, é, ü, ö\n");
            bw.write("Symbols: © ® ™ € £ ¥\n");
            bw.write("Emojis and special chars: ♠ ♣ ♥ ♦\n");
            bw.write("Mathematical symbols: ∑ ∫ √ ∞\n");

        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Convert Byte Stream to Character Stream Using InputStreamReader ===\n");

        String sampleFile = "encoding_sample.txt";

        // Create sample file with special characters
        createSampleFileWithEncoding(sampleFile);
        System.out.println("Created sample file with UTF-8 encoding\n");

        // Read file with proper encoding
        readFileWithEncoding(sampleFile);

        // Clean up
        new File(sampleFile).delete();
    }
}
