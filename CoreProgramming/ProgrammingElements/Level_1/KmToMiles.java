import java.util.Scanner;

public class KmToMiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter distance in kilometers:");
        double km = sc.nextDouble();
        double miles = km * 1.6;
        System.out.printf("%.2f kilometers is equal to %.2f miles.%n", km, miles);
        sc.close();
    }
}
