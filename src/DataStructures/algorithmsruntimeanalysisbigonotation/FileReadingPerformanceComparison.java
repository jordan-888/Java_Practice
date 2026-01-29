package datastructures.algorithmsruntimeanalysisbigonotation;
import java.io.*;

/**
 * Problem 4: Large File Reading Efficiency
 * 
 * Objective:
 * Compare FileReader (Character Stream) and InputStreamReader (Byte Stream)
 * when reading large files.
 * 
 * Performance:
 * - FileReader: Character-based, good for text files
 * - InputStreamReader: Byte-based, more efficient for large files
 */
public class FileReadingPerformanceComparison {

    // Read file using FileReader
    public static int readWithFileReader(String filename) throws IOException {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        }
        return wordCount;
    }

    // Read file using InputStreamReader
    public static int readWithInputStreamReader(String filename) throws IOException {
        int wordCount = 0;
        try (FileInputStream fis = new FileInputStream(filename);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        }
        return wordCount;
    }

    // Create test file
    private static void createTestFile(String filename, int lines) throws IOException {
        try (FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < lines; i++) {
                bw.write("This is line " + i + " with some sample text for performance testing purposes.\n");
            }
        }
    }

    // Benchmark function
    public static void benchmark(int lines) throws IOException {
        String filename = "test_file_" + lines + ".txt";

        System.out.printf("File Size: %,d lines (~%.2f MB)%n", lines, (lines * 80.0) / (1024 * 1024));
        System.out.println("=".repeat(50));

        // Create test file
        createTestFile(filename, lines);
        File file = new File(filename);
        long fileSize = file.length();
        System.out.printf("Actual file size: %.2f MB%n", fileSize / (1024.0 * 1024.0));

        // FileReader test
        long startTime = System.nanoTime();
        int wordCount1 = readWithFileReader(filename);
        long fileReaderTime = System.nanoTime() - startTime;

        // InputStreamReader test
        startTime = System.nanoTime();
        int wordCount2 = readWithInputStreamReader(filename);
        long inputStreamReaderTime = System.nanoTime() - startTime;

        System.out.printf("FileReader:        %,d words in %,d ns (%.3f ms)%n",
                wordCount1, fileReaderTime, fileReaderTime / 1_000_000.0);
        System.out.printf("InputStreamReader: %,d words in %,d ns (%.3f ms)%n",
                wordCount2, inputStreamReaderTime, inputStreamReaderTime / 1_000_000.0);
        System.out.printf("Performance ratio: %.2fx%n", (double) fileReaderTime / inputStreamReaderTime);

        // Clean up
        file.delete();
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== File Reading Performance Comparison ===");
        System.out.println("FileReader vs InputStreamReader\n");

        int[] lineCounts = { 1_000, 10_000, 100_000 };

        try {
            for (int lines : lineCounts) {
                benchmark(lines);
            }

            System.out.println("Conclusion:");
            System.out.println("- InputStreamReader is generally more efficient");
            System.out.println("- FileReader is simpler for text-only files");
            System.out.println("- Both should be wrapped with BufferedReader");
            System.out.println("- Performance difference is minimal for small files");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
