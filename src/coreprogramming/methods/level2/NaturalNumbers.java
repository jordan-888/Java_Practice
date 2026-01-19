
package coreprogramming.methods.level2;
import java.util.Scanner;

public class NaturalNumbers {
    public int recursiveSum(int n) {
        if (n < 1) {
            return 0;
        }
        return n + recursiveSum(n - 1);
    }

    public int formulaSum(int n) {
        if (n < 1) {
            return 0;
        }
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number:");
        int num = sc.nextInt();
        NaturalNumbers obj = new NaturalNumbers();
        System.out.printf("Sum using recursion: %d%n", obj.recursiveSum(num));
        System.out.printf("Sum using formula: %d%n", obj.formulaSum(num));
        sc.close();
    }
}
