/*
Write a program that displays all integers between low and high that are the
sum of the cube of their digits. In other words, find all numbers xyz such that
    xyz = x^3 + y^3 + z^3.
For example,
    153 = 1^3 + 5^3 + 3^3
Try 100 for low and
1000 for high.
*/

package Ch6.Ch6Lvl2;

import java.util.Scanner;

public class CubeSumCounter {
    // data members

    // constructor
    public CubeSumCounter() {

    }

    // main method
    public static void main(String[] args) {
        int low, high;

        CubeSumCounter cubeSumCounter = new CubeSumCounter();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter lower boundary of the range: ");
        low = scanner.nextInt();
        System.out.print("Enter higher boundary of the range: ");
        high = scanner.nextInt();

        System.out.println();
        System.out.print("The count is: " + cubeSumCounter.count(low, high));
    }

    // count the numbers that are equal to their sum of the cube of their digits
    public int count(int lowNumber, int highNumber) {
        int cubeSumCount = 0;

        for (int i = lowNumber; i < highNumber; i++) {
            if (isCubeSumEqual(i)) {
                cubeSumCount++;
            }
        }

        return  cubeSumCount;
    }

    // check if the given number equals to its cube sum
    private boolean isCubeSumEqual(int number) {
        return number == getCubeSum(number);
    }

    // calculate the cube sum of the given number
    private int getCubeSum(int number) {
        int cubeSum = 0; // sum of the cubes of each digit of the given number

        // approach to the calculation:
        // assume xyz is the number. divide xyz by 10, get z; then divide xyz by 10 and get xy. and so on.
        // do this until x is divided by 10 gets less than 1, then the loop is terminated.
        final int DIVISOR = 10;

        boolean isDivisible = true; // when the leftmost digit is divided by 10 and gets less than 1, terminate the loop

        do {
            cubeSum += Math.pow((number % DIVISOR), 3);
            number /= DIVISOR;

            if (1 > number) {
                isDivisible = false;
            }

        } while (isDivisible);

        return cubeSum;
    }
}
