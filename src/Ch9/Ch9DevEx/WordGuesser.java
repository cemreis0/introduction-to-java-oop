/**
 * Write a word guessing game. The game is played by two players, each
 * taking a turn in guessing the secret word entered by the other player. Ask the
 * first player to enter a secret word. After a secret word is entered, display a
 * hint that consists of a row of dashes, one for each letter in the secret word.
 * Then ask the second player to guess a letter in the secret word. If the letter is
 * in the secret word, replace the dashes in the hint with the letter at all
 * positions where this letter occurs in the word. If the letter does not appear in
 * the word, the number of incorrect guesses is incremented by 1. The second
 * player keeps guessing letters until either
 * • The player guesses all the letters in the word. or
 * • The player makes 10 incorrect guesses.
 * Here’s a sample interaction with blue indicating the letter entered by the player:
 * - - - -
 * S
 * - - - -
 * A
 * - A - A
 * V
 * - A V A
 * D
 * - A V A
 * J
 * J A V A
 * Bingo! You won.
 * Support the following features:
 * • Accept an input in either lowercase or uppercase.
 * • If the player enters something other than a single letter (a digit, special
 * character, multiple letters, etc.), display an error message. The number
 * of incorrect guesses is not incremented.
 * • If the player enters the same correct letter more than once, reply with
 * the previous hint
 * • Entering an incorrect letter the second time is counted as another
 * wrong guess. For example, suppose the letter W is not in the secret
 * word. Every time the player enters W as a guess, the number of
 * incorrect guesses is incremented by 1.
 * After a game is over, switch the role of players and continue with
 * another game. When it is the first player’s turn to enter a secret word, give
 * an option to the players to stop playing. Keep the tally and announce the
 * winner at the end of the program. The tally will include for each player the
 * number of wins and the total number of incorrect guesses made for all
 * games. The player with more wins is the winner. In the case where both
 * players have the same number of wins, the one with the lower number of
 * total incorrect guesses is the winner. If the total numbers of incorrect guesses
 * for both players are the same also, then it is a draw.
 */

package Ch9.Ch9DevEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordGuesser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuePrompt;
        int status = 0;
        WordGuesser wordGuesser = new WordGuesser();
        Player p1 = new Player();
        Player p2 = new Player();

        while (true) {
            System.out.println("Player 1 enters the secret word, player 2 guesses.");
            status = wordGuesser.play();

            if (status == 1) {
                System.out.println("Player 2 won! +1 score.");
                p2.incrementScore();
            } else {
                System.out.println("Player 1 won! +1 score.");
                p1.incrementScore();
            }

            System.out.println("Player 2 enters the secret word, player 1 guesses.");
            status = wordGuesser.play();

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
        String guess;
        int status = 0; // terminate or continue the game, 0 continue, 1 won

        WordGuesserGame wordGuesserGame = new WordGuesserGame();

        while (true) {
            try {
                System.out.print("Enter the secret word: ");
                secretWord = scanner.nextLine();
                wordGuesserGame.setSecretWord(secretWord);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid word entered. " + e.getMessage());
                System.out.println();
            }
        }

        System.out.println(wordGuesserGame.getGuessedWord());

        while (status == 0) {
            while (true) {
                try {
                    // System.out.print("Take a guess: ");
                    guess = scanner.nextLine();
                    status = wordGuesserGame.makeGuess(guess);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid guess entered. " + e.getMessage());
                    System.out.println();
                }
            }
            if (status == 1) {
                System.out.println("Congrats! You won.");
                break;
            }
            if (status == -1) {
                System.out.println("Your guesses ran out! You lost.");
                break;
            }
            System.out.println(wordGuesserGame.getGuessedWord());
        }

        return status;
    }
}

class WordGuesserGame {
    // data members
    private final String VALID_WORD_IDENTIFIER = "[A-Z]{3,25}"; // the word must comply with this identifier
    private final String VALID_GUESS_IDENTIFIER = "[A-Z]"; // the guessed letter must comply with this identifier
    private Pattern wordPattern, guessPattern;
    private Matcher wordMatcher, guessMatcher;
    private String secretWord;
    private StringBuilder guessedWord;
    private int numberOfGuesses;

    // constructors
    public WordGuesserGame(String secretWord) {
        wordPattern = Pattern.compile(VALID_WORD_IDENTIFIER);
        guessPattern = Pattern.compile(VALID_GUESS_IDENTIFIER);
        numberOfGuesses = 10;
        setSecretWord(secretWord);
    }
    public WordGuesserGame() {
        wordPattern = Pattern.compile(VALID_WORD_IDENTIFIER);
        guessPattern = Pattern.compile(VALID_GUESS_IDENTIFIER);
        numberOfGuesses = 10;
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

        setGuessedWord();
    }

    public void setGuessedWord() {
        guessedWord = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            guessedWord.append("-");
        }
    }

    public String getSecretWord() {
        return secretWord;
    }

    public String getGuessedWord() {
        return guessedWord.toString();
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public int makeGuess(String guess) {
        if (numberOfGuesses < 1) {
            return -1;
        }

        guess = guess.toUpperCase();

        guessMatcher = guessPattern.matcher(guess);

        if(!guessMatcher.matches()) {
            if (guess.length() != 1) {
                throw new IllegalArgumentException("The length of a guess must be 1.");
            }
            throw new IllegalArgumentException("A guess must contain only letters.");
        }

        numberOfGuesses--;

        for (int i = 0; i < secretWord.length(); i++) {
            if (guess.equals(Character.toString(secretWord.charAt(i)))) {
                guessedWord.replace(i, i+1, guess);
            }
        }

        if (guessedWord.toString().equals(secretWord)) {
            return 1;
        }

        return 0;
    }
}

class Player {
    // data members
    private int score;

    // constructors
    public Player() {
        score = 0;
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}