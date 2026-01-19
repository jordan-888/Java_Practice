
package coreprogramming.arrays.level1;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] table = new int[10];

        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 0; i < 10; i++) {
            table[i] = number * (i + 1);
            System.out.println(number + " x " + (i + 1) + " = " + table[i]);
        }

        sc.close();
    }
}
