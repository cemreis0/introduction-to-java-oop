package Ch6.Ch6SampleDevelopment;

import java.util.*;

public class HiLoGame {
    public static void main(String[] args) {
        Ch6HiLo hiLo = new Ch6HiLo();
        hiLo.start();
    }
}

class Ch6HiLo {
    // data members
    private final int MAX_GUESS_ALLOWED = 6;
    private int lowerBound;
    private int upperBound;
    private int secretNumber;
    private Random random;
    private static enum Response {YES, NO}
    private Scanner scanner;

    // constructor
    public Ch6HiLo() {
        scanner = new Scanner(System.in);
        random = new Random( );
    }

    // start the Hi-Lo game playing. the user has an option of playing a game or not.
    public void start() {
        Response response;
        Response displayRules;

        displayRules = prompt("Do you want to see the rules?");
        if (displayRules == Response.YES) {
            describeRules();
        }

        response = prompt("Do you want to play a Hi-Lo game?");

        lowerBound = 0; // reset the bounds after each game
        upperBound = 0;

        while (response == Response.YES) {
            lowerBound = getPositiveInteger("Enter the lower bound: ");
            upperBound = getPositiveInteger("Enter the upper bound: ");
            generateSecretNumber();
            playGame();
            response = prompt("Do you want to play another Hi-Lo game?");
        }

        System.out.println("Thanks for playing Hi-Lo.");
    }

    // describe the game's rules
    private void describeRules() {
        System.out.println("Welcome. You need to guess the secret number in 6 guesses. You set the range of numbers.");
    }

    // generate a random number between 1 and 100 for the next game
    private void generateSecretNumber() {
        secretNumber = random.nextInt(upperBound) + lowerBound;
    }

    // play one game
    private void playGame() {
        int guessCount = 0; // number of guesses so far
        int guess; // number guessed by the user

        do {
            guess = getNextGuess();
            guessCount++;

            if (guess < secretNumber) {
                System.out.println("Your guess is LO.");
            } else if (guess > secretNumber) {
                System.out.println("Your guess is HI.");
            }

        } while (guessCount < MAX_GUESS_ALLOWED && guess != secretNumber);

        if (guess == secretNumber) {
            System.out.println("Congratulations! You won.");
        } else {
            System.out.println("You lost.");
        }
    }

    // return the next from the user
    private int getNextGuess(){
        int input;

        while (true) {
            System.out.print("Next Guess: ");

            input = scanner.nextInt();

            if (lowerBound <= input && input <= upperBound) {
                return input;
            }

        //invalid input; print error message
        System.out.println(
            "Invalid Input: " +
            "Must be between " + lowerBound +
            " and " + upperBound);
        }
    }

    // prompt the user for a yes/no reply
    private Response prompt(String request) {
        String input;
        Response response = Response.NO;

        System.out.print(request + " (Yes - y, No - n): ");

        input = scanner.next();

        if (input.equals("Y") || input.equals("y")) {
            response = Response.YES;
        }

        return response;
    }

    // get a positive integer from the user
    private int getPositiveInteger(String request) {
        int number;
        do {
            System.out.print(request);
            number = scanner.nextInt();
            if (number < 0) {
                System.out.println("You must enter a positive integer.");
            }
        } while (number < 0);

        return number;
    }
}
