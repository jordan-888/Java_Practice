package datastructures.linearandbinarysearch;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * InputStreamReader Problems
 * Problem 1: Convert Byte Stream to Character Stream
 * Problem 2: Read User Input and Write to File
 */
public class InputStreamReaderProblems {

    // Problem 1: Convert Byte Stream to Character Stream
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

    // Problem 2: Read User Input and Write to File (simulated)
    public static void writeInputToFile(String[] inputs, String outputFile) {
        System.out.println("Writing inputs to file: " + outputFile);

        try (FileWriter fw = new FileWriter(outputFile);
                BufferedWriter bw = new BufferedWriter(fw)) {

            for (String input : inputs) {
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exit command received. Stopping input.");
                    break;
                }
                bw.write(input);
                bw.newLine();
                System.out.println("Written: " + input);
            }

            System.out.println("File written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
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

        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== InputStreamReader Problems ===\n");

        // Problem 1: Convert Byte Stream to Character Stream
        System.out.println("Problem 1: Convert Byte Stream to Character Stream\n");

        String sampleFile = "sample_encoding.txt";
        createSampleFileWithEncoding(sampleFile);
        readFileWithEncoding(sampleFile);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Problem 2: Read User Input and Write to File
        System.out.println("Problem 2: Read User Input and Write to File\n");

        // Simulated user inputs
        String[] simulatedInputs = {
                "First line of input",
                "Second line of input",
                "Java programming is fun!",
                "This is the last line",
                "exit"
        };

        String outputFile = "user_input.txt";
        writeInputToFile(simulatedInputs, outputFile);

        System.out.println("\nReading back the written file:\n");
        readFileWithEncoding(outputFile);

        // Clean up
        new File(sampleFile).delete();
        new File(outputFile).delete();
    }
}
