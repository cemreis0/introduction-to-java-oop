/*
Consider the following property about the bubble sort:
If the last exchange made in some pass occurs at the Jth and
(J + 1)st positions, then all elements from the (J + 1)st to the Nth
positions are in their correct location.
Improve the bubble sort algorithm by incorporating this property. Write a
test program to verify the correct implementation of the modified bubble sort
algorithm.
*/

/*
Consider another property about the bubble sort:
If the first exchange made in some pass occurs at the Ith and
(I + 1)st positions, then all elements from the 1st to (I - 1)st
positions are in ascending order.
Improve the bubble sort algorithm by incorporating this property. Write a test
program to verify the correct implementation of the modified bubble sort
algorithm.
*/

package Ch11.Ch11Lvl3;

import java.util.Arrays;

public class ImprovedBubbleSort {
    public static void main(String[] args) {
        int[] array = {10, 25, 6, 48, 32, 17, 5, 39, 21, 8, 14, 29, 37, 2, 43, 11, 31, 19, 1, 50};

        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] number) {
        int     temp,
                bottom,
                lastExchange = 0,
                firstExchange, // initialize to -1 (indicating no exchange)
                startIndex = 0;
        boolean exchanged = true;
        int comparisons = 0;

        bottom = number.length - 2;

        while (exchanged) {
            exchanged = false;
            firstExchange = -1;

            for (int i = startIndex; i <= bottom; i++) {
                comparisons++;
                if (number[i] > number[i + 1]) {
                    temp = number[i]; //exchange
                    number[i] = number[i + 1];
                    number[i + 1] = temp;
                    exchanged = true; //exchange is made
                    lastExchange = i;

                    if (firstExchange == -1) {
                        firstExchange = i;
                    }
                }
            }

            if (firstExchange != -1 && firstExchange != 0) {
                startIndex = firstExchange - 1;
            }

            bottom = lastExchange;
        }

        System.out.println("comparisons: " + comparisons);
    }
}
