import java.util.Random;
import java.util.Scanner;

public class guessNumber {
    private static final int MAX_ATTEMPTS = 7;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("I'm thinking of a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts. Good luck!\n");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
            int guess;

            try {
                guess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            attempts++;

            if (guess < LOWER_BOUND || guess > UPPER_BOUND) {
                System.out.println("Your guess is out of bounds. Try a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
            } else if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                guessedCorrectly = true;
                break;
            }
        }

        if (guessedCorrectly) {
            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry, you ran out of attempts. The number was: " + numberToGuess);
        }

        scanner.close();
    }
}
