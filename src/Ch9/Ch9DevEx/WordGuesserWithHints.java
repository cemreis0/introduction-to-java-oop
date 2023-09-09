/**
 * Write another word guessing game similar to the one described in Exercise 27.
 * For this word game, instead of using a row of dashes for a secret word, a
 * hint is provided by displaying the letters in the secret word in random order.
 * For example, if the secret word is COMPUTER, then a possible hint is
 * MPTUREOC. The player has only one chance to enter a guess. The player
 * wins if he guessed the word correctly. Time how long the player took to
 * guess the secret word. After a guess is entered, display whether the guess is
 * correct or not. If correct, display the amount of time in minutes and seconds
 * used by the player.
 * The tally will include for each player the number of wins and the total
 * amount of time taken for guessing the secret words correctly (amount of
 * time used for incorrect guesses is not tallied). The player with more wins
 * is the winner. In the case where both players have the same number of wins,
 * the one who used the lesser amount of time for correct guesses is the winner.
 * If the total time used by both players is the same also, then it is a draw.
 */


package Ch9.Ch9DevEx;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordGuesserWithHints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuePrompt;
        int status;
        WordGuesserWithHints wordGuesserWithHints = new WordGuesserWithHints();
        Player p1 = new Player();
        Player p2 = new Player();

        while (true) {
            System.out.println("Player 1 enters the secret word, player 2 guesses.");
            status = wordGuesserWithHints.play();

            if (status == 1) {
                System.out.println("Player 2 won! +1 score.");
                p2.incrementScore();
            } else {
                System.out.println("Player 1 won! +1 score.");
                p1.incrementScore();
            }

            System.out.println("Player 2 enters the secret word, player 1 guesses.");
            status = wordGuesserWithHints.play();

            if (status == 1) {
                System.out.println("Player 1 won! +1 score.");
                p1.incrementScore();
            } else {
                System.out.println("Player 2 won! +1 score.");
                p2.incrementScore();
            }

            System.out.println("Would you like to continue? (type in NO to terminate the game):");
            continuePrompt = scanner.nextLine();

            if (continuePrompt.equalsIgnoreCase("NO")) {
                System.out.println("Player 1 score: " + p1.getScore());
                System.out.println("Player 2 score: " + p2.getScore());
                if (p1.getScore() == p2.getScore()) {
                    System.out.println("That's a draw.");
                } else if (p1.getScore() > p2.getScore()) {
                    System.out.println("Player 1 won!");
                } else {
                    System.out.println("Player 2 won!");
                }
                break;
            }
        }
    }

    // return status to change the score, 1 is win, -1 is loss
    public int play() {
        Scanner scanner = new Scanner(System.in);
        String secretWord;
        String guessedWord;
        int status; // terminate or continue the game, 0 continue, 1 won

        WordGuesserWithHintsGame wordGuesserWithHintsGame = new WordGuesserWithHintsGame();

        while (true) {
            try {
                System.out.print("Enter the secret word: ");
                secretWord = scanner.nextLine();
                wordGuesserWithHintsGame.setSecretWord(secretWord);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid word entered. " + e.getMessage());
                System.out.println();
            }
        }

        System.out.print("Enter your guessed word: ");
        guessedWord = scanner.nextLine();
        status = wordGuesserWithHintsGame.makeGuess(guessedWord);
        if (status == 1) {
            System.out.println("Congrats! You won.");
        }
        if (status == -1) {
            System.out.println("You lost.");
        }

        return status;
    }
}

class WordGuesserWithHintsGame {
    // data members
    private final String VALID_WORD_IDENTIFIER = "[A-Z]{3,25}"; // the word must comply with this identifier
    private Pattern wordPattern;
    private Matcher wordMatcher;
    private String secretWord;
    private StringBuilder scrambledWord;
    Random random;

    // constructors
    public WordGuesserWithHintsGame(String secretWord) {
        wordPattern = Pattern.compile(VALID_WORD_IDENTIFIER);
        random = new Random();
        setSecretWord(secretWord);
    }
    public WordGuesserWithHintsGame() {
        wordPattern = Pattern.compile(VALID_WORD_IDENTIFIER);
        random = new Random();
    }

    public void setSecretWord(String secretWord) throws IllegalArgumentException {
        secretWord = secretWord.toUpperCase(); // make the word uppercase in order to comply with wordPattern

        wordMatcher = wordPattern.matcher(secretWord);

        if (!wordMatcher.matches()) {
            if (secretWord.length() < 3 || secretWord.length() > 25) {
                throw new IllegalArgumentException("The length of a word must be between 3 and 25.");
            }
            throw new IllegalArgumentException("A word must contain only letters.");
        }

        this.secretWord = secretWord;

        System.out.println();
        System.out.println("Secret word: " + secretWord);

        setScrambledWord();
        System.out.println("Scrambled word: " + scrambledWord.toString());
    }

    private void setScrambledWord() {
        scrambledWord = new StringBuilder();
        StringBuilder secretWordTemp = new StringBuilder(secretWord);
        int count = 0;
        int randomIndex;
        while (count < secretWord.length()) {
            randomIndex = random.nextInt(secretWordTemp.length());
            scrambledWord.append(secretWordTemp.charAt(randomIndex));
            secretWordTemp.deleteCharAt(randomIndex);
            count++;
        }
    }

    public String getSecretWord() {
        return secretWord;
    }

    public int makeGuess(String guessedWord) {
        guessedWord = guessedWord.toUpperCase();
        if (guessedWord.equals(secretWord)) {
            return 1;
        } else {
            return -1;
        }
    }
}