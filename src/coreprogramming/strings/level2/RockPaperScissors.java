
package coreprogramming.strings.level2;
import java.util.Scanner;

public class RockPaperScissors {
    public static String generateComputerChoice() {
        int random = (int) (Math.random() * 3);
        if (random == 0) {
            return "Rock";
        } else if (random == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    public static String determineWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "Draw";
        }

        if ((user.equals("Rock") && computer.equals("Scissors")) ||
                (user.equals("Paper") && computer.equals("Rock")) ||
                (user.equals("Scissors") && computer.equals("Paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    public static String[][] calculateStatistics(String[] results) {
        int userWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int i = 0; i < results.length; i++) {
            if (results[i].equals("User")) {
                userWins++;
            } else if (results[i].equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }
        }

        double userPercentage = (userWins * 100.0) / results.length;
        double computerPercentage = (computerWins * 100.0) / results.length;
        double drawPercentage = (draws * 100.0) / results.length;

        String[][] stats = new String[4][2];
        stats[0][0] = "User Wins";
        stats[0][1] = userWins + " (" + String.format("%.2f", userPercentage) + "%)";
        stats[1][0] = "Computer Wins";
        stats[1][1] = computerWins + " (" + String.format("%.2f", computerPercentage) + "%)";
        stats[2][0] = "Draws";
        stats[2][1] = draws + " (" + String.format("%.2f", drawPercentage) + "%)";
        stats[3][0] = "Total Games";
        stats[3][1] = String.valueOf(results.length);

        return stats;
    }

    public static void displayResults(String[][] stats) {
        System.out.println("\n=== Game Statistics ===");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + ": " + stats[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of games to play: ");
        int numGames = input.nextInt();

        String[] results = new String[numGames];

        for (int i = 0; i < numGames; i++) {
            System.out.print("\nGame " + (i + 1) + " - Enter your choice (Rock/Paper/Scissors): ");
            String userChoice = input.next();
            String computerChoice = generateComputerChoice();
            String winner = determineWinner(userChoice, computerChoice);

            results[i] = winner;

            System.out.println("Computer chose: " + computerChoice);
            System.out.println("Winner: " + winner);
        }

        String[][] stats = calculateStatistics(results);
        displayResults(stats);

        input.close();
    }
}
