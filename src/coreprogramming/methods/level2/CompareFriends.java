
package coreprogramming.methods.level2;
import java.util.Scanner;

public class CompareFriends {
    public static int compareAge(int age1, int age2, int age3) {
        if (age1 < age2 && age1 < age3) {
            return 1;
        } else if (age2 < age3) {
            return 2;
        } else {
            return 3;
        }
    }

    public static int compareHeight(int height1, int height2, int height3) {
        if (height1 > height2 && height1 > height3) {
            return 1;
        } else if (height2 > height3) {
            return 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];

        System.out.print("Enter the ages of 3 friends:");
        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
        }

        System.out.print("Enter the heights (in cm) of 3 friends:");
        for (int i = 0; i < 3; i++) {
            heights[i] = sc.nextInt();
        }

        System.out.printf("Youngest friend is %d%n", compareAge(ages[0], ages[1], ages[2]));
        System.out.printf("Tallest friend is %d%n", compareHeight(heights[0], heights[1], heights[2]));
        sc.close();
    }
}
