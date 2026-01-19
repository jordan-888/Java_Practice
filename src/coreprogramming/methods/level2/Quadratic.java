
package coreprogramming.methods.level2;
import java.util.Scanner;
import java.lang.Math;

public class Quadratic {
    public static double[] calculateRoots(double a, double b, double c) {
        double[] root = new double[2];
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta > 0) {
            root[0] = (-b + Math.sqrt(delta)) / (2 * a);
            root[1] = (-b - Math.sqrt(delta)) / (2 * a);
        } else if (delta == 0) {
            root[0] = root[1] = -b / (2 * a);
        } else
            return null;
        return root;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the coefficients a, b and c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double[] root = calculateRoots(a, b, c);

        if (root != null) {
            System.out.printf("The roots of the quadratic equation are %.2f and %.2f%n", root[0], root[1]);
        } else {
            System.out.println("No real roots exist (complex roots)");
        }

        input.close();
    }
}