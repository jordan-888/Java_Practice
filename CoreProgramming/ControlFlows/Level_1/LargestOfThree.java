import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter three numbers:", new Object[0]);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        System.out.printf("Is the first number the largest? %s%n", (num1 >= num2 && num1 >= num3) ? "Yes" : "No");
        System.out.printf("Is the second number the largest? %s%n", (num2 >= num1 && num2 >= num3) ? "Yes" : "No");
        System.out.printf("Is the third number the largest? %s%n", (num3 >= num1 && num3 >= num2) ? "Yes" : "No");
        sc.close();
    }
}
