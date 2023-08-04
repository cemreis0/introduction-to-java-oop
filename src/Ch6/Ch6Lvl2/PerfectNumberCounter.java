/*
    Write a program that lists all perfect numbers between 6 and N, an upper
    limit entered by the user. After you verify the program with a small number
    for N, gradually increase the value for N and see how long the program takes
    to generate the perfect numbers. Since there are only a few perfect numbers,
    you might want to display the numbers that are not perfect, so you can easily
    tell that the program is still running .
*/

package Ch6.Ch6Lvl2;

import java.util.*;

public class PerfectNumberCounter {
    // data members
    private static final int UPPER_BOUND_MINIMUM = 7;
    private static final int LOWER_BOUND = 6;
    Scanner scanner;
    PerfectNumber perfectNumber;

    // constructor
    public PerfectNumberCounter() {
        scanner = new Scanner(System.in);
        perfectNumber = new PerfectNumber();
    }

    // main methods
    public static void main(String[] args) {
        PerfectNumberCounter perfectNumberCounter = new PerfectNumberCounter();
        perfectNumberCounter.start();
        System.exit(0);
    }

    // start the program
    public void start() {
        int number; // number passed to listPerfectNumbers

        describeProgram();
        number = getInteger();
        listPerfectNumbers(number);
    }

    // list all perfect numbers in a given range
    private void listPerfectNumbers(int number) {
        double percentage = 0.1;

        for (int i = LOWER_BOUND; i <= number; i++) {

            if (perfectNumber.isPerfect(i)) {
                System.out.println(i + " is a perfect number.");
            }

            if (i == Math.floor((number - LOWER_BOUND) * percentage)) {
                System.out.println("----- %" + Math.round(percentage * 100) + " DONE -----");
                percentage += 0.1;
            }
        }
    }

    // describe the program
    private void describeProgram() {
        System.out.println("This program displays the perfect numbers between 6 and N.");
        System.out.println("N is the given number.");
        System.out.println("A perfect number is a number that is the sum of its proper divisors.");
        System.out.println("You need to enter an upper bound that is greater than 6." + "\n");
    }

    // get an integer greater than 6 from the user
    private int getInteger() {
        int number; // number received from the user

        do {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();

            if (number < UPPER_BOUND_MINIMUM) {
                System.out.println("You must enter a number greater than " + UPPER_BOUND_MINIMUM + ".");
            }

        } while (number < UPPER_BOUND_MINIMUM);

        return number;
    }
}
