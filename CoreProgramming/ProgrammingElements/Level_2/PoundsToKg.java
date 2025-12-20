import java.util.Scanner;

public class PoundsToKg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter weight in pounds: ");
        double pounds = input.nextDouble();
        double kg = pounds / 2.2;
        System.out.printf("The weight in pounds is %.2f and in kilograms is %.2f kg%n", pounds, kg);
        input.close();
    }
}
