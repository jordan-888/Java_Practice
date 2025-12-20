import java.util.Scanner;

public class FeeDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the original fee:");
        double originalFee = sc.nextDouble();
        System.out.print("Enter the discount percentage:");
        double discountPercent = sc.nextDouble();
        double discountAmount = (discountPercent / 100.0) * originalFee;
        double finalFee = originalFee - discountAmount;
        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f\\n", discountAmount,
                finalFee);
        sc.close();
    }
}
