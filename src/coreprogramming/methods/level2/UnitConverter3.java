
package coreprogramming.methods.level2;
import java.util.Scanner;

public class UnitConverter3 {
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kg) {
        return kg * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select conversion type:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Pounds to Kilograms");
        System.out.println("4. Kilograms to Pounds");
        System.out.println("5. Gallons to Liters");
        System.out.println("6. Liters to Gallons");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter temperature in Celsius:");
                double celsius = sc.nextDouble();
                System.out.printf("Temperature in Fahrenheit: %.2f%n", convertCelsiusToFahrenheit(celsius));
                break;
            case 2:
                System.out.print("Enter temperature in Fahrenheit:");
                double fahrenheit = sc.nextDouble();
                System.out.printf("Temperature in Celsius: %.2f%n", convertFahrenheitToCelsius(fahrenheit));
                break;
            case 3:
                System.out.print("Enter weight in Pounds:");
                double pounds = sc.nextDouble();
                System.out.printf("Weight in Kilograms: %.2f%n", convertPoundsToKilograms(pounds));
                break;
            case 4:
                System.out.print("Enter weight in Kilograms:");
                double kg = sc.nextDouble();
                System.out.printf("Weight in Pounds: %.2f%n", convertKilogramsToPounds(kg));
                break;
            case 5:
                System.out.print("Enter volume in Gallons:");
                double gallons = sc.nextDouble();
                System.out.printf("Volume in Liters: %.2f%n", convertGallonsToLiters(gallons));
                break;
            case 6:
                System.out.print("Enter volume in Liters:");
                double liters = sc.nextDouble();
                System.out.printf("Volume in Gallons: %.2f%n", convertLitersToGallons(liters));
                break;
            default:
                System.out.println("Invalid selection.");
        }
        sc.close();
    }
}
