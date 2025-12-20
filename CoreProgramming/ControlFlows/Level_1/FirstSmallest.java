import java.util.Scanner;

public class FirstSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 numbers :");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        System.out.printf("Is the first number the smallest? %s%n", (num1 <= num2 && num1 <= num3) ? "Yes" : "No");
        sc.close();
    }
}
