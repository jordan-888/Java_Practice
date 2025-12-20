import java.util.Scanner;

public class Triangle {
    public double laps(double a, double b, double c) {
        return 5 / (a + b + c);
    }

    public static void main(String args[]) {
        Triangle obj = new Triangle();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the lenghts of the three sides of the triangle: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        System.out.printf("The total number of rounds the athlete will run is %.2f to complete 5km%n",
                obj.laps(a, b, c));
        sc.close();
    }
}
