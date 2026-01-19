
package coreprogramming.methods.level2;
import java.util.Scanner;
import java.lang.Math;

public class RandomGenerator {
    public int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return numbers;
    }

    public double[] findAverageMinMax(int[] numbers) {
        double[] results = new double[3];
        double sum = 0;
        int max = numbers[0];
        int min = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        results[0] = sum / numbers.length; // average
        results[1] = max; // maximum
        results[2] = min; // minimum
        return results;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of array:");
        int size = input.nextInt();
        RandomGenerator obj = new RandomGenerator();
        int[] numbers = obj.generate4DigitRandomArray(size);
        double[] results = obj.findAverageMinMax(numbers);
        System.out.printf("The average of %d numbers is: %.2f\n", size, results[0]);
        System.out.printf("The maximum of %d numbers is: %.2f\n", size, results[1]);
        System.out.printf("The minimum of %d numbers is: %.2f\n", size, results[2]);
        input.close();
    }
}