/**
 * Write a variation of the Eggy-Peggy program. Implement the following four variations:
 * • Sha: Add sha to the beginning of every word.
 * • Na: Add na to the end of every word.
 * • Sha Na Na: Add sha to the beginning and na na to the end of every word.
 * • Ava: Move the first letter to the end of the word and add ava to it.
 * Allow the user to select one of four possible variations.
 */


package Ch9.Ch9DevEx;

import java.sql.PreparedStatement;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ShaNaNa {
    public static void main(String[] args) {
        ShaNaNaService shaNaNaService = new ShaNaNaService();
        int input;
        String result, string;

        shaNaNaService.displayChoices();

        while (true) {
            try {
                input = shaNaNaService.getChoice();
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        string = shaNaNaService.getString();

        result = shaNaNaService.getProcessedString(input, string);

        System.out.println("Processed string: " + result);
    }
}

class ShaNaNaService {
    // data members
    final static String NEW_LINE = "\n";
    Scanner scanner;

    // constructors
    public ShaNaNaService() {
        scanner = new Scanner(System.in);
    }

    public void displayChoices() {
        System.out.println(
            "Type in the number that you'd like to choose." + NEW_LINE + NEW_LINE
            + "1. Sha: Add sha to the beginning of every word." + NEW_LINE
            + "2. Na: Add na to the end of every word." + NEW_LINE
            + "3. Sha Na Na: Add sha to the beginning and na na to the end of every word." + NEW_LINE
            + "4. Ava: Move the first letter to the end of the word and add ava to it." + NEW_LINE
        );
    }

    public int getChoice() throws IllegalArgumentException, InputMismatchException {
        int input;

        System.out.print("Enter number: ");

        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Input must be an integer.");
        } finally {
            scanner.nextLine();
        }

        if (input < 1 || input > 4) {
            scanner.nextLine();
            throw new IllegalArgumentException("The number must match the index of one of the choices.");
        }

        return input;
    }

    // get the string to process
    public String getString() {
        String input;

        System.out.println("Enter text: ");
        input = scanner.nextLine();

        return input;
    }

    // return the result in accordance with a given choice
    public String getProcessedString(int input, String string) throws IllegalArgumentException {
        String result = "Illegal input.";

        switch (input) {
            default: throw new IllegalArgumentException(result);
            case 1: result = sha(string); break;
            case 2: result = na(string); break;
            case 3: result = shaNaNa(string); break;
            case 4: result = ava(string); break;
        }

        return result;
    }

    // add sha to the beginning of every word
    private String sha(String string) {
        int inputLength = string.length();
        int index;
        StringBuilder result = new StringBuilder();

        index = 0;
        while (index < inputLength) {
            //ignore blank spaces
            while (index < inputLength && string.charAt(index) == ' ') {
                index++;
            }

            // check if there is a word
            if (index < inputLength) {
                result.append("sha");
                // now locate the end of the word
                while (index < inputLength && string.charAt(index) != ' ') {
                    result.append(string.charAt(index));
                    index++;
                }
            }

            result.append(" ");
        }

        return result.toString();
    }

    // add na to the end of every word
    private String na(String string) {
        String punctuation = ""; // punctuation mark at the end of a word, if exists
        final String PUNCTUATION_IDENTIFIER = "[!.?,:;]"; // pattern for punctuation marks
        int inputLength = string.length();
        int index;
        StringBuilder result = new StringBuilder();

        index = 0;
        while (index < inputLength) {
            //ignore blank spaces
            while (index < inputLength && string.charAt(index) == ' ') {
                index++;
            }

            // check if there is a word
            if (index < inputLength) {
                // now locate the end of the word
                while (index < inputLength && string.charAt(index) != ' ') {
                    punctuation = Character.toString(string.charAt(index));
                    if (!punctuation.matches(PUNCTUATION_IDENTIFIER)) {
                        result.append(string.charAt(index));
                    }
                    index++;
                }
                if (punctuation.matches(PUNCTUATION_IDENTIFIER)) {
                    result.append("na");
                    result.append(punctuation);
                } else {
                    result.append("na");
                }
            }

            result.append(" ");
        }

        return result.toString();
    }

    private String shaNaNa(String string) {
        String punctuation = ""; // punctuation mark at the end of a word, if exists
        final String PUNCTUATION_IDENTIFIER = "[!.?,:;]"; // pattern for punctuation marks
        int inputLength = string.length();
        int index;
        StringBuilder result = new StringBuilder();

        index = 0;
        while (index < inputLength) {
            //ignore blank spaces
            while (index < inputLength && string.charAt(index) == ' ') {
                index++;
            }

            // check if there is a word
            if (index < inputLength) {
                result.append("sha");
                // now locate the end of the word
                while (index < inputLength && string.charAt(index) != ' ') {
                    punctuation = Character.toString(string.charAt(index));
                    if (!punctuation.matches(PUNCTUATION_IDENTIFIER)) {
                        result.append(string.charAt(index));
                    }
                    index++;
                }
                if (punctuation.matches(PUNCTUATION_IDENTIFIER)) {
                    result.append("nana");
                    result.append(punctuation);
                } else {
                    result.append("nana");
                }
            }

            result.append(" ");
        }

        return result.toString();
    }

    private String ava(String string) {
        String punctuation = ""; // punctuation mark at the end of a word, if exists
        final String PUNCTUATION_IDENTIFIER = "[!.?,:;]"; // pattern for punctuation marks
        int inputLength = string.length();
        int index;
        char firstLetter;
        StringBuilder result = new StringBuilder();

        index = 0;
        while (index < inputLength) {
            //ignore blank spaces
            while (index < inputLength && string.charAt(index) == ' ') {
                index++;
            }

            // check if there is a word
            if (index < inputLength) {
                firstLetter = string.charAt(index);
                index++;
                // now locate the end of the word
                while (index < inputLength && string.charAt(index) != ' ') {
                    punctuation = Character.toString(string.charAt(index));
                    if (!punctuation.matches(PUNCTUATION_IDENTIFIER)) {
                        result.append(string.charAt(index));
                    }
                    index++;
                }
                result.append(firstLetter);
                if (punctuation.matches(PUNCTUATION_IDENTIFIER)) {
                    result.append("ava");
                    result.append(punctuation);
                } else {
                    result.append("ava");
                }
            }

            result.append(" ");
        }

        return result.toString();
    }
}