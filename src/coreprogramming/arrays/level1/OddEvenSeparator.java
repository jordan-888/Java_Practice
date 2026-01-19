
package coreprogramming.arrays.level1;

import java.util.Scanner;

public class OddEvenSeparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("Invalid input! Please enter a natural number (positive integer).");
            sc.close();
            return;
        }

        int oddCount = (n + 1) / 2;
        int evenCount = n / 2;

        int[] oddNumbers = new int[oddCount];
        int[] evenNumbers = new int[evenCount];

        int oddIndex = 0, evenIndex = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i;
            } else {
                oddNumbers[oddIndex++] = i;
            }
        }

        System.out.println("\nOdd numbers from 1 to " + n + ":");
        for (int i = 0; i < oddCount; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        System.out.println("\n\nEven numbers from 1 to " + n + ":");
        for (int i = 0; i < evenCount; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
