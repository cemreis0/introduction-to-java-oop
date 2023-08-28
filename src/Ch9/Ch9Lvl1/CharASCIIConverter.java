package Ch9.Ch9Lvl1;

import java.util.Scanner;

public class CharASCIIConverter {
    /*
     * Write a program that reads in a character and displays the character’s ASCII.
     * Accept the input as a string data and check the first character. Display an
     * error message if more than one character is entered. Repeat the operation
     * until the symbol @ (ASCII 64) is entered.
     */

    // data members
    Scanner scanner;

    // constructors
    public CharASCIIConverter() {
        scanner = new Scanner(System.in);
    }

    // main method
    public static void main(String[] args) {
        CharASCIIConverter converter = new CharASCIIConverter();
        converter.start();
    }

    // starts the program loop
    public void start() {
        char ch;
        int ascii;

        while (true) {
            try {
                ch = getInput();
                if (ch == '@') {
                    break;
                }
                ascii = getASCII(ch);
                System.out.println("The ASCII code for the character " + ch + " is " + ascii);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // returns the ASCII code for a given char
    private int getASCII(char ch) {
        return ch;
    }

    // get input from the user
    private char getInput() throws IllegalArgumentException {
        String str = "";
        char ch;

        System.out.print("Enter a character: ");
        str = scanner.next();

        if (str.length() != 1) {
            throw new IllegalArgumentException("Character length must be 1");
        }

        // get the char from the string
        ch = str.charAt(0);
        return ch;
    }
}
