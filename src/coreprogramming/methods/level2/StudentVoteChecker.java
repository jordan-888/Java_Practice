
package coreprogramming.methods.level2;
import java.util.Scanner;

public class StudentVoteChecker {
    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the age of 10 students:");
        int[] ages = new int[10];
        for (int i = 0; i < 10; i++) {
            ages[i] = sc.nextInt();
        }

        StudentVoteChecker obj = new StudentVoteChecker();
        for (int i = 0; i < 10; i++) {
            System.out.printf("Can student %d vote? %s%n", i + 1, obj.canStudentVote(ages[i]));
        }
        sc.close();
    }
}
