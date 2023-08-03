/*
 * Program to print out the numbers 10 through 49 in the following manner:
 * 10 11 12 13 14 15 16 17 18 19
 * 20 21 22 23 24 25 26 27 28 29
 * 30 31 32 33 34 35 36 37 38 39
 * 40 41 42 43 44 45 46 47 48 49
 *
 * This code can be extended easily to handle any range of values.
 * Two approaches are provided: using nested for loops or modulo arithmetic.
 */

// Approach 1: Using nested for loops
// Start with 'i' at 10 and iterate until 49 (inclusive).
// Print each value of 'i' followed by a space.
// After each iteration, check if (i - 9) % 10 == 0, which means it's the last value of the line (i.e., 19, 29, 39, etc.).
// If it is, print a new line to move to the next row.

// Approach 2: Using modulo arithmetic
// Define the starting and ending values (start = 10, end = 49) and the number of columns (columnWidth = 10).
// Use a for loop to iterate from start to end (inclusive).
// Print each value of 'i' followed by a space.
// After each iteration, check if i % columnWidth == columnWidth - 1, which means it's the last value of the line.
// If it is, print a new line to move to the next row.


package Ch6.Ch6Lvl1;

import java.util.*;

public class NumberTable {
    // data members
    Scanner scanner;
    int startNumber, endNumber; // starting and ending number of the table

    // constructor
    public NumberTable() {
        scanner = new Scanner(System.in);
    }

    // main method
    public static void main(String[] args) {
        NumberTable numberTable = new NumberTable();
        numberTable.start();
        System.exit(0);
    }

    // start the program
    public void start() {
        startNumber = 0; // reset the starting number each time the program starts
        endNumber = 0;
        boolean repeat;
        repeat = prompt("Would you like to create a table of numbers?");

        while (repeat) {
            startNumber = getInteger("Enter the starting number: ");
            endNumber = getInteger("Enter the ending number: ");
            createTable(startNumber, endNumber);
            repeat = prompt("Would you like to create another table of numbers?");
        }

        System.out.print("Thanks.");
    }

    // get response from the user as to continue the program loop
    private boolean prompt(String request) {
        String input;
        boolean repeat;

        repeat = false;

        System.out.print(request + " (Yes - y, No - n): ");

        input = scanner.next();

        if (input.equals("Y") || input.equals("y")) {
            repeat = true;
        }

        return repeat;
    }

    // get an integer from the user
    private int getInteger(String request) {
        int number;
        System.out.print(request);
        number = scanner.nextInt();
        return number;
    }

    // create the table of numbers
    private void createTable(int start, int end) {
        String firstRowBlank = "%" + (start % 10) * 8 + "s"; // space given when the start number is other than a multiple of 10
        System.out.format(firstRowBlank, " ");

        for (int i = start; i <= end; i++) {
            System.out.format("%8d", i);
            if (i % 10 == 9) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
