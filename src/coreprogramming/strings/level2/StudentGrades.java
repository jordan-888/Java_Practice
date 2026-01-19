
package coreprogramming.strings.level2;
import java.util.Scanner;

public class StudentGrades {
    public static int[][] generateMarks(int numStudents) {
        int[][] marks = new int[numStudents][3]; // Physics, Chemistry, Math

        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = (int) (Math.random() * 90) + 10; // 10 to 99
            }
        }

        return marks;
    }

    public static double[][] calculateStats(int[][] marks) {
        double[][] stats = new double[marks.length][3]; // Total, Average, Percentage

        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round to 2 decimal places
            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return stats;
    }

    public static String[] assignGrades(double[][] stats) {
        String[] grades = new String[stats.length];

        for (int i = 0; i < stats.length; i++) {
            double percentage = stats[i][2];

            if (percentage >= 90) {
                grades[i] = "A+";
            } else if (percentage >= 80) {
                grades[i] = "A";
            } else if (percentage >= 70) {
                grades[i] = "B";
            } else if (percentage >= 60) {
                grades[i] = "C";
            } else if (percentage >= 50) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        return grades;
    }

    public static void displayResults(int[][] marks, double[][] stats, String[] grades) {
        System.out.println("\nStudent\tPhysics\tChem\tMath\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("================================================================================");

        for (int i = 0; i < marks.length; i++) {
            System.out.print((i + 1) + "\t");
            System.out.print(marks[i][0] + "\t" + marks[i][1] + "\t" + marks[i][2] + "\t");
            System.out.print((int) stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2] + "%\t\t");
            System.out.println(grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = input.nextInt();

        int[][] marks = generateMarks(numStudents);
        double[][] stats = calculateStats(marks);
        String[] grades = assignGrades(stats);

        displayResults(marks, stats, grades);

        input.close();
    }
}
