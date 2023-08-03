/*
    A prime number is an integer greater than 1 and divisible by only itself and
    1. The first seven prime numbers are 2, 3, 5, 7, 11, 13, and 17. Write a
    method that returns true if its parameter is a prime number. Using this
    method, write a program that repeatedly asks the user for input and displays
    Prime if the input is a prime number and Not Prime, otherwise. Stop the
    repetition when the input is a negative number.
*/

package Ch6.Ch6Lvl1;

import java.util.*;

public class PrimeNumber {
    // data members
    Scanner scanner;
    int potentialPrimeNumber;

    // constructor
    public PrimeNumber() {
        scanner = new Scanner(System.in);
    }

    // main method
    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        primeNumber.start();
        System.exit(0);
    }

    // start the program
    public void start() {
        potentialPrimeNumber = 0; // reset the value each time the program starts
        boolean repeat;

        repeat = prompt("Would you like to check if a number is a prime number?");

        while (repeat) {
            potentialPrimeNumber = getPositiveInteger();
            if (isPrime(potentialPrimeNumber)) {
                System.out.println(potentialPrimeNumber + " is a prime number.");
            } else {
                System.out.println(potentialPrimeNumber + " is not a prime number.");
            }
            repeat = prompt("Would you like to check if another number is a prime number?");
        }
        System.out.print("Thanks.");
    }

    // get a positive integer from the user
    private int getPositiveInteger() {
        int number;

        do {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();

            if (number < 2) {
                System.out.println("There is not a prime number less than 2.");
            }

        } while (number < 2);

        return number;
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

    // check if the number is a prime number
    private boolean isPrime(int number) {
        boolean prime = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }

        return prime;
    }
}
