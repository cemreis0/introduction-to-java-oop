/*
    A perfect number is a positive integer that is equal to the sum of its proper
    divisors. A proper divisor is a positive integer other than the number itself
    that divides the number evenly (i.e., no remainder). For example, 6 is a
    perfect number because the sum of its proper divisors 1, 2, and 3 is equal
    to 6. Eight is not a perfect number because 1 + 2 + 4 != 8 . Write a
    program that accepts a positive integer and determines whether the number
    is perfect. Also, display all proper divisors of the number. Try a number
    between 20 and 30 and another number between 490 and 500.
*/

package Ch6.Ch6Lvl2;

import java.util.Scanner;

public class PerfectNumber {
    // data members

    // constructor
    public PerfectNumber() {

    }

    // main method
    public static void main(String[] args) {
        int number;

        Scanner scanner = new Scanner(System.in);
        PerfectNumber perfectNumber = new PerfectNumber();

        System.out.print("Enter a number to check if it's a perfect number: ");
        number = scanner.nextInt();

        System.out.println(perfectNumber.isPerfect(number));
    }

    // check if the given number is a perfect number
    public boolean isPerfect(int number) {
        boolean perfect;
        int sumOfDivisors = 0; // add up the divisors of the number

        perfect = false;

        for (int i = 1; i <= (number/2); i++) {
            if (number % i == 0) {
                sumOfDivisors += i;
            }
        }

        if (sumOfDivisors == number) {
            perfect = true;
        }

        return perfect;
    }
}
