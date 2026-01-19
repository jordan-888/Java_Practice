
package coreprogramming.arrays.level1;

import java.util.Scanner;

public class StudentVoting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];

        System.out.println("Enter the age of 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }

        System.out.println("\nVoting Eligibility:");
        for (int i = 0; i < 10; i++) {
            if (ages[i] < 0) {
                System.out.println("Student " + (i + 1) + ": Invalid age (negative)");
            } else if (ages[i] >= 18) {
                System.out.println("Student " + (i + 1) + ": Can vote (age " + ages[i] + ")");
            } else {
                System.out.println("Student " + (i + 1) + ": Cannot vote (age " + ages[i] + ")");
            }
        }

        sc.close();
    }
}
