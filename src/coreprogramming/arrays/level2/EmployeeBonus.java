
import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] oldSalaries = new double[10];
        int[] yearsOfService = new int[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

        System.out.println("Enter details for 10 employees:");
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            System.out.print("Old Salary: ");
            oldSalaries[i] = sc.nextDouble();
            System.out.print("Years of Service: ");
            yearsOfService[i] = sc.nextInt();

            // Calculate bonus based on years of service
            if (yearsOfService[i] >= 10) {
                bonuses[i] = oldSalaries[i] * 0.20; // 20% bonus
            } else if (yearsOfService[i] >= 5) {
                bonuses[i] = oldSalaries[i] * 0.15; // 15% bonus
            } else if (yearsOfService[i] >= 3) {
                bonuses[i] = oldSalaries[i] * 0.10; // 10% bonus
            } else {
                bonuses[i] = oldSalaries[i] * 0.05; // 5% bonus
            }

            newSalaries[i] = oldSalaries[i] + bonuses[i];
        }

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        System.out.println("\n=== Employee Bonus Report ===");
        System.out.printf("%-10s %-15s %-10s %-15s %-15s%n", "Employee", "Old Salary", "Years", "Bonus", "New Salary");
        System.out.println("------------------------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10d %-15.2f %-10d %-15.2f %-15.2f%n",
                    (i + 1), oldSalaries[i], yearsOfService[i], bonuses[i], newSalaries[i]);
            totalBonus += bonuses[i];
            totalOldSalary += oldSalaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.printf("Total Old Salary: %.2f%n", totalOldSalary);
        System.out.printf("Total Bonus Payout: %.2f%n", totalBonus);
        System.out.printf("Total New Salary: %.2f%n", totalNewSalary);

        sc.close();
    }
}
