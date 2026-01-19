
package coreprogramming.arrays.level1;

import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\nNumber Analysis:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + " (" + numbers[i] + "): ");

            if (numbers[i] > 0) {
                System.out.print("Positive, ");
                if (numbers[i] % 2 == 0) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else if (numbers[i] < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

        System.out.println("\nComparison of first and last elements:");
        if (numbers[0] > numbers[4]) {
            System.out.println("First element (" + numbers[0] + ") is greater than last element (" + numbers[4] + ")");
        } else if (numbers[0] < numbers[4]) {
            System.out.println("First element (" + numbers[0] + ") is less than last element (" + numbers[4] + ")");
        } else {
            System.out.println("First element (" + numbers[0] + ") is equal to last element (" + numbers[4] + ")");
        }

        sc.close();
    }
}
