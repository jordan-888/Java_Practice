
package coreprogramming.arrays.level1;

import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0;

        System.out.println("Enter the height of 11 football players (in cm):");

        for (int i = 0; i < 11; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }

        double mean = sum / 11;

        System.out.println("\nHeights of all players:");
        for (int i = 0; i < 11; i++) {
            System.out.println("Player " + (i + 1) + ": " + heights[i] + " cm");
        }

        System.out.printf("\nMean height of the team: %.2f cm%n", mean);

        sc.close();
    }
}
