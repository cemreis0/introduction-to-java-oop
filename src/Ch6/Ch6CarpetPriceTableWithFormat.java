// Chapter 6 Sample Program: Sample formatting statements

package Ch6;

import java.util.*;

public class Ch6CarpetPriceTableWithFormat {
    public static void main(String[] args) {
        int price;

        // print out the column labels
        System.out.format("%37s", "LENGTH");
        System.out.println("\n\n");
        System.out.format("%15s", " "); // space for row labels

        for (int colLabel = 5; colLabel <= 25; colLabel += 5) {
            System.out.format("%8d", colLabel);
        }

        System.out.println("\n");

        for (int width = 5; width <= 14; width++) {
            if (width == 10) {
                System.out.print("WIDTH");
                System.out.format("%7s", " ");
            } else {
                System.out.format("%12s", " ");
            }
            System.out.format("%3d", width);


            for (int length = 5; length <= 25; length += 5){
                price = width * length * 3;
                System.out.format("%8d", price);
            }

            System.out.println();
        }
    }
}
