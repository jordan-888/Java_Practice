
package coreprogramming.methods.level2;
import java.util.Scanner;

public class FactorOps {
    static int index = 0;

    static int[] factorization(double num) {
        int[] factors = new int[100];
        index = 0;

        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                factors[index++] = i;
                num = num / i;
            }
        }

        if (num > 1) {
            factors[index++] = (int) num;
        }

        return factors;
    }

    public int factorSum(int num) {
        int sum = 0;
        int[] factors = factorization(num);
        for (int i = 0; i < index; i++) {
            sum += factors[i];
        }
        return sum;
    }

    public int factorProduct(int num) {
        int product = 1;
        int[] factors = factorization(num);
        for (int i = 0; i < index; i++) {
            product *= factors[i];
        }
        return product;
    }

    public int factorSquare(int num) {
        int sum = 0;
        int[] factors = factorization(num);
        for (int i = 0; i < index; i++) {
            sum += (int) Math.pow(factors[i], 2.0);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num = sc.nextInt();
        FactorOps obj = new FactorOps();
        System.out.printf("Sum of factors: %d%n", obj.factorSum(num));
        System.out.printf("Product of factors: %d%n", obj.factorProduct(num));
        System.out.printf("Sum of squares of factors: %d%n", obj.factorSquare(num));
        sc.close();
    }
}
