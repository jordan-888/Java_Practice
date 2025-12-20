
import java.util.Scanner;
import java.util.Arrays;

public class DynamicDigitStorage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = Math.abs(sc.nextInt());

        int[] digits = new int[5]; // Initial size
        int count = 0;
        int temp = number;

        if (temp == 0) {
            digits[count++] = 0;
        } else {
            while (temp > 0) {
                if (count >= digits.length) {
                    // Dynamically increase array size
                    digits = Arrays.copyOf(digits, digits.length * 2);
                    System.out.println("Array size increased to: " + digits.length);
                }
                digits[count++] = temp % 10;
                temp /= 10;
            }
        }

        // Reverse to get correct order
        System.out.print("Digits: ");
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(digits[i] + " ");
        }
        System.out.println();

        // Find largest and second largest
        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < count; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Total digits: " + count);
        System.out.println("Largest digit: " + largest);
        if (secondLargest != -1) {
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("No second largest digit (all digits are the same)");
        }

        sc.close();
    }
}
