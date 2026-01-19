
package coreprogramming.methods.level1;
import java.util.Scanner;

public class SI {

    public double calculateSI (double p, double r, double t){
        return p * r * (t / 100);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        SI obj = new SI();
        System.out.printf("Enter the principal, rate and time(in years) : ");
        double p = input.nextDouble();
        double r = input.nextDouble();
        double t = input.nextDouble();

        System.out.printf("The simple interest is %.2f for principal %.2f, rate %.2f and time %.2f%n", obj.calculateSI(p, r, t), p, r, t);
        input.close();
    }
}