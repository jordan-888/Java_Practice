
package coreprogramming.arrays.level1;

import java.util.Scanner;
import java.util.Arrays;

public class FactorFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = new int[10];
        int count = 0;

        System.out.println("\nFactors of " + number + ":");

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (count >= factors.length) {
                    factors = Arrays.copyOf(factors, factors.length * 2);
                }
                factors[count++] = i;
                System.out.print(i + " ");
            }
        }

        System.out.println("\n\nTotal number of factors: " + count);

        System.out.println("\nFactors stored in array:");
        for (int i = 0; i < count; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
