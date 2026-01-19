
import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        // 2D array: [person][0=height, 1=weight, 2=bmi]
        double[][] data = new double[n][3];
        String[] statuses = new String[n];

        System.out.println("\nEnter details for " + n + " persons:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("Height (in meters): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Weight (in kg): ");
            data[i][1] = sc.nextDouble();

            // Calculate BMI and store in array
            data[i][2] = data[i][1] / (data[i][0] * data[i][0]);

            // Determine weight status
            if (data[i][2] < 18.5) {
                statuses[i] = "Underweight";
            } else if (data[i][2] < 25) {
                statuses[i] = "Normal weight";
            } else if (data[i][2] < 30) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }

        System.out.println("\n=== BMI Report (Using 2D Array) ===");
        System.out.printf("%-10s %-15s %-15s %-15s %-20s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-15.2f %-15.2f %-15.2f %-20s%n",
                    (i + 1), data[i][0], data[i][1], data[i][2], statuses[i]);
        }

        sc.close();
    }
}
