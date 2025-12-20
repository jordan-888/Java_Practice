import java.util.Scanner;

public class DoubleOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 3 numbers: ");
        double a = input.nextInt();
        double b = input.nextInt();
        double c = input.nextInt();
        double op1 = a + b * c;
        double op2 = a * b + c;
        double op3 = c + (double) a / b;
        double op4 = a % b + c;
        System.out.printf("The results of Int Operations are %.2f, %.2f, %.2f and %.2f%n", op1, op2, op3, op4);
        input.close();
    }
}
