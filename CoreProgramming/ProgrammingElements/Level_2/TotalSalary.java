import java.util.Scanner;

public class TotalSalary {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter basic salary and bonus:");
        double salary = input.nextDouble();
        double bonus = input.nextDouble();
        double totSal = salary + bonus;
        System.out.printf("The salary is INR %.2f and bonus is INR %.2f. Hence Total Salary is %.2f%n", salary, bonus,
                totSal);
        input.close();
    }
}
