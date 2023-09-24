/*
Another simple sorting algorithm is called an insertion sort. Suppose we
have a sorted list of N elements and we need to insert a new element X into
this list to create a sorted list of N  1 elements. We can insert X at the correct
position in the list by comparing it with elements list[N  1], list[N  2],
list[N  3], and so forth. Every time we compare X and list[i], we shift
list[i] one position to list[i  1] if X is smaller than list[i]. When we find
list[i] that is smaller than X, we put X at position i  1 and stop. We
can apply this logic to sort an unordered list of N elements. We start with a
sorted list of one element and insert the second element to create a sorted
list of two elements. Then we add the third element to create a sorted list of
three elements. Figure 11.18 illustrates the steps in the insertion sort. Write
a program that implements the insertion sort algorithm. You may simplify
the method by sorting only integers.
*/


package Ch11.Ch11Lvl2;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        Insertion insertion = new Insertion();
        int[] number = new int[]{1, 3, 12, 4, 6, 2, 2};

        System.out.println(Arrays.toString(insertion.sort(number)));
    }
}

class Insertion {
    // data members

    // constructors
    public Insertion() {

    }

    public int[] sort(int[] number) {

        for (int i = 1; i < number.length; i++) {
            int temp = number[i];
            int j = i - 1;

            while (j >= 0 && number[j] > temp) {
                number[j+1] = number[j];
                j--;
            }

            number[j+1] = temp;
        }

        return number;
    }
}