
package coreprogramming.methods.level2;
import java.util.Scanner;

public class NumbersComparison {
    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 numbers :");
        int[] numbers = new int[3];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            if (isPositive(numbers[i])) {
                if (isEven(numbers[i])) {
                    System.out.print("Positive and Even number\n");
                } else {
                    System.out.print("Positive and Odd number\n");
                }
            } else {
                System.out.print("Negative number\n");
            }
        }

        int result = compare(numbers[0], numbers[2]);
        if (result == 1) {
            System.out.print("First is greater\n");
        } else if (result == 0) {
            System.out.print("Both are equal\n");
        } else if (result == -1) {
            System.out.print("Second is greater\n");
        }

        sc.close();
    }
}
