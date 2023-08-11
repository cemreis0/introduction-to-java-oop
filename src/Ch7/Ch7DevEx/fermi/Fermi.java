/*
Write an application that plays the game of Fermi. Generate three distinct
random digits between 0 and 9. These digits are assigned to positions 1, 2, and
3. The goal of the game is for the player to guess the digits in three positions
correctly in the least number of tries. For each guess, the player provides three
digits for positions 1, 2, and 3. The program replies with a hint consisting of
Fermi, Pico, or Nano. If the digit guessed for a given position is correct, then
the reply is Fermi. If the digit guessed for a given position is in a different
position, the reply is Pico. If the digit guessed for a given position does not
match any of the three digits, then the reply is Nano.
*/

package Ch7.Ch7DevEx.fermi;

import java.util.Random;
import java.util.Scanner;

public class Fermi {
    // data members
    private static final int UPPER_BOUND = 9; // the digits must be between 9
    private static final int LOWER_BOUND = 0; // and 0
    private static Random random;
    private int num1, num2, num3; // randomly generated number

    // Constructors
    public Fermi() {
        random = new Random();
        randomize();
    }

    // assign random values to the three digits
    private void randomize() {
        num1 = random.nextInt(UPPER_BOUND - LOWER_BOUND) + LOWER_BOUND;
        num2 = random.nextInt(UPPER_BOUND - LOWER_BOUND) + LOWER_BOUND;
        num3 = random.nextInt(UPPER_BOUND - LOWER_BOUND) + LOWER_BOUND;
    }

    // return the condition for a given position and value
    // example: sequence - 1 2 5, give 5 and 1 as the arguments, 5 is present in the sequence, but its index is not 1
    // return: 1 - fermi, 0 - pico, -1 - nano, -2 is error
    public int check(int guess, int position) {
        int condition = -1;

        if (position < 1 || position > 3) {
            return -2; // Invalid position
        }

        if (guess == num1 && position == 1 ||
            guess == num2 && position == 2 ||
            guess == num3 && position == 3) {

            condition = 1;

        } else if (guess == num1 || guess == num2 || guess == num3) {
            condition = 0;
        }

        return condition;
    }
}

class Play {
    // data members
    private enum Response {YES, NO}
    Scanner scanner;
    Fermi fermi;

    // Constructor
    public Play() {
        scanner = new Scanner(System.in);
    }

    // main method
    public static void main(String[] args) {
        Play play = new Play();
        play.start();
        System.exit(0);
    }

    // start the game loop
    public void start() {
        Response response;

        describeGame();
        response = isContinue("Would you like the play a Fermi game?");

        while (response == Response.YES) {
            play();
            response = isContinue("Would you like the play another Fermi game?");
        }

        System.out.print("Thanks for playing. Goodbye!");
    }

    // play one game
    private void play() {
        int guess1, guess2, guess3;
        int result1, result2, result3; // result after checking the guesses
        fermi = new Fermi();

        do {
            System.out.print("Guess 3 digits (guess1 guess2 guess3): ");
            guess1 = scanner.nextInt();
            guess2 = scanner.nextInt();
            guess3 = scanner.nextInt();
            scanner.nextLine();

            result1 = fermi.check(guess1, 1);
            result2 = fermi.check(guess2, 2);
            result3 = fermi.check(guess3, 3);

            System.out.println();
            System.out.format("%9s%26s", "Guess", "Hint");
            System.out.println();
            System.out.format("%-5d%-5d%-5d", guess1, guess2, guess3);
            System.out.format("%10s%10s%10s", getHint(result1), getHint(result2), getHint(result3));
            System.out.println("\n");

            if (result1 == 1 && result2 == 1 && result3 == 1) {
                System.out.println("Congratulations! You won.");
                break;
            }
        } while (true);
    }

    // return one of pico, nano and fermi for a given number, ie the result
    private String getHint(int result) {
        String response = "Error";

        if (result == 1) {
            response = "Fermi";
        } else if (result == 0) {
            response = "Pico";
        } else if (result == -1) {
            response = "Nano";
        }

        return response;
    }

    // describe the game
    private void describeGame() {
        System.out.println("Welcome to the game of Fermi!");
        System.out.println("I have selected three random digits between 0 and 9.");
        System.out.println("Your goal is to guess these digits in the correct order.");
        System.out.println("After each guess, I will provide you with hints:");
        System.out.println("- Fermi: The guessed digit is in the correct position.");
        System.out.println("- Pico: The guessed digit is in the sequence, but not in the correct position.");
        System.out.println("- Nano: The guessed digit is not in the sequence at all.");
        System.out.println("Let's start! Good luck!");
        System.out.println();
    }

    // ask the player to continue
    private Response isContinue(String request) {
        String response; // string response from the user

        while (true) {
            System.out.print(request + " Y - yes, N - no: ");
            response = scanner.nextLine(); // keep taking responses until a valid string is entered
            if (response.equals("Y") || response.equals("y")) {
                return Response.YES;
            } else if (response.equals("N") || response.equals("n")) {
                return Response.NO;
            } else {
                System.out.println("Invalid response. Enter again.");
            }
        }
    }
}