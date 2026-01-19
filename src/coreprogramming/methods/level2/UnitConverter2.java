
package coreprogramming.methods.level2;
import java.util.Scanner;

public class UnitConverter2 {
    public static double convertYardsToFeet(double yards) {
        return yards * 3.0;
    }

    public static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }

    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }

    public static double convertInchesToCentimeters(double inches) {
        return inches * 2.54;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Select conversion type:");
        System.out.print(
                "\n1. Yards to Feet\n2. Feet to Yards\n3. Meters to Inches\n4. Inches to Meters\n5. Inches to Centimeters\n");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter yards:");
                double yards = sc.nextDouble();
                System.out.printf("Feet: %.2f%n", convertYardsToFeet(yards));
                break;
            case 2:
                System.out.print("Enter feet:");
                double feet = sc.nextDouble();
                System.out.printf("Yards: %.2f%n", convertFeetToYards(feet));
                break;
            case 3:
                System.out.print("Enter meters:");
                double meters = sc.nextDouble();
                System.out.printf("Inches: %.2f%n", convertMetersToInches(meters));
                break;
            case 4:
                System.out.print("Enter inches:");
                double inches = sc.nextDouble();
                System.out.printf("Meters: %.2f%n", convertInchesToMeters(inches));
                break;
            case 5:
                System.out.print("Enter inches:");
                double inches2 = sc.nextDouble();
                System.out.printf("Centimeters: %.2f%n", convertInchesToCentimeters(inches2));
                break;
            default:
                System.out.println("Invalid choice.");
        }
        sc.close();
    }
}
