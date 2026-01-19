
package coreprogramming.arrays.level1;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the range (up to which number): ");
        int n = sc.nextInt();

        String[] fizzBuzzArray = new String[n];

        for (int i = 0; i < n; i++) {
            int num = i + 1;

            if (num % 3 == 0 && num % 5 == 0) {
                fizzBuzzArray[i] = "FizzBuzz";
            } else if (num % 3 == 0) {
                fizzBuzzArray[i] = "Fizz";
            } else if (num % 5 == 0) {
                fizzBuzzArray[i] = "Buzz";
            } else {
                fizzBuzzArray[i] = String.valueOf(num);
            }
        }

        System.out.println("\nFizzBuzz Results:");
        for (int i = 0; i < n; i++) {
            System.out.println("Index " + i + ": " + fizzBuzzArray[i]);
        }

        sc.close();
    }
}
