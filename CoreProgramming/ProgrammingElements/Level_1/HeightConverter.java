import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter height in centimeters:");
        double cm = sc.nextDouble();
        double inches = cm / 2.54;
        double feet = inches / 12.0;
        System.out.printf("Your height in cm is %.2f while in feet is %.2f and inches is %.2f%n", cm, feet, inches);
        sc.close();
    }
}
