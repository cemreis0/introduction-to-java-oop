import Ch4.Ch4LoanCalculator.Ch4LoanCalculator;
import Ch5.Ch5DevEx.Ch5DevEx;

import java.util.*;

public class TheForStatement {
    public static void main(String[] args) {
        qc1();
        qc2();
        nestedForLoop();
    }

    public static void qc1() {
        /*
        Write a for loop to compute the following.
        a. Sum of 1, 2, . . . , 100
        b. Sum of 2, 4, . . . , 500
        c. Product of 5, 10, . . . , 50
        */

        int sum1 = 0;

        for (int i = 1; i <= 100; i++) {
            sum1 += i;
        }
        System.out.println(sum1);

        int sum2 = 0;

        for (int i = 2; i <= 500; i += 2) {
            sum2 += i;
        }
        System.out.println(sum2);

        int sum3 = 0;

        for (int i = 5; i <= 50; i += 5) {
            sum3 += i;
        }
        System.out.println(sum3);
    }

    public static void qc2() {
        /*
        Rewrite the following while loops as for statements.
        a. int count = 0, sum = 0;
        while ( count < 10 ) {
            sum += count;
            count++;
        }
        b. int count = 1, sum = 0;
        while ( count <= 30 ) {
            sum += count;
            count += 3;
        }
        */

        int sum1 = 0;

        for (int i = 0; i < 10; i++) {
            sum1 += i;
        }

        System.out.println(sum1);

        int sum2 = 0;

        for (int i = 1; i <= 30; i += 3) {
            sum2 += i;
        }

        System.out.println(sum2);
    }

    // nested for loops
    public static void nestedForLoop() {
        int price;

        System.out.print("       5    10   15   20   25");
        System.out.println();

        for (int width = 11; width <= 20; width++) {
            System.out.print(width + "   ");

            for (int length = 5; length <= 25; length += 5) {
                price = width * length * 19; // $19 per sq ft.
                System.out.print(" " + price);
            }

            // finished one row; now move on to the next row
            System.out.println("");
        }
    }
}
