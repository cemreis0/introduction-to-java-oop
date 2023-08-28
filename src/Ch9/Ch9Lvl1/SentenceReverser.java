package Ch9.Ch9Lvl1;

import java.util.Scanner;

public class SentenceReverser {
    /*
     * Write a program that reads a sentence and prints out the sentence in reverse
     * order using the reverse method of the StringBuffer class. For example, the
     * method will display
     * ?uoy era woH
     * for the input
     * How are you?
     * Repeat the operation until an empty string is entered.
     */

    // data members
    Scanner scanner;

    // constructors
    public SentenceReverser() {
        scanner = new Scanner(System.in);
    }

    // main method
    public static void main(String[] args) {
        SentenceReverser reverser = new SentenceReverser();
        reverser.start();
    }

    // start the program loop
    public void start() {
        String sentence, reversed;

        while (true) {
            sentence = getInput();

            if (sentence.equals("")) {
                scanner.nextLine();
                break;
            }

            reversed = reverse(sentence);

            System.out.println("Input sentence: " + sentence);
            System.out.println("Reversed sentence: " + reversed);
            System.out.println();
        }
    }

    // reverse a given string
    private String reverse(String str) {
        StringBuilder reversedStringBuilder = new StringBuilder(str);
        reversedStringBuilder.reverse();
        return reversedStringBuilder.toString();
    }

    // get input from the user
    private String getInput() {
        String sentence;

        System.out.println("Enter a sentence:");
        sentence = scanner.nextLine();

        return sentence;
    }
}
