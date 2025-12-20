import java.util.Scanner;

public class Chocolates {
    public static int[] findRemainderAndQuotient(int number, int divisor){
        int remainder = number % divisor;
        int quotient = number / divisor;
        return new int[] {remainder, quotient};
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of chocolates and students: ");
        int number = sc.nextInt();
        int divisor = sc.nextInt();
        int[] res = Chocolates.findRemainderAndQuotient(number, divisor);
        System.out.printf("The number of chocolates each child gets is %d and the number of chocolates remaining is %d%n", res[1], res[0]);
        sc.close();
    }
}
