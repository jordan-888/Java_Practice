import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter a number:", new Object[0]);
        int num = sc.nextInt();
        if (num >= 1) {
            int sum = num * (num + 1) / 2;
            System.out.printf("The sum of %d natural numbers is %d%n", num, sum);
        } else {
            System.out.printf("The number %d is not a natural number.%n", num);
        }
        sc.close();
    }
}
