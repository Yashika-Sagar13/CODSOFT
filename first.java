    
import java.util.Scanner;
import java.util.Random;

public class first  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a number between " + minRange + " and " + maxRange + ".");
                } else if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Your total score is: " + score);
                break;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

