// Chapter 6 Sample Program: Time the performance of gcd methods

package Ch6;

import java.util.*;

public class Ch6TimeGcd {
    // data members
    private static enum ComputationType {BRUTE_FORCE, EUCLIDEAN}
    private Scanner scanner;

    // main method
    public static void main(String[] args) {
        Ch6TimeGcd timer = new Ch6TimeGcd();
        timer.start();
        System.exit(0);
    }

    // constructor
    public Ch6TimeGcd() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        long bruteForceTime, euclideanTime;
        int m, n;

        while (isContinue()) {
            m = getPositiveInteger();
            n = getPositiveInteger();

            // time the brute force method
            bruteForceTime = calculateTime(m, n, ComputationType.BRUTE_FORCE);

            // time the Euclidean method
            euclideanTime = calculateTime(m, n, ComputationType.EUCLIDEAN);

            System.out.println(
                    "m: " + m + "\n" +
                    "n: " + n + "\n" +
                    "Brute force time: " + bruteForceTime + "\n" +
                    "Euclidean time: " + euclideanTime
            );
        }
    }

    private boolean isContinue() {
        String input;
        boolean response = false;

        System.out.println("Run test? (Yes - y, No - n)");
        input = scanner.next();

        if (input.equals("Y") || input.equals("y")) {
            response = true;
        }

        return response;
    }

    private long calculateTime(int m, int n, ComputationType type) {
        Date startTime, endTime;
        startTime = new Date();
        if (type == ComputationType.BRUTE_FORCE) {
            gcdBruteForce(m, n);
        } else {
            gcdEuclidean(m, n);
        }
        endTime = new Date();
        return (endTime.getTime() - startTime.getTime());
    }

    private int getPositiveInteger(){
        int input;

        while (true) {
            System.out.print("Enter positive integer (0 is okay): ");
            input = scanner.nextInt();

            if (input >= 0) break;

            System.out.println("Input must be 0 or more");
        }

        return input;
    }

    private static int gcdBruteForce(int m, int n) {
        // m, n >= 0
        int last = Math.min(m, n);
        int gcd = 1;
        int i = 1;

        while (i <= last) {
            if (m % i == 0 && n % i == 0) {
                gcd = i;
            }
            i++;
        }

        return gcd;
    }

    private static int gcdEuclidean(int m, int n) {
        // m, n >= 0
        int max = Math.max(m, n),
            min = Math.min(m, n),
            remainder = max % min;

        while (remainder != 0) {
            max = min;
            min = remainder;
            remainder = max % min;
        }

        return min;
    }
}
