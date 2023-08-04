/*
 * This Java program takes a positive integer N (N >= 2) as input and displays the number of prime numbers
 * between 2 and N (inclusive).
 *
 * For example, between 2 and 100, there are 25 prime numbers: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
 * 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.
 *
 * Similarly, between 2 and 10,000, there are 1229 prime numbers.
 *
 * The program uses the timing technique from Section 6.9 to measure the time it takes to compute the result.
 * It records the start time before the computation begins and the end time after the computation is done.
 * The elapsed time is then calculated and displayed, providing insights into the efficiency of the program.
*/

package Ch6.Ch6Lvl2;

import java.util.*;

public class PrimeNumberCounter {
    // data members
    Scanner scanner;

    // constructor
    public PrimeNumberCounter() {
        scanner = new Scanner(System.in);
    }

    // main method
    public static void main(String[] args) {
        PrimeNumberCounter primeNumberCounter = new PrimeNumberCounter();
        primeNumberCounter.start();
    }

    // start the program to get input from the user, calculate the number of primes and display the output
    public void start() {
        int number; // number passed to the method count
        int numberOfPrimes; // number of primes counted using method count
        int numberOfPrimesLn; // // number of primes counted using method countLn

        Timer timer = new Timer();
        long startTime, endTime; // timer points
        long timeTaken; // time it takes to complete the count, unit: ms

        long startTimeLn, endTimeLn; // timer points of the natural logarithm counting method
        long timeTakenLn; // time it takes to estimate the count, using natural logarithm, unit: ms

        describeProgram();
        number = getInteger();

        startTime = timer.start();
        numberOfPrimes = count(number);
        endTime = timer.end();
        timeTaken = endTime - startTime;

        startTimeLn = timer.start();
        numberOfPrimesLn = countLn(number);
        endTimeLn = timer.end();
        timeTakenLn = endTimeLn - startTimeLn;

        System.out.println();
        System.out.println("There are " + numberOfPrimes + " prime numbers between 2 and " + number + ".");
        System.out.println("It took " + timeTaken + " ms to count." + "\n");

        System.out.println("Using the natural logarithm estimation method, there are " + numberOfPrimesLn +
                " prime numbers between 2 and " + number + ".");
        System.out.print("It took " + timeTakenLn + " ms to estimate.");
    }

    // count the number of primes
    private int count(int number) {
        int numberOfPrimes = 0;
        for (int i = 2; i <=number; i++) {
            if (isPrime(i)) {
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }

    // count the number of primes using the natural logarithm approach
    private int countLn(int number) {
        double numberOfPrimes = 0;
        numberOfPrimes = number / Math.log(number);
        return (int) numberOfPrimes;
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

    // get an integer greater than 2 from the user
    private int getInteger() {
        int number; // number received from the user
        do {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();

            if (number < 3) {
                System.out.println("You must enter a number greater than 2.");
            }

        } while (number < 3);

        return number;
    }

    // describe the program
    private void describeProgram() {
        System.out.println("This program counts the number of  first N prime numbers. N is the number given.");
    }
}

class Timer {
    // constructor
    public Timer() {

    }

    public long start() {
        Date startTime = new Date();
        return startTime.getTime();
    }

    public long end() {
        Date startTime = new Date();
        return startTime.getTime();
    }
}