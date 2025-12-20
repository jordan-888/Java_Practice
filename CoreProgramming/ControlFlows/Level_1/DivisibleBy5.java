import java.util.Scanner;

public class DivisibleBy5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num = sc.nextInt();
        System.out.printf("Is the number %d divisible by 5?", num);
        if (num % 5 == 0) {
            System.out.printf(" Yes%n", new Object[0]);
        } else {
            System.out.printf(" No%n", new Object[0]);
        }
        sc.close();
    }
}
