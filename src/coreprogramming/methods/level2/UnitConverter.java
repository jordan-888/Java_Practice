
package coreprogramming.methods.level2;
import java.util.Scanner;

public class UnitConverter {
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select conversion type:");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Miles to Kilometers");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter distance in kilometers:");
                double km = sc.nextDouble();
                System.out.printf("%.2f kilometers is equal to %.2f miles.%n", km, convertKmToMiles(km));
                break;
            case 2:
                System.out.print("Enter distance in miles:");
                double miles = sc.nextDouble();
                System.out.printf("%.2f miles is equal to %.2f kilometers.%n", miles, convertMilesToKm(miles));
                break;
            case 3:
                System.out.print("Enter length in meters:");
                double meters = sc.nextDouble();
                System.out.printf("%.2f meters is equal to %.2f feet.%n", meters, convertMetersToFeet(meters));
                break;
            case 4:
                System.out.print("Enter length in feet:");
                double feet = sc.nextDouble();
                System.out.printf("%.2f feet is equal to %.2f meters.%n", feet, convertFeetToMeters(feet));
                break;
            default:
                System.out.println("Invalid option.");
        }
        sc.close();
    }
}
