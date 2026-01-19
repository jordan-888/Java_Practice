
package coreprogramming.methods.level2;
import java.util.Scanner;

public class BMI {
    public static void calculateBmi(double[][] personInfo) {
        for (int i = 0; i < personInfo.length; i++) {
            personInfo[i][2] = personInfo[i][0] / (personInfo[i][1] * personInfo[i][1]);
        }
    }

    public static String[] BMIstatus(double[][] personInfo) {
        String[] status = new String[personInfo.length];

        for (int i = 0; i < personInfo.length; i++) {
            double bmi = personInfo[i][2];

            if (bmi <= 18.4)
                status[i] = "Underweight";
            else if (bmi >= 18.5 && bmi <= 24.9)
                status[i] = "Normal";
            else if (bmi >= 25.0 && bmi <= 39.9)
                status[i] = "Overweight";
            else if (bmi >= 40.0)
                status[i] = "Obese";
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] personInfo = new double[10][3];

        System.out.print("Enter weight and height of 10 people one by one: ");
        for (int i = 0; i < personInfo.length; i++) {
            personInfo[i][0] = input.nextInt();
            personInfo[i][1] = input.nextInt();
        }
        calculateBmi(personInfo);
        String[] status = BMIstatus(personInfo);
        for (int i = 0; i < personInfo.length; i++) {
            System.out.printf("Person %d:\t Weight: %.2f\t Height: %.2f\t BMI: %.2f\t Status: %s%n", i + 1,
                    personInfo[i][0], personInfo[i][1], personInfo[i][2], status[i]);
        }
        input.close();
    }
}