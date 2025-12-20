import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = input.nextDouble();
        double fahrenheitResult = (celsius * 9 / 5) + 32;
        System.out.printf("The %.2f Celsius in Fahrenheit is %.2f%n", celsius, fahrenheitResult);
        input.close();
    }
}
