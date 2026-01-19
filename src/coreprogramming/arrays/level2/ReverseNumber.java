
import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        boolean isNegative = number < 0;
        number = Math.abs(number);

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

        System.out.print("Original digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        // Display in reverse order
        System.out.print("Reversed number: ");
        if (isNegative) {
            System.out.print("-");
        }
        for (int i = digitCount - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
        System.out.println();

        sc.close();
    }
}
