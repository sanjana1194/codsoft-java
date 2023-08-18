import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        int startRange = 1;
        int endRange = 100;
        int maxAttempts = 10;
        int rounds = 3;

        playMultipleRounds(startRange, endRange, maxAttempts, rounds);
    }

    public static int generateRandomNumber(int startRange, int endRange) {
        Random random = new Random();
        return random.nextInt(endRange  + 1) ;
    }

    public static int getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess: ");
        try {
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return getUserGuess();
        }
    }

    public static String compareGuess(int guess, int targetNumber) {
        if (guess == targetNumber) {
            return "Correct";
        } else if (guess < targetNumber) {
            return "Too low";
        } else {
            return "Too high";
        }
    }

    public static boolean playNumberGame(int startRange, int endRange, int maxAttempts) {
        int targetNumber = generateRandomNumber(startRange, endRange);
        int attempts = 0;

        while (attempts < maxAttempts) {
            int userGuess = getUserGuess();
            String result = compareGuess(userGuess, targetNumber);
            System.out.println(result);

            if (result.equals("Correct")) {
                System.out.println("Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
                return true;
            }

            attempts++;
        }

        System.out.println("Sorry, you have run out of attempts. The number was: " + targetNumber);
        return false;
    }

    public static void playMultipleRounds(int startRange, int endRange, int maxAttempts, int rounds) {
        int roundsWon = 0;

        for (int i = 0; i < rounds; i++) {
            System.out.println("Round " + (i + 1));
            if (playNumberGame(startRange, endRange, maxAttempts)) {
                roundsWon++;
            }
        }

        System.out.println("Game over. You won " + roundsWon + " out of " + rounds + " rounds.");
    }
}
