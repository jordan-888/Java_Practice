
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[] heights = new double[n];
        double[] weights = new double[n];
        double[] bmis = new double[n];
        String[] statuses = new String[n];

        System.out.println("\nEnter details for " + n + " persons:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("Height (in meters): ");
            heights[i] = sc.nextDouble();
            System.out.print("Weight (in kg): ");
            weights[i] = sc.nextDouble();

            // Calculate BMI
            bmis[i] = weights[i] / (heights[i] * heights[i]);

            // Determine weight status
            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] < 25) {
                statuses[i] = "Normal weight";
            } else if (bmis[i] < 30) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }

        System.out.println("\n=== BMI Report ===");
        System.out.printf("%-10s %-15s %-15s %-15s %-20s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-15.2f %-15.2f %-15.2f %-20s%n",
                    (i + 1), heights[i], weights[i], bmis[i], statuses[i]);
        }

        sc.close();
    }
}
