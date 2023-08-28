/*
 * UppercaseCounterProgram class:
 * This program counts the number of uppercase letters in an input string.
 * It utilizes the isUpperCase class method from the Character class.
 * The isUpperCase method returns true if the given character is an uppercase letter.
 * The user is prompted to input strings, and the program repeats the counting operation
 * until an empty string is entered.
 */

package Ch9.Ch9Lvl2;

import java.util.Scanner;

public class UpperCaseCounterMain {
    // data members
    public Scanner scanner;

    // constructors
    public UpperCaseCounterMain() {
        scanner = new Scanner(System.in);
    }

    // main method
    public static void main(String[] args) {
        UpperCaseCounterMain upperCaseCounterMain = new UpperCaseCounterMain();
        upperCaseCounterMain.start();
    }


    // start the program loop
    public void start() {
        String string;
        UpperCaseCounter uppercaseCounter;

        while (true) {

            string = getInput("Enter text (<STOP> to exit):");

            if (string.equals("STOP")) {
                System.out.println("Goodbye.");
                break;
            }

            uppercaseCounter = new UpperCaseCounter(string);

            System.out.println("Text: " + string);
            System.out.println("Number of upper case letters: " + uppercaseCounter.getUpperCaseCount());
            System.out.println("Number of upper case letters (using ASCII code): " + uppercaseCounter.getUpperCaseCountASCII());
        }
    }

    public String getInput(String prompt) {
        String string;

        System.out.println(prompt);
        string = scanner.nextLine();

        return string;
    }
}

class UpperCaseCounter {
    // data members
    private String string;

    // constructors
    public UpperCaseCounter() {
        this("");
    }
    public UpperCaseCounter(String string) {
        this.string = string;
    }

    // methods
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getUpperCaseCount() {
        int count = 0;
        int length = string.length();
        char letter;

        for (int i = 0; i < length; i++) {
            letter = string.charAt(i);

            if (Character.isUpperCase(letter)) {
                count++;
            }
        }

        return count;
    }

    // count the number of upper case letters using ascii code
    public int getUpperCaseCountASCII() {
        int count = 0;
        int length = string.length();
        char letter;

        for (int i = 0; i < length; i++) {
            letter = string.charAt(i);

            if (letter >= 65 && letter <= 90) {
                count++;
            }
        }

        return count;
    }
}