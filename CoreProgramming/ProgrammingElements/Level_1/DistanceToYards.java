import java.util.Scanner;

public class DistanceToYards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter distance in feet:");
        double feet = sc.nextDouble();
        double yards = feet / 3.0;
        double miles = yards / 1760.0;
        System.out.printf("The distance in feet is %.2f, in yards is %.2f and in miles is %.2f%n", feet, yards, miles);
        sc.close();
    }
}
