
package coreprogramming.strings.level2;
public class VotingEligibility {
    public static int[] generateAges() {
        int[] ages = new int[10];
        for (int i = 0; i < ages.length; i++) {
            ages[i] = (int) (Math.random() * 90) + 10; // 10 to 99
        }
        return ages;
    }

    public static String[][] checkEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "Invalid Age";
            } else if (ages[i] >= 18) {
                result[i][1] = "Eligible";
            } else {
                result[i][1] = "Not Eligible";
            }
        }

        return result;
    }

    public static void displayResults(String[][] data) {
        System.out.println("\nStudent\t\tAge\tEligibility");
        System.out.println("----------------------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + "\t\t" + data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        int[] ages = generateAges();
        String[][] eligibility = checkEligibility(ages);
        displayResults(eligibility);
    }
}
