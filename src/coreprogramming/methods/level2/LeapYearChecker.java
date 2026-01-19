
package coreprogramming.methods.level2;
import java.util.Scanner;

public class LeapYearChecker {
    public void checkLeapYear(int year) {
        if (year < 1582) {
            return;
        }

        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year:");
        int year = sc.nextInt();
        LeapYearChecker obj = new LeapYearChecker();
        obj.checkLeapYear(year);
        sc.close();
    }
}
