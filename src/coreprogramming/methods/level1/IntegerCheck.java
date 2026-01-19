
package coreprogramming.methods.level1;
import java.util.Scanner;

public class IntegerCheck {
    public int checkInteger(int num) {
        if (num > 0) {
            return 1;
        } else if (num < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer :");
        int num = sc.nextInt();
        IntegerCheck obj = new IntegerCheck();
        System.out.printf("%d", obj.checkInteger(num), new Object[0]);
        sc.close();
    }
}
