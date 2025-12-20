import java.util.Scanner;

public class SimpleInterest {
    public int calculateSI(int p, int r, int t) {
        return (p * r * t) / 100;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal, Rate and Time: ");
        int p = sc.nextInt();
        int r = sc.nextInt();
        int t = sc.nextInt();

        SimpleInterest obj = new SimpleInterest();
        int si = obj.calculateSI(p, r, t);
        System.out.println("Simple Interest is " + si + " for Principal " + p + ", Rate " + r + "% and Time " + t);
        sc.close();
    }
}
