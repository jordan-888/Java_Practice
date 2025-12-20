
import java.util.Scanner;

public class LargestDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = Math.abs(sc.nextInt());

        // Count digits
        int temp = number;
        int digitCount = 0;
        if (temp == 0) {
            digitCount = 1;
        } else {
            while (temp > 0) {
                digitCount++;
                temp /= 10;
            }
        }

        // Store digits in array
        int[] digits = new int[digitCount];
        temp = number;
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        // Find largest and second largest
        int largest = -1;
        int secondLargest = -1;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }

        System.out.println("Largest digit: " + largest);
        if (secondLargest != -1) {
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("No second largest digit (all digits are the same)");
        }

        sc.close();
    }
}
