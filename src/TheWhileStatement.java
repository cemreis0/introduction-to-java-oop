import java.util.Scanner;

public class TheWhileStatement {
    public static void main(String[] args) {
        // Suppose we want to compute the sum of the first 100 positive integers 1, 2, . . . , 100.
        // Here’s how we compute the sum, using a while statement:

        int sum = 0, number = 1;
        while (number <= 1000000) {
            sum += number;
            number++;
        }

        System.out.println(sum);

        int product = 1, oddNumber = 1, count = 20, lastNumber;
        lastNumber = 2 * count - 1;
        while (oddNumber <= lastNumber) {
            product *= oddNumber;
            oddNumber += 2;
        }

        System.out.println(product);

        gcdBruteForce(15, 20);
        gcdEuclidean(18, 26);

        qc1();
        qc2();
    }

    private static void improvingUserInterface() {
        Scanner scanner = new Scanner(System.in);
        int age;
        System.out.print("Your Age (between 0 and 130): ");
        age = scanner.nextInt();
        while (age < 70 || age > 130) {
            System.out.println(
                    "An invalid age was entered. Please try again.");
            System.out.print ("Your Age (between 0 and 130): ");
            age = scanner.nextInt();
        }
    }

    private static void gcdBruteForce(int m, int n) {
        // assume m, n >= 1
        int last = Math.min(m, n);
        int gcd = 1;
        int i = 1;

        while (i <= last) {
            if (m % i == 0 && n % i == 0) {
                gcd = i;
            }
            i++;
        }

        System.out.println(gcd);
    }

    private static void gcdEuclidean(int m, int n) {
        int max = Math.max(m, n),
        min = Math.min(m, n),
        remainder = max % min;

        while (remainder != 0) {
            max = min;
            min = remainder;
            remainder = max % min;
        }

        System.out.println(min);
    }

    private static void qc1() {
        /*
        Write while statement to add numbers 11 through 20. Is this a count-controlled or sentinel-controlled loop?
        Count controlled.
        */

        int i = 11, sum = 0;

        while (i <= 20) {
            sum += i;
            i++;
        }

        System.out.println(sum);
    }

    private static void qc2() {
        /*
         Write while statement to read in real numbers and stop when a negative
         number is entered. Is this a count-controlled or sentinel-controlled loop?
        */

        double i = 1;
        Scanner scanner = new Scanner(System.in);

        while (i > 0) {
            i = scanner.nextDouble();
        }
    }
}
