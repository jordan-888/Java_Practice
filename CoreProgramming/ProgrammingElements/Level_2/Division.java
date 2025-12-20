import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 2 numbers: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        System.out.println("The quotient is " + num1 / num2 + " and the remainder is " + num1 % num2 + " of 2 numbers "
                + num1 + " and " + num2);
        input.close();
    }
}
