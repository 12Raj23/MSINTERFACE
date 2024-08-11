
    import java.util.Random;
import java.util.Scanner;

    public class GuessingGame {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            // Generate a random number between 1 and 100
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            int guess = 0;

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("I have chosen a number between 1 and 100. Try to guess it!");

            // Continue to prompt the user until they guess correctly
            while (guess != numberToGuess) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                numberOfAttempts++;

                if (guess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else if (guess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Congratulations! You've guessed the number.");
                    System.out.println("It took you " + numberOfAttempts + " attempts to win the game.");
                }
            }

            scanner.close();
        }
    }
