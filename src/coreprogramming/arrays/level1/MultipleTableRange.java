
package coreprogramming.arrays.level1;

import java.util.Scanner;

public class MultipleTableRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] tables = new int[4][10];

        System.out.println("Multiplication Tables from 6 to 9:\n");

        for (int i = 0; i < 4; i++) {
            int number = 6 + i;
            System.out.println("Table of " + number + ":");

            for (int j = 0; j < 10; j++) {
                tables[i][j] = number * (j + 1);
                System.out.println(number + " x " + (j + 1) + " = " + tables[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}
