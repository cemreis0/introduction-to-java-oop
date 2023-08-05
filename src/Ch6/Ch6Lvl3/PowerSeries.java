/*
 * To compute sin(x) and cos(x) using power series, we can use the following series expansions:
 *
 * 1. sin(x) = x - (x^3)/3! + (x^5)/5! - (x^7)/7! + ...
 * 2. cos(x) = 1 - (x^2)/2! + (x^4)/4! - (x^6)/6! + ...
 *
 * In this Java program, we will use the double data type to represent the values of x and the
 * calculated sin(x) and cos(x). We will increase the number of terms in the series until an overflow
 * occurs, which can be checked by comparing the value against Double.POSITIVE_INFINITY.
 *
 * The program will then compare the results obtained from the power series to the values returned
 * by the sin() and cos() methods of the Math class for validation.
 */

package Ch6.Ch6Lvl3;

import java.util.Scanner;

public class PowerSeries {
    // data members

    // constructor
    public PowerSeries() {

    }

    // main method
    public static void main(String[] args) {
        double sinRadians, cosRadians;

        PowerSeries powerSeries = new PowerSeries();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter degree radians for the sine function: ");
        sinRadians = scanner.nextDouble();
        System.out.println("sin(" + sinRadians + ") is approximately " + powerSeries.sin(sinRadians));

        System.out.print("Enter degree radians for the cos function: ");
        cosRadians = scanner.nextDouble();
        System.out.println("cos(" + cosRadians + ") is approximately " + powerSeries.cos(cosRadians));
    }

    // calculate sin n
    public double sin(double n) {
        double value = 0; // the sin value
        int power = 1; // start with 1, increment by 2 each time a new term is added to the formula

        // the formula goes on like this: x - y + z, so the symbol is changed for every other term,
        // so we need a multiplier that is updated each time the loop is iterated over
        int multiplier = 1;

        for (int i = 1; i <= 17; i++) {
            value += (multiplier * Math.pow(n, power)) / factorial(power);

            // update the power of x and the symbol of x
            power += 2;
            multiplier *= -1;
        }
        return value;
    }

    // calculate sin n
    public double cos(double n) {
        double value = 0; // the sin value
        int power = 0; // start with 0, increment by 2 each time a new term is added to the formula

        // the formula goes on like this: x - y + z, so the symbol is changed for every other term,
        // so we need a multiplier that is updated each time the loop is iterated over
        int multiplier = 1;

        for (int i = 1; i <= 17; i++) {
            value += (multiplier * Math.pow(n, power)) / factorial(power);

            // update the power of x and the symbol of x
            power += 2;
            multiplier *= -1;
        }
        return value;
    }

    // get the factorial of given N
    private int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

}
