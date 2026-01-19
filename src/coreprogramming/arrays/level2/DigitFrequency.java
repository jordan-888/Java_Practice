
import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = Math.abs(sc.nextLong());

        // Array to store frequency of digits 0-9
        int[] frequency = new int[10];

        // Count frequency of each digit
        if (number == 0) {
            frequency[0] = 1;
        } else {
            while (number > 0) {
                int digit = (int) (number % 10);
                frequency[digit]++;
                number /= 10;
            }
        }

        System.out.println("\n=== Digit Frequency ===");
        System.out.printf("%-10s %-15s%n", "Digit", "Frequency");
        System.out.println("-------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10d %-15d%n", i, frequency[i]);
        }

        System.out.println("\nDigits present in the number:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " appears " + frequency[i] + " time(s)");
            }
        }

        sc.close();
    }
}
