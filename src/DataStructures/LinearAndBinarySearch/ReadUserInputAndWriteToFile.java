package datastructures.linearandbinarysearch;
import java.io.*;

/**
 * InputStreamReader Problem 2: Read User Input and Write to File Using
 * InputStreamReader
 * 
 * Problem:
 * Write a program that uses InputStreamReader to read user input from the
 * console
 * and write the input to a file. Each input should be written as a new line in
 * the file.
 * 
 * Approach:
 * 1. Create an InputStreamReader to read from System.in (the console)
 * 2. Wrap the InputStreamReader in a BufferedReader for efficient reading
 * 3. Create a FileWriter to write to the file
 * 4. Read user input using readLine() and write the input to the file
 * 5. Repeat the process until the user enters "exit" to stop inputting
 * 6. Close the file after the input is finished
 */
public class ReadUserInputAndWriteToFile {

    public static void writeInputToFile(String[] inputs, String outputFile) {
        System.out.println("Writing inputs to file: " + outputFile);
        System.out.println();

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

            System.out.println("\nFile written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Read file back to verify
    private static void readFileBack(String filename) {
        System.out.println("\nReading back the written file:");
        System.out.println("=".repeat(50));

        try (FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr)) {

            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                System.out.printf("%3d: %s%n", lineNumber++, line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Read User Input and Write to File Using InputStreamReader ===\n");

        // Simulated user inputs (in real scenario, would read from System.in)
        String[] simulatedInputs = {
                "First line of input",
                "Second line of input",
                "Java programming is fun!",
                "InputStreamReader is useful for encoding",
                "This is the last line",
                "exit"
        };

        String outputFile = "user_input_output.txt";

        // Write inputs to file
        writeInputToFile(simulatedInputs, outputFile);

        // Read file back to verify
        readFileBack(outputFile);

        // Clean up
        new File(outputFile).delete();
    }
}
