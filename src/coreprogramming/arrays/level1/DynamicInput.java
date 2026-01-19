
package coreprogramming.arrays.level1;

import java.util.Scanner;

public class DynamicInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];
        int count = 0;
        int sum = 0;

        System.out.println("Enter up to 10 numbers (enter 0 or negative to stop):");

        for (int i = 0; i < 10; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            int num = sc.nextInt();

            if (num <= 0) {
                break;
            }

            numbers[count] = num;
            sum += num;
            count++;
        }

        System.out.println("\nYou entered " + count + " numbers:");
        for (int i = 0; i < count; i++) {
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
        }

        System.out.println("\nSum of all numbers: " + sum);

        sc.close();
    }
}
